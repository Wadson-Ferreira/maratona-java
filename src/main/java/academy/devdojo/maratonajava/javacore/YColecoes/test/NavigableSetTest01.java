package academy.devdojo.maratonajava.javacore.YColecoes.test;

import academy.devdojo.maratonajava.javacore.YColecoes.dominio.Manga;
import academy.devdojo.maratonajava.javacore.YColecoes.dominio.Smarphone;

import java.util.Comparator;
import java.util.NavigableSet;
import java.util.TreeSet;

class SmarphoneMarcaComparator implements Comparator<Smarphone> {
    @Override
    public int compare(Smarphone o1, Smarphone o2) {
        return o1.getMarca().compareTo(o2.getMarca());
    }
}

class MangaPrecoComparator implements Comparator<Manga> {
    @Override
    public int compare(Manga o1, Manga o2) {
        return Double.compare(o1.getPreco(), o2.getPreco());
    }
}
public class NavigableSetTest01 {
    public static void main(String[] args) {
        NavigableSet<Smarphone> set =
                new TreeSet<>(new SmarphoneMarcaComparator());
        Smarphone smarphone = new Smarphone("123", "Nokia");
        set.add(smarphone);
        
        NavigableSet<Manga> mangas = new TreeSet<>(new MangaPrecoComparator());
        mangas.add(new Manga(5L,"Hellsing Ultimate", 19.9,0));
        mangas.add(new Manga(1L,"Berserk", 9.5,5));
        mangas.add(new Manga(4L,"Pokemon",3.2,0));
        mangas.add(new Manga(3L, "Attack on Titan", 11.20,2));
        mangas.add(new Manga(2L, "Dragon Ball Z", 2.99,0));
        mangas.add(new Manga(10L, "Aaragon", 2.99,0));
        mangas.add(new Manga(10L, "Aaragon", 10.99,0));

        for (Manga manga : mangas) {
            System.out.println(manga);
        }

        System.out.println("---------------");

        for (Manga manga : mangas.descendingSet()) {
            System.out.println(manga);
        }

        System.out.println("-----------------");

        //lower <
        // floor <=
        //higher >
        //ceiling >=

        Manga Yuyu = new Manga(21L, "Yuyu Hakusho", 3.2, 5);
        System.out.println(mangas.lower(Yuyu));
        System.out.println(mangas.floor(Yuyu));
        System.out.println(mangas.higher(Yuyu));
        System.out.println(mangas.ceiling(Yuyu));

        System.out.println("-------------");

        System.out.println(mangas.size());
        System.out.println(mangas.pollFirst());
        System.out.println(mangas.size());
        System.out.println(mangas.pollLast());
        System.out.println(mangas.size());
    }
}
