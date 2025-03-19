package academy.devdojo.maratonajava.javacore.ZZKJunit.dominio;

import java.util.Objects;

public record Manga(String nome, int episodios) {
    public Manga {
        Objects.requireNonNull(nome);
    }
}
