package academy.devdojo.maratonajava.javacore.ZZGconcorrencia.dominio;

public final class Orcamento {
    private final String loja;
    private final double preco;
    private final Desconto.Code descontoCode;

    private Orcamento(String loja, double preco, Desconto.Code descontoCode) {
        this.loja = loja;
        this.preco = preco;
        this.descontoCode = descontoCode;
    }

    /**
     * Cria um novo objeto de cotação a partir do valor seguindo o padrão //nomeDaLoja:preco:descontoCode
     * @param value contendo nomeDaLoja:preco:descontoCode
     * @return new Orcamento com valores de @param value
     */
    public static Orcamento newOrcamento(String value){
        String[] values = value.split(":");
        return new Orcamento(values[0], Double.parseDouble(values[1].replace(',', '.')), Desconto.Code.valueOf(values[2]));
    }

    @Override
    public String toString() {
        return "Orcamento{" +
                "loja='" + loja + '\'' +
                ", preco=" + preco +
                ", descontoCode=" + descontoCode +
                '}';
    }

    public String getLoja() {
        return loja;
    }

    public double getPreco() {
        return preco;
    }

    public Desconto.Code getDescontoCode() {
        return descontoCode;
    }
}
