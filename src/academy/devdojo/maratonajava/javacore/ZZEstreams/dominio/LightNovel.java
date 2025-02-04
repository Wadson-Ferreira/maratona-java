package academy.devdojo.maratonajava.javacore.ZZEstreams.dominio;

import java.util.Objects;

public class LightNovel {
    private String titulo;
    private double preco;
    private Categoria categoria;

    public LightNovel(String titulo, double preco) {
        this.titulo = titulo;
        this.preco = preco;
    }

    public LightNovel(String titulo, double preco, Categoria categoria) {
        this.titulo = titulo;
        this.preco = preco;
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "LightNovel{" +
                "titulo='" + titulo + '\'' +
                ", preco=" + preco +
                ", categoria=" + categoria +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        LightNovel that = (LightNovel) o;
        return Objects.equals(titulo, that.titulo);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(titulo);
    }

    public String getTitulo() {
        return titulo;
    }

    public double getPreco() {
        return preco;
    }

    public Categoria getCategoria() {
        return categoria;
    }
}
