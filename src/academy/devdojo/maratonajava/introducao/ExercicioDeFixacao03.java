package academy.devdojo.maratonajava.introducao;
import java.util.Scanner;
/**
 Solicite ao usuário que insira um número inteiro;
 Verifique se o número inserido é divisível apenas por 1 e por ele mesmo;
 Exiba uma mensagem indicando se o número é primo ou não.
*/
public class ExercicioDeFixacao03 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Digite um número: ");
        int num = entrada.nextInt();

        boolean numPrimo = true;

        for (int i = 2; i < Math.sqrt(num); i++) {
            if (num % i == 0){
                numPrimo = false;
                break;
            }
        }
        String oNumero = "O número: ";
        String naoPrimo = " não é primo.";
        String ehPrimo = " é primo";

        if (num <=1 ){
            System.out.println(oNumero+num+naoPrimo);
        }else if(numPrimo){
            System.out.println(oNumero+num+ehPrimo);
        }else{
            System.out.println(oNumero+num+naoPrimo);
        }
    }
}
