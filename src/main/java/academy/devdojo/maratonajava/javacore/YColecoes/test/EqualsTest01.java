package academy.devdojo.maratonajava.javacore.YColecoes.test;

import academy.devdojo.maratonajava.javacore.YColecoes.dominio.Smarphone;

public class EqualsTest01 {
    public static void main(String[] args) {
        Smarphone s1 = new Smarphone("1ABC1", "Iphone");
        Smarphone s2 = new Smarphone("1ABC1", "Iphone");
        System.out.println(s1.equals(s2));
    }
}
