package academy.devdojo.maratonajava.javacore.ZZGconcorrencia.test;

import academy.devdojo.maratonajava.javacore.ZZGconcorrencia.servico.ServicoDeLojaObsoleto;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;


public class CompletableFutureTest03 {
    public static void main(String[] args) {
        ServicoDeLojaObsoleto servicoDeLojaObsoleto = new ServicoDeLojaObsoleto();
        procurandoPrecosASyncCompletableFuture(servicoDeLojaObsoleto);
    }

    private static void procurandoPrecosASyncCompletableFuture(ServicoDeLojaObsoleto servicoDeLoja) {
        long iniciar = System.currentTimeMillis();
        ExecutorService executor = Executors.newFixedThreadPool(10, r -> {
            Thread thread = new Thread(r);
            thread.setDaemon(true);
            return thread;
        });
        List<String> lojas = List.of("Loja 1", "Loja 2", "Loja 3", "Loja 4");
        List<CompletableFuture<Double>> completableFutures = lojas.stream()
                .map(s -> CompletableFuture.supplyAsync(() -> servicoDeLoja.getPrecoSync(s),executor))
                .toList();

        List<Double> precos = completableFutures.stream()
                .map(CompletableFuture::join).collect(Collectors.toList());

        System.out.println(precos);
        long fim = System.currentTimeMillis();
        executor.shutdown();
        System.out.printf("Tempo passado procurandoPrecosSync %d%n", (fim - iniciar));
    }
}
