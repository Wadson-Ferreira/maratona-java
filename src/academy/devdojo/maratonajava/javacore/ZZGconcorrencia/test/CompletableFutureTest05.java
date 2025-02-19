package academy.devdojo.maratonajava.javacore.ZZGconcorrencia.test;

import academy.devdojo.maratonajava.javacore.ZZGconcorrencia.dominio.Orcamento;
import academy.devdojo.maratonajava.javacore.ZZGconcorrencia.servico.ServicoDeLojaComDesconto;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class CompletableFutureTest05 {
    public static void main(String[] args) {
        ServicoDeLojaComDesconto servico = new ServicoDeLojaComDesconto();
        //procurarPrecosComDesconto(servico);
        procurarPrecosComDescontoAsync(servico);

    }


    private static void procurarPrecosComDescontoAsync(ServicoDeLojaComDesconto servico) {
        long inicio = System.currentTimeMillis();
        List<String> lojas = List.of("Loja 1", "Loja 2", "Loja 3", "Loja 4");

        var completableFutures = lojas.stream()
                .map(s -> CompletableFuture.supplyAsync(() -> servico.getPrecoSync(s)))
                .map(cf -> cf.thenApply(Orcamento::newOrcamento))
                .map(cf -> cf.thenCompose(orcamento -> CompletableFuture.supplyAsync(() -> servico.aplicandoDesconto(orcamento))))
                .map(cf -> cf.thenAccept(loja -> System.out.printf("%s finalizado em %d%n", loja, (System.currentTimeMillis() - inicio))))
                .toArray(CompletableFuture[]::new);

        //CompletableFuture<Void> voidCompletableFuture = CompletableFuture.allOf(completableFutures);
        CompletableFuture<Object> voidCompletableFuture = CompletableFuture.anyOf(completableFutures);
        voidCompletableFuture.join();
        System.out.printf("Finalizado? %b%n", voidCompletableFuture.isDone());


        long fim = System.currentTimeMillis();
        System.out.printf("Tempo passado por procurarPrecosComDesconto %dms%n", (inicio - fim));
    }
}
