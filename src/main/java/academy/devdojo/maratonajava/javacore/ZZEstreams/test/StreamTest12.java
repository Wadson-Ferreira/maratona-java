package academy.devdojo.maratonajava.javacore.ZZEstreams.test;

import academy.devdojo.maratonajava.javacore.ZZEstreams.dominio.Categoria;
import academy.devdojo.maratonajava.javacore.ZZEstreams.dominio.LightNovel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamTest12 {

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
        Map<Categoria, List<LightNovel>> categoriasLightNovelMap = new HashMap<>();
        List<LightNovel> fantasiaLightNovels = new ArrayList<>();
        List<LightNovel> dramaLightNovels = new ArrayList<>();
        List<LightNovel> romanceLightNovels = new ArrayList<>();
        for (LightNovel lightNovel : lightNovels) {
            switch (lightNovel.getCategoria()){
                case DRAMA: dramaLightNovels.add(lightNovel); break;
                case ROMANCE: romanceLightNovels.add(lightNovel); break;
                default: fantasiaLightNovels.add(lightNovel); break;
            }
        }

        categoriasLightNovelMap.put(Categoria.DRAMA, dramaLightNovels);
        categoriasLightNovelMap.put(Categoria.ROMANCE, romanceLightNovels);
        categoriasLightNovelMap.put(Categoria.FANTASIA, fantasiaLightNovels);
        System.out.println(categoriasLightNovelMap);

        Map<Categoria, List<LightNovel>> categoriaListMap = lightNovels.stream().collect(Collectors.groupingBy(LightNovel::getCategoria));
        System.out.println(categoriaListMap);

    }
}
