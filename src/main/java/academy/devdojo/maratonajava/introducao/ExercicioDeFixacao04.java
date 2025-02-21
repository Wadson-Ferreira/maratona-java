package academy.devdojo.maratonajava.introducao;
import java.util.Scanner;

/**
 Escreva um programa em Java que armazene as notas de cinco alunos em três disciplinas diferentes (por exemplo, Matemática, Português e Ciências) em uma matriz. Em seguida, calcule e exiba a média de cada aluno em cada disciplina.
 */
public class ExercicioDeFixacao04 {
    public static void main(String[] args) {
        String solicitacaoDeNotas = "Digite as notas dos alunos (0 a 10):";
        String aluno = "Aluno ";
        String ponto = ": ";
        String mensagemErro = "Nota Inválida! A nota Deve estar entre 0 e 10.";
        Scanner entrada = new Scanner(System.in);
        double [][] notas = new double[5][3];

        System.out.println(solicitacaoDeNotas);
        for (int i = 0; i < notas.length; i++) {
            System.out.println(aluno + (i + 1) + ponto);
            for (int j = 0; j < notas[i].length; j++) {
                double nota;
               do{
                   System.out.println("Nota da disciplina " + ( j + 1) + ponto);
                   nota = entrada.nextDouble();

                   if(nota < 0 || nota > 10){
                       System.out.println(mensagemErro);
                   }
               } while (nota < 0 || nota > 10);
                notas[i][j] = nota;
            }
        }
        System.out.println("\nMédias:");
        for (int i = 0; i < notas.length; i++) {
            System.out.println("Aluno " + (i + 1) + ":");
            for (int j = 0; j < notas[i].length; j++) {
                System.out.println("Disciplina " + (j + 1) + ": " + notas[i][j]);
            }
        }

        System.out.println("\nMédias:");
        for (int i = 0; i < notas.length; i++) {
            double soma  = 0;
            for (int j = 0; j < notas[i].length; j++) {
                soma += notas[i][j];
            }
            double media = soma /notas[i].length;

            System.out.println(aluno + (i + 1 ) + ponto +"Média = " + media);
            if(media >= 6){
                System.out.println("Aluno aprovado. ");
            } else {
                System.out.println("Aluno reprovado. ");
            }

        }

    }
}
