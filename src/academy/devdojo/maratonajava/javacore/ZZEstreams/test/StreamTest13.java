package academy.devdojo.maratonajava.javacore.ZZEstreams.test;

import academy.devdojo.maratonajava.javacore.ZZEstreams.dominio.Categoria;
import academy.devdojo.maratonajava.javacore.ZZEstreams.dominio.LightNovel;
import academy.devdojo.maratonajava.javacore.ZZEstreams.dominio.Promocao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamTest13 {

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
        Map<Promocao, List<LightNovel>> collect = lightNovels.stream().collect(Collectors.groupingBy(ln -> {
            return ln.getPreco() < 6 ? Promocao.EM_PROMOCAO :
                    Promocao.PRECO_NORMAL;
        }));
        System.out.println(collect);

        Map<Categoria, Map<Promocao, List<LightNovel>>> collect1 = lightNovels
                .stream().collect(Collectors.groupingBy(LightNovel::getCategoria, Collectors.groupingBy(ln -> {
                    return ln.getPreco() < 6 ? Promocao.EM_PROMOCAO : Promocao.PRECO_NORMAL;
                })));
        System.out.println(collect1);

    }
}
