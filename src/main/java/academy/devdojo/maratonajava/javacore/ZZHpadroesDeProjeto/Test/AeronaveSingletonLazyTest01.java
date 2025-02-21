package academy.devdojo.maratonajava.javacore.ZZHpadroesDeProjeto.Test;

import academy.devdojo.maratonajava.javacore.ZZHpadroesDeProjeto.Dominio.AeronaveSingletonLazy;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class AeronaveSingletonLazyTest01 {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        comprandoAssento("1A");
        comprandoAssento("1A");
        System.out.println(AeronaveSingletonLazy.getInstance());
        Constructor<AeronaveSingletonLazy> constructor = AeronaveSingletonLazy.class.getDeclaredConstructor(String.class);
        constructor.setAccessible(true);
        AeronaveSingletonLazy aeronaveSingletonLazy = constructor.newInstance("787-900");
        System.out.println(aeronaveSingletonLazy);
    }

    private static void comprandoAssento (String assento) {
        System.out.println(AeronaveSingletonLazy.getInstance());
        AeronaveSingletonLazy aeronaveSingletonLazy = AeronaveSingletonLazy.getInstance();
        System.out.println(aeronaveSingletonLazy.comprandoAssento(assento));
    }
}
