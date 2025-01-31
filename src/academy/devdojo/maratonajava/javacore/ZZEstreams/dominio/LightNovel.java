package academy.devdojo.maratonajava.javacore.ZZEstreams.dominio;

public class LightNovel {
    private String titulo;
    private double preco;

    public LightNovel(String titulo, double preco) {
        this.titulo = titulo;
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "LightNovel{" +
                "titulo='" + titulo + '\'' +
                ", preco=" + preco +
                '}';
    }

    public String getTitulo() {
        return titulo;
    }

    public double getPreco() {
        return preco;
    }
}
