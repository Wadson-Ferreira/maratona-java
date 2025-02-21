package academy.devdojo.maratonajava.javacore.ZZGconcorrencia.servico;

import java.util.concurrent.*;

public class ServicoDeLojaObsoleto {
    public double getPrecoSync(String nomeDaLoja) {
        System.out.printf("Obtendo preços sincronizados da loja: %s%n ", nomeDaLoja);
        return geradorDePreco();
    }

    private double geradorDePreco() {
        System.out.printf("Thread %s gerando preço %n", getNameThread());
        atraso();
        return ThreadLocalRandom.current().nextInt(1, 500) * 10;
    }


    private void atraso() {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static String getNameThread() {
        return Thread.currentThread().getName();
    }
}
