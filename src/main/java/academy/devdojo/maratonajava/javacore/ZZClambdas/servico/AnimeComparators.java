package academy.devdojo.maratonajava.javacore.ZZClambdas.servico;

import academy.devdojo.maratonajava.javacore.ZZClambdas.dominio.Anime;

public class AnimeComparators {
    public static int comparePorTitulo(Anime a1, Anime a2) {
        return a1.getTitulo().compareTo(a2.getTitulo());
    }

    public static int comparePorEpisodios(Anime a1, Anime a2) {
        return Integer.compare(a1.getEpisodios(), a2.getEpisodios());
    }

    public  int comparePorEpisodiosNoStatic(Anime a1, Anime a2) {
        return Integer.compare(a1.getEpisodios(), a2.getEpisodios());
    }
}
