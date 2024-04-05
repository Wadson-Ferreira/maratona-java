package academy.devdojo.maratonajava.introducao;
import java.util.Scanner;
/**
Solicite ao usuário que insira uma frase;
Armazene a frase em uma variável;
Converta a frase para letras minúsculas para simplificar a contagem;
Crie um array para armazenar as vogais;
Utilize um loop para percorrer cada caractere da frase;
Verifique se cada caractere é uma vogal e, se for, incremente o contador
 correspondente;
Exiba a quantidade de cada vogal presente na frase;
 */
public class ExercicioDeFixacao {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Digite uma frase: ");
        String fraseDoUsuario = entrada.nextLine();

        fraseDoUsuario = fraseDoUsuario.toLowerCase();

        int[] contadorVogais = new int[5];

        char[] caracteres = fraseDoUsuario.toCharArray();
        for (char caractere : caracteres){
            switch (caractere){
                case 'a':
                    contadorVogais[0]++;
                    break;
                case 'e':
                    contadorVogais[1]++;
                    break;
                case 'i':
                    contadorVogais[2]++;
                    break;
                case 'o':
                    contadorVogais[3]++;
                    break;
                case 'u':
                    contadorVogais[4]++;
                    break;
            }
        }

        String quantidadeDeVogais = "Quantidade de vogais: ";
        System.out.println(quantidadeDeVogais);

        System.out.println("- A:" + contadorVogais[0]);
        System.out.println("- E:" + contadorVogais[1]);
        System.out.println("- I:" + contadorVogais[2]);
        System.out.println("- O:" + contadorVogais[3]);
        System.out.println("- U:" + contadorVogais[4]);

    }
}
