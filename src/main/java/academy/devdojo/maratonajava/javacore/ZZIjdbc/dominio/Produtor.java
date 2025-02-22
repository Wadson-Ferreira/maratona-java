package academy.devdojo.maratonajava.javacore.ZZIjdbc.dominio;

import java.util.Objects;

public class Produtor {
    private Integer id;
    private String nome;


    public static final class ProdutorBuilder {
        private Integer id;
        private String nome;

        private ProdutorBuilder() {
        }

        public static ProdutorBuilder builder() {
            return new ProdutorBuilder();
        }

        public ProdutorBuilder id(Integer id) {
            this.id = id;
            return this;
        }

        public ProdutorBuilder nome(String nome) {
            this.nome = nome;
            return this;
        }

        public Produtor build() {
            Produtor produtor = new Produtor();
            produtor.id = this.id;
            produtor.nome = this.nome;
            return produtor;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produtor produtor = (Produtor) o;
        return Objects.equals(id, produtor.id) && Objects.equals(nome, produtor.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome);
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}
