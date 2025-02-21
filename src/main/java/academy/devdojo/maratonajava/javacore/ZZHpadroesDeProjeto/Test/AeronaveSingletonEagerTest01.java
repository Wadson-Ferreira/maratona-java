package academy.devdojo.maratonajava.javacore.ZZHpadroesDeProjeto.Test;


import academy.devdojo.maratonajava.javacore.ZZHpadroesDeProjeto.Dominio.AeronaveSingletonEager;

public class AeronaveSingletonEagerTest01 {
    public static void main(String[] args) {
        comprandoAssento("1A");
        comprandoAssento("1A");
    }

    private static void comprandoAssento (String assento) {
        AeronaveSingletonEager aeronaveSingletonEager = AeronaveSingletonEager.getInstance();
        System.out.println(aeronaveSingletonEager.comprandoAssento(assento));
    }
}
