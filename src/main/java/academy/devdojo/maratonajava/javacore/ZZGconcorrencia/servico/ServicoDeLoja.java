package academy.devdojo.maratonajava.javacore.ZZGconcorrencia.servico;

import java.util.concurrent.*;

public class ServicoDeLoja {
    private static final ExecutorService ex = Executors.newCachedThreadPool();

    public double getPrecoSync(String nomeDaLoja){
        System.out.printf("Obtendo preços sincronizados da loja: %s%n ", nomeDaLoja);
        return geradorDePreco();
    }

    public Future<Double> getPrecoAsyncFuture(String nomeDaLoja){
        System.out.printf("Obtendo preços sincronizados da loja: %s%n ", nomeDaLoja);
        return ex.submit(this::geradorDePreco);
    }

    public CompletableFuture<Double> getPrecoAsyncCompletableFuture(String nomeDaLoja){
        System.out.printf("Obtendo preços sincronizados da loja: %s%n ", nomeDaLoja);
        return CompletableFuture.supplyAsync(this::geradorDePreco);
    }

    private double geradorDePreco(){
        System.out.printf("Thread %s gerando preço %n", getNameThread());
        atraso();
        return ThreadLocalRandom.current().nextInt(1,500) * 10;
    }

    public void shutdown(){
        ex.shutdown();
    }

    private void atraso(){
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
