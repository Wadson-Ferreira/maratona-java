package academy.devdojo.maratonajava.javacore.ZZBcomportamento.test;

import academy.devdojo.maratonajava.javacore.ZZBcomportamento.dominio.Carro;

import java.util.ArrayList;
import java.util.List;

public class ComportamentoPorParametroTest01 {
    private static List<Carro> carro = List.of(new Carro("Verde", 2011),
            new Carro("Preto", 1998), new Carro("Vermelho", 2019));

    public static void main(String[] args) {
        System.out.println(filtrarCarroPorCor(carro,"Vermelho"));
    }

    private static List<Carro> filtrarCarroPorCor(List<Carro> carrosDaCor, String cor) {
        List<Carro> carrosEncontrados = new ArrayList<>();
        for (Carro carro : carrosDaCor) {
            if(carro.getCor().equalsIgnoreCase(cor)) {
                carrosEncontrados.add(carro);
            }
        }
        return carrosEncontrados;
    }
}
