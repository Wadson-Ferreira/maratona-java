package academy.devdojo.maratonajava.javacore.ZZEstreams.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class StreamTest04 {
    public static void main(String[] args) {
        List<List<String>> devDojo = new ArrayList<>();
        List<String> designerGrafico = List.of("Wildnei Suane", "Catarina " +
                "Santos", "Sandy Carolina");
        List<String> desenvolvedores = List.of("William", "David", "Harisson");
        List<String> estudantes = List.of("Wadson", "Édipo", "Gustavo Lima",
                "Guilherme" );
        devDojo.add(designerGrafico);
        devDojo.add(desenvolvedores);
        devDojo.add(estudantes);

        for (List<String> pessoas : devDojo) {
            for (String pessoa : pessoas) {
                System.out.println(pessoa);
            }
        }
        System.out.println("----------");

        devDojo.stream()
                .flatMap(Collection::stream).forEach(System.out::println);

        System.out.println("----------");

        devDojo.stream()
                .<String>mapMulti(Iterable::forEach)
                .forEach(System.out::println);

    }
}
