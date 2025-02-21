package academy.devdojo.maratonajava.javacore.ZZEstreams.test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTest05 {
    public static void main(String[] args) {
        List<String> palavras = List.of("Gomu", "Gomu", "No", "Mi");
        String[] letras = palavras.get((0)).split("");
        System.out.println(Arrays.toString(letras));

        System.out.println("--------");

        List<String[]> collect = palavras.stream()
                .map(p -> p.split("")).collect(Collectors.toList());

        List<String> letras2 = palavras.stream()
                .map(p -> p.split(""))
                .flatMap(Arrays::stream)
                .collect(Collectors.toList());
        System.out.println(letras2);

    }
}
