package academy.devdojo.maratonajava.javacore.ZZDoptional.repositorio;

import academy.devdojo.maratonajava.javacore.ZZDoptional.dominio.Manga;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class MangaRepositorio {
    private static List<Manga> mangas = List.of(new Manga(1, "Boku no Hero",
            50), new Manga(2,"Overlord", 25));

    private static Optional<Manga> procurarPor (Predicate<Manga> predicate) {
        Manga encontrado = null;
        for (Manga manga : mangas) {
            if (predicate.test(manga)){
                encontrado = manga;
            }
        }
        return Optional.ofNullable(encontrado);
    }

    public static Optional<Manga> procurarPorId (int id) {
      return procurarPor(m -> m.getId().equals(id));
    }

    public static Optional<Manga> procurarPorTitulo (String titulo) {
        return procurarPor(m -> m.getTitulo().equalsIgnoreCase(titulo));
    }
}
