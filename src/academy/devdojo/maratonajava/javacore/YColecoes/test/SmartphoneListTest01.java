package academy.devdojo.maratonajava.javacore.YColecoes.test;

import academy.devdojo.maratonajava.javacore.YColecoes.dominio.Smarphone;

import java.util.ArrayList;
import java.util.List;

public class SmartphoneListTest01 {
    public static void main(String[] args) {
        Smarphone s1 = new Smarphone("1ABC1", "Iphone");
        Smarphone s2 = new Smarphone("22222", "Pixel1");
        Smarphone s3 = new Smarphone("33333", "Samsung");

        List<Smarphone> smarphones = new ArrayList<>(6);
        smarphones.add(s1);
        smarphones.add(s2);
        smarphones.add(0,s3);

        for (Smarphone smarphone : smarphones) {
            System.out.println(smarphone);
        }
        Smarphone s4 = new Smarphone("22222", "Pixel2");
        System.out.println(smarphones.contains(s4));
        System.out.println(s4.equals(s2));

        int indexSmartphone4 = smarphones.indexOf(s4);
        System.out.println(smarphones.get(indexSmartphone4));


    }
}
