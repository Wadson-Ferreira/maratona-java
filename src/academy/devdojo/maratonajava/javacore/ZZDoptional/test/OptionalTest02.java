package academy.devdojo.maratonajava.javacore.ZZDoptional.test;

import academy.devdojo.maratonajava.javacore.ZZDoptional.dominio.Manga;
import academy.devdojo.maratonajava.javacore.ZZDoptional.repositorio.MangaRepositorio;

import java.util.Optional;

public class OptionalTest02 {
    public static void main(String[] args) {
        Optional<Manga> bokuNoHero = MangaRepositorio.procurarPorTitulo("Boku no Hero");
        bokuNoHero.ifPresent(m -> m.setTitulo("Boku no Hero 2"));
        System.out.println(bokuNoHero);

        System.out.println("------------------");

        Manga mangaPorId =
                MangaRepositorio.procurarPorId(2).orElseThrow(IllegalArgumentException::new);
        System.out.println(mangaPorId);

        System.out.println("------------------");

        Manga novoManga = MangaRepositorio.procurarPorTitulo("Berserk")
                .orElse(new Manga(4, "Berserk", 80));
        System.out.println("Novo manga criado: " + novoManga);
    }
}
