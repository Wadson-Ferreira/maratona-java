package academy.devdojo.maratonajava.introducao;

import java.util.Scanner;

/**
 * Média de notas: Solicite ao usário que insira as notas dos cinco alunos;
 * Armazene as notas em um array;
 * Calcule a média das notas;
 * Exiba média das notas.
 */
public class Aula07Exercicio {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        double[] notasAlunos = new double[5];
        System.out.println("Digite as notas dos cinco alunos: ");

        for (int i = 0; i < notasAlunos.length; i++) {
            boolean notaValida = false;
            while (!notaValida){
                System.out.println("Nota do aluno " + (i + 1)+ ": ");
                double nota = entrada.nextDouble();
                if (nota >= 0 && nota <= 10){
                    notasAlunos[i] = nota;
                    notaValida = true;
                }else{
                    System.out.println("Nota Inválida! Por favor, insira uma " +
                            "nota entre 0 e 10");
                }
            }

        }

        double somaDasNotas = 0;
        for (double nota : notasAlunos){
            somaDasNotas += nota;
        }
        double mediaDasNotas = somaDasNotas / notasAlunos.length;
        System.out.println("A média das notas é: " +mediaDasNotas);
    }
}
