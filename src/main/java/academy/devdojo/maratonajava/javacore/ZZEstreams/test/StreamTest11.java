package academy.devdojo.maratonajava.javacore.ZZEstreams.test;

import academy.devdojo.maratonajava.javacore.ZZEstreams.dominio.LightNovel;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTest11 {
    private static List<LightNovel> lightNovels = new ArrayList<>(List.of(
            new LightNovel("Tensei Shittara", 8.99),
            new LightNovel("Overlord", 10.99),
            new LightNovel("Violet Evergarden", 5.99),
            new LightNovel("No Game no Life", 2.99),
            new LightNovel("Fullmetal Alchemist", 5.99),
            new LightNovel("Kumo Desuga", 1.99),
            new LightNovel("Kumo Desuga", 1.99),
            new LightNovel("Monogatari", 4.00)
    ));

    public static void main(String[] args) {
        System.out.println(lightNovels.stream().count());
        System.out.println(lightNovels.size());
        System.out.println(lightNovels.stream().collect(Collectors.counting()));

        lightNovels.stream()
                .max(Comparator.comparing(LightNovel::getPreco))
                .ifPresent(System.out::println);

        lightNovels.stream()
                .collect(Collectors.maxBy(Comparator.comparing(LightNovel::getPreco)))
                .ifPresent(System.out::println);

        System.out.println(lightNovels.stream().mapToDouble(LightNovel::getPreco).sum());

        System.out.println(lightNovels.stream().collect(Collectors.summingDouble(LightNovel::getPreco)));

        lightNovels.stream()
                .mapToDouble(LightNovel::getPreco)
                .average()
                .ifPresent(System.out::println);

        System.out.println(lightNovels.stream().collect(Collectors.averagingDouble(LightNovel::getPreco)));

        DoubleSummaryStatistics collect = lightNovels.stream().collect(Collectors.summarizingDouble(LightNovel::getPreco));
        System.out.println(collect);

        String titulos = lightNovels.stream().map(LightNovel::getTitulo).collect(Collectors.joining(", "));
        System.out.println(titulos);


    }
}
