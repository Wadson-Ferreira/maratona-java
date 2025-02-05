package academy.devdojo.maratonajava.javacore.ZZClambdas.test;

import academy.devdojo.maratonajava.javacore.ZZClambdas.dominio.Anime;
import academy.devdojo.maratonajava.javacore.ZZClambdas.servico.AnimeComparators;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Supplier;

//Reference to a constructor
public class MetodoDeReferencia04 {
    public static void main(String[] args) {
        Supplier<AnimeComparators> newAnimeComparators = AnimeComparators::new;
        AnimeComparators animeComparators = newAnimeComparators.get();
        List<Anime> animeList = new ArrayList<>(List.of(new Anime("Berserk", 43), new Anime(
                "One Piece", 1000), new Anime("Naruto", 500)));

        animeList.sort(animeComparators::comparePorEpisodiosNoStatic);
        System.out.println(animeList);

        BiFunction <String, Integer, Anime> animeBiFunction = (titulo,
        episodio) -> new Anime(titulo, episodio);

        BiFunction <String, Integer, Anime> animeBiFunction1 = Anime::new;
        Anime bleach = animeBiFunction.apply("Bleach", 240);
        Anime tokyoGhol = animeBiFunction1.apply("Tokyo Ghol", 110);
        System.out.println(bleach + "\n" + tokyoGhol);
        System.out.println("--------------");
        animeList.add(bleach);
        animeList.add(tokyoGhol);
        animeList.sort(animeComparators::comparePorEpisodiosNoStatic);
        System.out.println(animeList);

    }
}
