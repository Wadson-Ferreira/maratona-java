package academy.devdojo.maratonajava.javacore.YColecoes.test;

import academy.devdojo.maratonajava.javacore.YColecoes.dominio.Manga;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinarySearchTest02 {
    public static void main(String[] args) {
        MangaByIdComparator mangaByIdComparator = new MangaByIdComparator();
        List<Manga> mangas = new ArrayList<>(6);
        mangas.add(new Manga(5L,"Attack on Titan", 19.9));
        mangas.add(new Manga(1L,"Berserk", 38.5));
        mangas.add(new Manga(4L,"Hellsing Ultimate",17.5));
        mangas.add(new Manga(3L, "Pokemon", 11.20));
        mangas.add(new Manga(2L, "Dragon Ball Z", 12.99));

        //Collections.sort(mangas);
        mangas.sort(new MangaByIdComparator());

        for (Manga manga : mangas) {
            System.out.println(manga);
        }

        Manga mangaToSearch = new Manga(2L, "Dragon Ball Z", 12.99);

        System.out.println(Collections.binarySearch(mangas, mangaToSearch,
                mangaByIdComparator));

    }
}
