package academy.devdojo.maratonajava.javacore.ZZBcomportamento.test;

import academy.devdojo.maratonajava.javacore.ZZBcomportamento.dominio.Carro;
import academy.devdojo.maratonajava.javacore.ZZBcomportamento.interfaces.CarroPredicado;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class ComportamentoPorParametroTest03 {
    private static List<Carro> carro = List.of(new Carro("Verde", 2011),
            new Carro("Preto", 1998), new Carro("Vermelho", 2019));

    public static void main(String[] args) {

        List<Carro> carrosVermelhos = filtrar(carro,
                carro -> carro.getCor().equalsIgnoreCase("Vermelho"));

        List<Carro> carrosFiltradosPorAno = filtrar(carro,carro -> carro.getAno() < 2020);

        System.out.println(carrosVermelhos);
        System.out.println(carrosFiltradosPorAno);

        List<Integer> numeros = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println(filtrar(numeros, numero -> numero % 2 == 0));
    }

    private static <T> List<T> filtrar(List<T> list, Predicate<T> predicate) {
        List<T> resultado = new ArrayList<>();
        for (T e : list) {
            if (predicate.test(e)) {
                resultado.add(e);
            }
        }
        return resultado;
    }
}
