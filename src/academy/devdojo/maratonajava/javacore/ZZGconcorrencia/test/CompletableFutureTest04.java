package academy.devdojo.maratonajava.javacore.ZZGconcorrencia.test;

import academy.devdojo.maratonajava.javacore.ZZGconcorrencia.dominio.Orcamento;
import academy.devdojo.maratonajava.javacore.ZZGconcorrencia.servico.ServicoDeLojaComDesconto;

import java.util.List;

public class CompletableFutureTest04 {
    public static void main(String[] args) {
        ServicoDeLojaComDesconto servico = new ServicoDeLojaComDesconto();
        procurarPrecosComDesconto(servico);

    }

    private static void procurarPrecosComDesconto(ServicoDeLojaComDesconto servico) {
        List<String> lojas = List.of("Loja 1", "Loja 2", "Loja 3", "Loja 4");
        // lojas.forEach(s -> System.out.println(servico.getPrecoSync(s)));
        lojas.stream()
                .map(servico::getPrecoSync) //store:price:code
                .map(Orcamento::newOrcamento)
                .map(servico::aplicandoDesconto)
                .forEach(System.out::println);
    }
}
