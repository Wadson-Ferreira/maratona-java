package academy.devdojo.maratonajava.javacore.ZZBcomportamento.test;

import academy.devdojo.maratonajava.javacore.ZZBcomportamento.dominio.Carro;
import academy.devdojo.maratonajava.javacore.ZZBcomportamento.interfaces.CarroPredicado;

import java.util.ArrayList;
import java.util.List;

public class ComportamentoPorParametroTest02 {
    private static List<Carro> carro = List.of(new Carro("Verde", 2011),
            new Carro("Preto", 1998), new Carro("Vermelho", 2019));

    public static void main(String[] args) {
        List<Carro> carrosVermelhos = filtrar(carro, new CarroPredicado() {
            @Override
            public boolean test(Carro carro) {
                return carro.getCor().equalsIgnoreCase("Vermelho");
            }
        });

        List<Carro> carrosFiltradosPorAno = filtrar(carro, new CarroPredicado() {
            @Override
            public boolean test(Carro carro) {
                return carro.getAno() < 2018;
            }
        });

        System.out.println(carrosVermelhos);
        System.out.println(carrosFiltradosPorAno);
    }

    private static List<Carro> filtrar (List<Carro> carros,
                                       CarroPredicado carroPredicado) {
        List<Carro> CarroEncontrado = new ArrayList<>();
        for (Carro carro : carros) {
            if(carroPredicado.test(carro)) {
                CarroEncontrado.add(carro);
            }
        }
        return CarroEncontrado;
    }
}
