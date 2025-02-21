package academy.devdojo.maratonajava.javacore.ZZHpadroesDeProjeto.Test;

import academy.devdojo.maratonajava.javacore.ZZHpadroesDeProjeto.Dominio.Pessoa;

public class BuilderPatternTest01 {
    public static void main(String[] args) {
        Pessoa pessoa = Pessoa.PessoaBuilder
                .builder()
                .primeiroNome("Wadson")
                .sobrenome("Ferreira")
                .apelido("Slix")
                .email("wadson@gmail.com")
                .build();

        System.out.println(pessoa);
    }
}
