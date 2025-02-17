package academy.devdojo.maratonajava.javacore.ZZGconcorrencia.dominio;

//nomeDaLoja:preco:descontoCode
public class Desconto {
    public enum Code {
        NONE(0), SUPER_SAYAJIN(5), SUPER_SAYAJIN2(10), SUPER_SAYAJIN3(15);
        private final int porcentagem;

        Code(int porcentagem) {
            this.porcentagem = porcentagem;
        }

        public int getPorcentagem() {
            return porcentagem;
        }
    }
}
