package academy.devdojo.maratonajava.javacore.ZZEstreams.test;

import academy.devdojo.maratonajava.javacore.ZZEstreams.dominio.LightNovel;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StreamTest06 {

    private static List<LightNovel> lightNovels = new ArrayList<>(List.of(
            new LightNovel("Tensei Shittara", 8.99),
            new LightNovel("Overlord", 3.99),
            new LightNovel("Violet Evergarden", 5.99),
            new LightNovel("No Game no Life", 2.99),
            new LightNovel("Fullmetal Alchemist", 5.99),
            new LightNovel("Kumo Desuga", 1.99),
            new LightNovel("Kumo Desuga", 1.99),
            new LightNovel("Monogatari", 4.00)
    ));


    public static void main(String[] args) {
        System.out.println(lightNovels.stream().anyMatch(ln -> ln.getPreco() > 8));
        System.out.println(lightNovels.stream().allMatch(ln -> ln.getPreco() > 0));
        System.out.println(lightNovels.stream().noneMatch(ln -> ln.getPreco() < 0));
        lightNovels.stream()
                .filter(ln -> ln.getPreco() >3)
                .findAny()
                .ifPresent(System.out::println);

        lightNovels.stream()
                .filter(ln -> ln.getPreco() > 3)
                .min(Comparator.comparing(LightNovel::getPreco))
                .ifPresent(System.out::println);

    }
}
