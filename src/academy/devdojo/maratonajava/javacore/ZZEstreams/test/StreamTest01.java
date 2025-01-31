package academy.devdojo.maratonajava.javacore.ZZEstreams.test;

//1. Ordene as LightNovel por titulo
//2. Encontre as 3 primeiras LightNovels com preço menor que 4

import academy.devdojo.maratonajava.javacore.ZZEstreams.dominio.LightNovel;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StreamTest01 {
    private static List<LightNovel> lightNovels = new ArrayList<>(List.of(
            new LightNovel("Tensei Shittara", 8.99),
            new LightNovel("Overlord", 3.99),
            new LightNovel("Violet Evergarden", 5.99),
            new LightNovel("No Game no Life", 2.99),
            new LightNovel("Fullmetal Alchemist", 5.99),
            new LightNovel("Kumo Desuga", 1.99),
            new LightNovel("Monogatari", 4.00)));

    public static void main(String[] args) {
        lightNovels.sort(Comparator.comparing(LightNovel::getTitulo));

        List<String> titulos = new ArrayList<>();

        for (LightNovel lightNovel : lightNovels) {
            if(lightNovel.getPreco()<=4){
                titulos.add(lightNovel.getTitulo() + " Preço: " + lightNovel.getPreco());
            }
            if(titulos.size() >= 3){
                break;
            }
        }
        System.out.println(lightNovels);
        System.out.println(titulos);
        

    }
}
