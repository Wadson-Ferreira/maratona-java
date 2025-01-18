package academy.devdojo.maratonajava.javacore.YColecoes.test;

import academy.devdojo.maratonajava.javacore.YColecoes.dominio.Manga;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class MangaByIdComparator implements Comparator<Manga> {
    @Override
    public int compare(Manga manga1, Manga manga2) {
        return manga1.getId().compareTo(manga2.getId());
    }
}

public class MangaSortTest01 {
    public static void main(String[] args) {
        List<Manga> mangas = new ArrayList<>(6);
        mangas.add(new Manga(5L,"Attack on Titan", 19.9));
        mangas.add(new Manga(1L,"Berserk", 38.5));
        mangas.add(new Manga(4L,"Hellsing Ultimate",17.5));
        mangas.add(new Manga(3L, "Pokemon", 11.20));
        mangas.add(new Manga(2L, "Dragon Ball Z", 12.99));
        for (Manga manga : mangas) {
            System.out.println(manga);
        }

        Collections.sort(mangas);
        System.out.println("\nSorted Mangas");
        for (Manga manga : mangas) {
            System.out.println(manga);
        }

       // Collections.sort(mangas, new MangaByIdComparator());
        mangas.sort(new MangaByIdComparator());
        System.out.println("\nSorted Mangas 2");
        for (Manga manga : mangas) {
            System.out.println(manga);
        }
    }
}
