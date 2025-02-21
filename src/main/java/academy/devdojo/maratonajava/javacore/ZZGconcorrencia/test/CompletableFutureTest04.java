package academy.devdojo.maratonajava.javacore.ZZGconcorrencia.test;

import academy.devdojo.maratonajava.javacore.ZZGconcorrencia.dominio.Orcamento;
import academy.devdojo.maratonajava.javacore.ZZGconcorrencia.servico.ServicoDeLojaComDesconto;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class CompletableFutureTest04 {
    public static void main(String[] args) {
        ServicoDeLojaComDesconto servico = new ServicoDeLojaComDesconto();
        //procurarPrecosComDesconto(servico);
        procurarPrecosComDescontoAsync(servico);

    }

    private static void procurarPrecosComDesconto(ServicoDeLojaComDesconto servico) {
        long inicio = System.currentTimeMillis();
        List<String> lojas = List.of("Loja 1", "Loja 2", "Loja 3", "Loja 4");
        // lojas.forEach(s -> System.out.println(servico.getPrecoSync(s)));
        lojas.stream()
                .map(servico::getPrecoSync) //store:price:code
                .map(Orcamento::newOrcamento)
                .map(servico::aplicandoDesconto)
                .forEach(System.out::println);
        long fim = System.currentTimeMillis();
        System.out.printf("Tempo passado por procurarPrecosComDesconto %dms%n", (inicio - fim));
    }

    private static void procurarPrecosComDescontoAsync(ServicoDeLojaComDesconto servico) {
        long inicio = System.currentTimeMillis();
        List<String> lojas = List.of("Loja 1", "Loja 2", "Loja 3", "Loja 4");

        List<CompletableFuture<String>> completableFutures = lojas.stream()
                //Getting o preco async nomeDaLoja:preco:descontoCode
                .map(s -> CompletableFuture.supplyAsync(() -> servico.getPrecoSync(s)))
                //Estanciando o new Orcamento de string generador do getPrecoSync
                .map(cf -> cf.thenApply(Orcamento::newOrcamento))
                .map(cf ->
                        cf.thenCompose(orcamento -> CompletableFuture.supplyAsync(() -> servico.aplicandoDesconto(orcamento))))
                .toList();

        completableFutures.stream()
                .map(CompletableFuture::join)
                .forEach(System.out::println);

        long fim = System.currentTimeMillis();
        System.out.printf("Tempo passado por procurarPrecosComDesconto %dms%n", (inicio - fim));
    }
}
