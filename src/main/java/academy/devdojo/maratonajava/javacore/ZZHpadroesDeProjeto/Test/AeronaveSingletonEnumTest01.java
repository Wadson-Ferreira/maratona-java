package academy.devdojo.maratonajava.javacore.ZZHpadroesDeProjeto.Test;

import academy.devdojo.maratonajava.javacore.ZZHpadroesDeProjeto.Dominio.AeronaveSingletonEnum;

public class AeronaveSingletonEnumTest01 {
    public static void main(String[] args) {
        comprandoAssento("1A");
        comprandoAssento("1A");
    }

    private static void comprandoAssento(String assento) {
        System.out.println(AeronaveSingletonEnum.INSTANCE.hashCode());
        AeronaveSingletonEnum instance = AeronaveSingletonEnum.INSTANCE;
        System.out.println(instance.comprandoAssennto(assento));
    }
}
