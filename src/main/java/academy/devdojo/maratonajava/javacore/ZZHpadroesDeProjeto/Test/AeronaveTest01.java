package academy.devdojo.maratonajava.javacore.ZZHpadroesDeProjeto.Test;

import academy.devdojo.maratonajava.javacore.ZZHpadroesDeProjeto.Dominio.Aeronave;

public class AeronaveTest01 {
    public static void main(String[] args) {
        comprandoAssento("1A");
        comprandoAssento("1A");
    }

    private static void comprandoAssento (String assento) {
        Aeronave aeronave = new Aeronave("787-900");
        System.out.println(aeronave.comprandoAssento(assento));
    }
}
