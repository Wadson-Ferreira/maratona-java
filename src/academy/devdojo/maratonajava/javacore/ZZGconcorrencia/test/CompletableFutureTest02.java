package academy.devdojo.maratonajava.javacore.ZZGconcorrencia.test;

import academy.devdojo.maratonajava.javacore.ZZGconcorrencia.servico.ServicoDeLoja;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;


public class CompletableFutureTest02 {
    public static void main(String[] args) {
        ServicoDeLoja servicoDeLoja = new ServicoDeLoja();
        procurandoPrecosASyncCompletableFuture(servicoDeLoja);
    }

    private static void procurandoPrecosASyncCompletableFuture(ServicoDeLoja servicoDeLoja) {
        long iniciar = System.currentTimeMillis();
        List<String> lojas = List.of("Loja 1", "Loja 2", "Loja 3", "Loja 4");

        List<CompletableFuture<Double>> completableFutures = lojas.stream()
                .map(servicoDeLoja::getPrecoAsyncCompletableFuture)
                .toList();

        List<Double> precos = completableFutures.stream().map(CompletableFuture::join).collect(Collectors.toList());


        System.out.println(precos);

        long fim = System.currentTimeMillis();
        System.out.printf("Tempo passado procurandoPrecosSync %d%n", (fim - iniciar));
    }
}
