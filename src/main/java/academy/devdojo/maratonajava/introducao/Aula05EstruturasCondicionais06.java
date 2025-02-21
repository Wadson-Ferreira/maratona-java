package academy.devdojo.maratonajava.introducao;

import java.util.Scanner;

public class Aula05EstruturasCondicionais06 {
    public static void main(String[] args) {
        //Dados os valores de 1 a 7, imprima se é útil ou final de semana
        //Considerando 1 como domingo

        Scanner entrada = new Scanner(System.in);
        System.out.println("Digite o dia da semana de forma númerica " +
                "considerando 1 como domingo");

        String primeiraFraseResposta = "Você digitou ";
        String segundaFraseResposta = " Que se refere a: ";
        String terceiraFraseResposta;
        String fimDeSemanaOuDiaUtil;

        byte diaDaSemana = entrada.nextByte();

        switch (diaDaSemana) {
            case 1:
                terceiraFraseResposta = "Domingo. ";
                fimDeSemanaOuDiaUtil = "Final de semana.";
                System.out.println(primeiraFraseResposta + diaDaSemana + segundaFraseResposta + terceiraFraseResposta + fimDeSemanaOuDiaUtil);
                break;

            case 2:
                terceiraFraseResposta = "Segunda. ";
                fimDeSemanaOuDiaUtil = "Dia útil.";
                System.out.println(primeiraFraseResposta + diaDaSemana + segundaFraseResposta + terceiraFraseResposta + fimDeSemanaOuDiaUtil);
                break;

            case 3:
                terceiraFraseResposta = "Terça. ";
                fimDeSemanaOuDiaUtil = "Dia útil.";
                System.out.println(primeiraFraseResposta + diaDaSemana + segundaFraseResposta + terceiraFraseResposta + fimDeSemanaOuDiaUtil);
                break;

            case 4:
                terceiraFraseResposta = "Quarta. ";
                fimDeSemanaOuDiaUtil = "Dia útil.";
                System.out.println(primeiraFraseResposta + diaDaSemana + segundaFraseResposta + terceiraFraseResposta + fimDeSemanaOuDiaUtil);
                break;

            case 5:
                terceiraFraseResposta = "Quinta. ";
                fimDeSemanaOuDiaUtil = "Dia útil.";
                System.out.println(primeiraFraseResposta + diaDaSemana + segundaFraseResposta + terceiraFraseResposta + fimDeSemanaOuDiaUtil);
                break;
            case 6:
                terceiraFraseResposta = "Sexta. ";
                fimDeSemanaOuDiaUtil = "Dia útil.";
                System.out.println(primeiraFraseResposta + diaDaSemana + segundaFraseResposta + terceiraFraseResposta + fimDeSemanaOuDiaUtil);
                break;
            case 7:
                terceiraFraseResposta = "Sábado. ";
                fimDeSemanaOuDiaUtil = "Fim de semana.";
                System.out.println(primeiraFraseResposta + diaDaSemana + segundaFraseResposta + terceiraFraseResposta + fimDeSemanaOuDiaUtil);
                break;
            default:
                System.out.println("Opção Digitada inválida. Tente de 1 até 7");
        }
    }
}
