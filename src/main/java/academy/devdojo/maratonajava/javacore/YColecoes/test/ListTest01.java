package academy.devdojo.maratonajava.javacore.YColecoes.test;

import java.util.ArrayList;
import java.util.List;

public class ListTest01 {
    public static void main(String[] args) {
        List<String> nomes = new ArrayList<>(16);
        List<String> nomes2 = new ArrayList<>(16);
        nomes.add("Genesys");
        nomes.add("William");
        nomes2.add("Rute");
        nomes2.add("Lessa");

        nomes.addAll(nomes2);

        for (String nome : nomes) {
            System.out.println(nome);
        }

        System.out.println("--------------");

        int size = nomes.size();
        for (int i = 0; i < size; i++) {
            nomes.add("Rocha");
            System.out.println(nomes.get(i));
        }
        nomes.remove(1);
        nomes.remove("Rocha");
        System.out.println(nomes);

        //Não se pode criar coleções com tipos primitivos. Deve-se utilizar
        // os Wrappers.
        List<Integer> numeros = new ArrayList<>(16);
        numeros.add(1);

        System.out.println(numeros);
    }
}
