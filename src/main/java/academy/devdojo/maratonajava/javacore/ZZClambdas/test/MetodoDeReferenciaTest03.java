package academy.devdojo.maratonajava.javacore.ZZClambdas.test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Function;

//Reference to an instance method of an arbitrary object of a particular type
public class MetodoDeReferenciaTest03 {
    public static void main(String[] args) {
        List<String> nomes = new ArrayList<>(List.of("Wadson", "Rute", "Ferreira", "Rocha"));
        nomes.sort(String::compareTo);
        System.out.println(nomes);

        Function<String, Integer> numStringParserInteger = Integer::parseInt;
        System.out.println(numStringParserInteger.apply("123"));

        BiPredicate<List<String>, String> checarNome = List::contains;
        System.out.println(checarNome.test(nomes, "Wadson"));
    }
}
