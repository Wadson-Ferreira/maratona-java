package academy.devdojo.maratonajava.javacore.ZZEstreams.test;

import academy.devdojo.maratonajava.javacore.ZZEstreams.dominio.Categoria;
import academy.devdojo.maratonajava.javacore.ZZEstreams.dominio.LightNovel;
import academy.devdojo.maratonajava.javacore.ZZEstreams.dominio.Promocao;

import java.util.*;
import java.util.stream.Collectors;

public class StreamTest14 {

    private static List<LightNovel> lightNovels = new ArrayList<>(List.of(
            new LightNovel("Tensei Shittara", 8.99, Categoria.FANTASIA),
            new LightNovel("Overlord", 10.99, Categoria.FANTASIA),
            new LightNovel("Violet Evergarden", 5.99, Categoria.DRAMA),
            new LightNovel("No Game no Life", 2.99, Categoria.FANTASIA),
            new LightNovel("Fullmetal Alchemist", 5.99, Categoria.FANTASIA),
            new LightNovel("Kumo Desuga", 1.99, Categoria.FANTASIA),
            new LightNovel("Kumo Desuga", 1.99, Categoria.FANTASIA),
            new LightNovel("Monogatari", 4.00, Categoria.ROMANCE)
    ));

    public static void main(String[] args) {
        Map<Categoria, Long> collect = lightNovels.stream().collect(Collectors.groupingBy(LightNovel::getCategoria, Collectors.counting()));
        System.out.println(collect);

        Map<Categoria, Optional<LightNovel>> collect1 = lightNovels.stream()
                .collect(Collectors.groupingBy
                        (LightNovel::getCategoria, Collectors.maxBy(Comparator.comparing(LightNovel::getPreco))));
        System.out.println(collect1);

        Map<Categoria, LightNovel> collect2 = lightNovels.stream().collect(Collectors.groupingBy(LightNovel::getCategoria, Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparing(LightNovel::getPreco)), Optional::get)));
        System.out.println(collect2);
    }
}
