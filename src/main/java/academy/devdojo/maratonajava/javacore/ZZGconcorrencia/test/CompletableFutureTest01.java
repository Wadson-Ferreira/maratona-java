package academy.devdojo.maratonajava.javacore.ZZGconcorrencia.test;

import academy.devdojo.maratonajava.javacore.ZZGconcorrencia.servico.ServicoDeLoja;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class CompletableFutureTest01 {
    public static void main(String[] args) {
        ServicoDeLoja servicoDeLoja = new ServicoDeLoja();
        //procurandoPrecosSync(servicoDeLoja);
        //procurandoPrecosASync(servicoDeLoja);
        procurandoPrecosASyncCompletableFuture(servicoDeLoja);
    }

    private static void procurandoPrecosSync(ServicoDeLoja servicoDeLoja) {
        long iniciar = System.currentTimeMillis();
        System.out.println(servicoDeLoja.getPrecoSync("Loja 1"));
        System.out.println(servicoDeLoja.getPrecoSync("Loja 2"));
        System.out.println(servicoDeLoja.getPrecoSync("Loja 3"));
        System.out.println(servicoDeLoja.getPrecoSync("Loja 4"));
        long fim = System.currentTimeMillis();
        System.out.printf("Tempo passado procurandoPrecosSync %d%n", (fim - iniciar));
    }

    private static void procurandoPrecosASync(ServicoDeLoja servicoDeLoja) {
        long iniciar = System.currentTimeMillis();
        Future<Double> precoAsyncFuture1 = servicoDeLoja.getPrecoAsyncFuture("Loja 1");
        Future<Double> precoAsyncFuture2 = servicoDeLoja.getPrecoAsyncFuture("Loja 2");
        Future<Double> precoAsyncFuture3 = servicoDeLoja.getPrecoAsyncFuture("Loja 3");
        Future<Double> precoAsyncFuture4 = servicoDeLoja.getPrecoAsyncFuture("Loja 4");
        try {
            System.out.println(precoAsyncFuture1.get());
            System.out.println(precoAsyncFuture2.get());
            System.out.println(precoAsyncFuture3.get());
            System.out.println(precoAsyncFuture4.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        long fim = System.currentTimeMillis();
        System.out.printf("Tempo passado procurandoPrecosSync %d%n", (fim - iniciar));
        servicoDeLoja.shutdown();
    }

    private static void procurandoPrecosASyncCompletableFuture(ServicoDeLoja servicoDeLoja) {
        long iniciar = System.currentTimeMillis();
        CompletableFuture<Double> precoAsyncFuture1 = servicoDeLoja.getPrecoAsyncCompletableFuture("Loja 1");
        CompletableFuture<Double> precoAsyncFuture2 = servicoDeLoja.getPrecoAsyncCompletableFuture("Loja 2");
        CompletableFuture<Double> precoAsyncFuture3 = servicoDeLoja.getPrecoAsyncCompletableFuture("Loja 3");
        CompletableFuture<Double> precoAsyncFuture4 = servicoDeLoja.getPrecoAsyncCompletableFuture("Loja 4");

        System.out.println(precoAsyncFuture1.join());
        System.out.println(precoAsyncFuture2.join());
        System.out.println(precoAsyncFuture3.join());
        System.out.println(precoAsyncFuture4.join());

        long fim = System.currentTimeMillis();
        System.out.printf("Tempo passado procurandoPrecosSync %d%n", (fim - iniciar));
    }
}
