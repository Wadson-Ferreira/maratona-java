package academy.devdojo.maratonajava.javacore.ZZHpadroesDeProjeto.Dominio;

public class RelatorioDto {
    private String aeronaveNome;
    private Pais pais;
    private Moeda moeda;
    private String pessoaNome;


    public static final class RelatorioDtoBuilder {
        private String aeronaveNome;
        private Pais pais;
        private Moeda moeda;
        private String pessoaNome;

        private RelatorioDtoBuilder() {
        }

        public static RelatorioDtoBuilder builder() {
            return new RelatorioDtoBuilder();
        }

        public RelatorioDtoBuilder aeronaveNome(String aeronaveNome) {
            this.aeronaveNome = aeronaveNome;
            return this;
        }

        public RelatorioDtoBuilder pais(Pais pais) {
            this.pais = pais;
            return this;
        }

        public RelatorioDtoBuilder moeda(Moeda moeda) {
            this.moeda = moeda;
            return this;
        }

        public RelatorioDtoBuilder pessoaNome(String pessoaNome) {
            this.pessoaNome = pessoaNome;
            return this;
        }

        public RelatorioDto build() {
            RelatorioDto relatorioDto = new RelatorioDto();
            relatorioDto.pessoaNome = this.pessoaNome;
            relatorioDto.pais = this.pais;
            relatorioDto.moeda = this.moeda;
            relatorioDto.aeronaveNome = this.aeronaveNome;
            return relatorioDto;
        }
    }

    @Override
    public String toString() {
        return "RelatorioDto{" +
                "aeronaveNome='" + aeronaveNome + '\'' +
                ", pais=" + pais +
                ", moeda=" + moeda +
                ", pessoaNome='" + pessoaNome + '\'' +
                '}';
    }
}
