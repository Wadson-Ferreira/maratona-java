package academy.devdojo.maratonajava.javacore.BIntrudoucaoMetodos.test;

import academy.devdojo.maratonajava.javacore.BIntrudoucaoMetodos.dominio.Calculadora;

public class CalculadoraTest03 {
    public static void main(String[] args) {
        Calculadora calculadora = new Calculadora();
        double result = calculadora.divideDoisNumeros(3,1);
        System.out.println(result);
    }
}
