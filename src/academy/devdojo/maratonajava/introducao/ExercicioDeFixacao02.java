package academy.devdojo.maratonajava.introducao;
import java.util.Scanner;
/**
 Solicite ao usuário que insira o primeiro número;
 Solicite ao usuário que insira o segundo número;
 Solicite ao usuário que insira a operação desejada;
 Realize a operação solicitada com os dois números;
 Exiba o resultado da operação;
 */
public class ExercicioDeFixacao02 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Digite um número: ");
        float primeiroNumero = entrada.nextFloat();

        Scanner entrada3 = new Scanner(System.in);
        System.out.println("Escolha entre +, -, * ou /: ");
        String operacao = entrada3.nextLine();

        Scanner entrada2 = new Scanner(System.in);
        System.out.println("Digite outro número: ");
        float segundoNumero = entrada2.nextFloat();

        String respostaResultado = "O resultado de: ";
        String complemento = "é: ";
        String espacamento = " ";

        float resultado = 0;

        switch (operacao){
            case "+":
                resultado = primeiroNumero + segundoNumero;
                break;
            case "-":
                resultado = primeiroNumero - segundoNumero;
                break;
            case "*":
                resultado = primeiroNumero * segundoNumero;
                break;
            case "/":
                resultado = primeiroNumero / segundoNumero;
                break;
        }

        System.out.println(respostaResultado+primeiroNumero+espacamento+operacao+espacamento+segundoNumero+espacamento+complemento+resultado);



    }
}
