package academy.devdojo.maratonajava.javacore.Zgenerics.test;

import academy.devdojo.maratonajava.javacore.YColecoes.dominio.Consumidor;

import java.util.ArrayList;
import java.util.List;

public class GenericsTest01 {
    public static void main(String[] args) {
        //Type  erasure
        List<String> list = new ArrayList();
        list.add("Midoriya");
        list.add("Midoriya");

        for (String o : list) {
            System.out.println(o);
        }

        add(list, new Consumidor("Midoriya"));
        for (String o : list) {
            System.out.println(o);
        }
    }
    private static void add (List lista, Consumidor consumidor) {
        lista.add(consumidor);
    }

}
