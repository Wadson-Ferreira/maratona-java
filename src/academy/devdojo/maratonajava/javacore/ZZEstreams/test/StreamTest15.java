package academy.devdojo.maratonajava.javacore.ZZEstreams.test;

import academy.devdojo.maratonajava.javacore.ZZEstreams.dominio.Categoria;
import academy.devdojo.maratonajava.javacore.ZZEstreams.dominio.LightNovel;
import academy.devdojo.maratonajava.javacore.ZZEstreams.dominio.Promocao;

import java.util.*;
import java.util.stream.Collectors;

public class StreamTest15 {

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
        Map<Categoria, DoubleSummaryStatistics> collect = lightNovels.stream()
                .collect(Collectors.groupingBy(LightNovel::getCategoria, Collectors.summarizingDouble(LightNovel::getPreco)));
        System.out.println(collect);

        System.out.println("------------------------------");

        Map<Categoria, Set<Promocao>> collect1 = lightNovels.stream()
                .collect(Collectors.groupingBy(LightNovel::getCategoria, Collectors.mapping(StreamTest15::getPromocao, Collectors.toSet())));
        System.out.println(collect1);

        System.out.println("----------------------------");

        Map<Categoria, LinkedHashSet<Promocao>> collect2 = lightNovels.stream()
                .collect(Collectors.groupingBy(LightNovel::getCategoria, Collectors.mapping(StreamTest15::getPromocao, Collectors.toCollection(LinkedHashSet::new))));
        System.out.println(collect2);
    }

    private static Promocao getPromocao(LightNovel ln) {
        return ln.getPreco() <6 ? Promocao.EM_PROMOCAO : Promocao.PRECO_NORMAL;
    }
}
