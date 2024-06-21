package academy.devdojo.maratonajava.javacore.BIntrudoucaoMetodos.test;

import academy.devdojo.maratonajava.javacore.BIntrudoucaoMetodos.dominio.Calculadora;

public class CalculadoraTest03 {
    public static void main(String[] args) {
        Calculadora calculadora = new Calculadora();
        double result = calculadora.divideDoisNumeros(24,2);
        System.out.println(result);
        System.out.println(calculadora.divideDoisNumeros02(6,2));
        System.out.println("-----------------------");
        calculadora.imprimeDivisaoDeDoisNumeros(24,0);
    }
}
