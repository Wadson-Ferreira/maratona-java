package academy.devdojo.maratonajava.javacore.ZZClambdas.test;

import academy.devdojo.maratonajava.javacore.ZZClambdas.dominio.Anime;
import academy.devdojo.maratonajava.javacore.ZZClambdas.servico.AnimeComparators;

import java.util.ArrayList;
import java.util.List;

public class MethodReferenceTest01 {
    public static void main(String[] args) {
        List<Anime> animeList = new ArrayList<>(List.of(new Anime("Berserk", 43), new Anime(
                        "One Piece", 1000),
                new Anime("Naruto", 500)));

        //Collections.sort(animeList,(a1,a2) -> a1.getTitulo().compareTo(a2.getTitulo()));
        //animeList.sort(AnimeComparators::comparePorTitulo);
        animeList.sort(AnimeComparators::comparePorEpisodios);
        System.out.println(animeList);
    }
}
