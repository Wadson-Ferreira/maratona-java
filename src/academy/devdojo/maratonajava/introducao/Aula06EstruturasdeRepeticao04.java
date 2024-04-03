package academy.devdojo.maratonajava.introducao;

import java.util.Scanner;

public class Aula06EstruturasdeRepeticao04 {
    //Dado o valor de um carro, descubra em quantas vezes ele pode ser parcelado
    // condição é que o valor da parcela >=1000
    public static void main(String[] args) {
        String resposta1 = "Seu carro pode ser pago em até: ";
        String reposta2 = " parcelas.";
        String resposta3 = "No valor dê: ";

        Scanner entrada = new Scanner(System.in);
        System.out.println("Digite o valor do carro: ");
        int valorDoCarro = entrada.nextInt();

        for (double numeroDeParcelas = 1; numeroDeParcelas < valorDoCarro; numeroDeParcelas++) {
            double valorParcela = valorDoCarro / numeroDeParcelas;
            if (valorParcela < 1000) {
                break;
            }
            System.out.println(resposta1 + numeroDeParcelas + reposta2 + resposta3 + valorParcela);

        }
    }
}
