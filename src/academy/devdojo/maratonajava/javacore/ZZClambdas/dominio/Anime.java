package academy.devdojo.maratonajava.javacore.ZZClambdas.dominio;

public class Anime {
    private String titulo;
    private int episodios;

    public Anime(String titulo, int episodios) {
        this.titulo = titulo;
        this.episodios = episodios;
    }

    @Override
    public String toString() {
        return "Anime{" +
                "titulo='" + titulo + '\'' +
                ", episodios=" + episodios +
                '}';
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getEpisodios() {
        return episodios;
    }

    public void setEpisodios(int episodios) {
        this.episodios = episodios;
    }
}
