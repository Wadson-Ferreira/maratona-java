package academy.devdojo.maratonajava.javacore.ZZDoptional.test;

import java.util.List;
import java.util.Optional;

public class OptionalTest01 {
    public static void main(String[] args) {
        Optional<String> optional = Optional.of("Hello World");
        Optional<String> optional1 = Optional.ofNullable(null);
        Optional<String> optional2 = Optional.empty();
        System.out.println(optional);
        System.out.println(optional1);
        System.out.println(optional2);

        System.out.println("-----------------");

        Optional<String> nomeOptional = procurarNome("Wadson");
        String empty = nomeOptional.orElse("EMPTY");

        System.out.println(empty);

        nomeOptional.ifPresent(s -> System.out.println(s.toUpperCase()));

    }

    private static Optional<String> procurarNome(String nome) {
        List<String> lista = List.of( "Wadson", "DevDojo");
        int i = lista.indexOf(nome);
        if ( i != -1){
            return Optional.of(lista.get(i));
        }
        return Optional.empty();
    }
}
