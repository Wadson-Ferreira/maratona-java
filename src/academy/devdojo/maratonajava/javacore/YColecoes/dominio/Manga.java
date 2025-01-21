package academy.devdojo.maratonajava.javacore.YColecoes.dominio;

import java.util.Objects;

public class Manga  implements Comparable<Manga>{
    private Long id;
    private String titulo;
    private double preco;
    private int quantidade;

    public Manga(Long id, String titulo, double preco) {
        Objects.requireNonNull(id,"Id não pode ser null");
        Objects.requireNonNull(titulo,"Titulo não pode ser null");
        this.id = id;
        this.titulo = titulo;
        this.preco = preco;
    }

    public Manga(Long id, String titulo, double preco, int quantidade) {
       this(id, titulo, preco);
        this.quantidade = quantidade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Manga manga = (Manga) o;
        return Double.compare(preco, manga.preco) == 0 && Objects.equals(id, manga.id) && Objects.equals(titulo, manga.titulo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, titulo, preco);
    }

    @Override
    public String toString() {
        return "Manga{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", preco=" + preco +
                ", quantidade=" + quantidade +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public int compareTo(Manga outroManga) {
        //Negativo se o this < outroManga
        //Se this == outroManga, return 0
        //positivo se this > outroManga

//        if(this.id < outroManga.getId()){
//            return -1;
//        } else if(this.id.equals(outroManga.getId())){
//            return 0;
//        } else {
//            return 1;
//        }
        //Por String:
        return titulo.compareTo(outroManga.getTitulo());
        //Por preço:
        //Para comparar com um dado primitivo podemos fazer um cast para wrapper
        //return Double.compare(preco, outroManga.preco);
        //return Double.valueOf(preco).compareTo(outroManga.getPreco());

        //Por id:
        // return this.id.compareTo(outroManga.id);
    }
}
