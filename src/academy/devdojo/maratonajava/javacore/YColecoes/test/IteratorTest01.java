package academy.devdojo.maratonajava.javacore.YColecoes.test;

import academy.devdojo.maratonajava.javacore.YColecoes.dominio.Manga;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorTest01 {
    public static void main(String[] args) {
        List<Manga> mangas = new ArrayList<>(6);
        mangas.add(new Manga(5L,"Attack on Titan", 19.9,0));
        mangas.add(new Manga(1L,"Berserk", 38.5,5));
        mangas.add(new Manga(4L,"Hellsing Ultimate",17.5,0));
        mangas.add(new Manga(3L, "Pokemon", 11.20,2));
        mangas.add(new Manga(2L, "Dragon Ball Z", 12.99,0));

//        Iterator<Manga> mangaIterator = mangas.iterator();
//        while( mangaIterator.hasNext() ) {
//            Manga manga = mangaIterator.next();
//            if(manga.getQuantidade() == 0){
//                mangaIterator.remove();
//            }
//        }


        mangas.removeIf(manga -> manga.getQuantidade() == 0);
        System.out.println(mangas);
    }
}
