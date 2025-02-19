package academy.devdojo.maratonajava.javacore.ZZHpadroesDeProjeto.Dominio;

public class Pessoa {
    private String primeiroNome;
    private String sobrenome;
    private String apelido;
    private String email;

    private Pessoa(String primeiroNome, String sobrenome, String apelido, String email) {
        this.primeiroNome = primeiroNome;
        this.sobrenome = sobrenome;
        this.apelido = apelido;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "primeiroNome='" + primeiroNome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", apelido='" + apelido + '\'' +
                ", email='" + email + '\'' +
                '}';
    }


    public static final class PessoaBuilder {
        private String primeiroNome;
        private String sobrenome;
        private String apelido;
        private String email;

        private PessoaBuilder() {
        }

        public static PessoaBuilder aPessoa() {
            return new PessoaBuilder();
        }

        public PessoaBuilder primeiroNome(String primeiroNome) {
            this.primeiroNome = primeiroNome;
            return this;
        }

        public PessoaBuilder sobrenome(String sobrenome) {
            this.sobrenome = sobrenome;
            return this;
        }

        public PessoaBuilder apelido(String apelido) {
            this.apelido = apelido;
            return this;
        }

        public PessoaBuilder email(String email) {
            this.email = email;
            return this;
        }

        public Pessoa build() {
            return new Pessoa(primeiroNome, sobrenome, apelido, email);
        }
    }
}
