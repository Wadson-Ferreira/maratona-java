package academy.devdojo.maratonajava.javacore.ZZGconcorrencia.servico;

import academy.devdojo.maratonajava.javacore.ZZGconcorrencia.dominio.Desconto;
import academy.devdojo.maratonajava.javacore.ZZGconcorrencia.dominio.Orcamento;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class ServicoDeLojaComDesconto {
    public String getPrecoSync(String nomeDaLoja) {
        double preco = geradorDePreco();
        Desconto.Code descontoCode = Desconto.Code.values()
                [ThreadLocalRandom.current().nextInt(Desconto.Code.values().length)];
        return String.format("%s:%.2f:%s", nomeDaLoja, preco, descontoCode);
    }

    public String aplicandoDesconto(Orcamento orcamento) {
        atraso();
        double valorDesconto = orcamento.getPreco() * (100 - orcamento.getDescontoCode().getPorcentagem()) / 100;
        return String.format("'%s' preço original: '%.2f'. Aplicando desconto code '%s'. preço final '%.2f'",
                orcamento.getLoja(), orcamento.getPreco(), orcamento.getDescontoCode(),valorDesconto);
    }

    private double geradorDePreco() {
        atraso();
        return ThreadLocalRandom.current().nextInt(1, 500) * 10;
    }

    private void atraso() {
        try {
            int milli = ThreadLocalRandom.current().nextInt(200, 2500);
            TimeUnit.MILLISECONDS.sleep(milli);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static String getNameThread() {
        return Thread.currentThread().getName();
    }
}
