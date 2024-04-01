package academy.devdojo.maratonajava.introducao;
/** Dado um determinado salário, qual o valor de imposto tenho que pagar?
 De 0 até 34.712 tem que pagar 9.70%
 De 34.713 até 68.507 tem que pagar 37.35%
 De 68.508 para cima tem que pagar 49.50%
 */
public class Aula05EstruturasCondicionais04 {
    public static void main(String[] args) {
        double salarioAnual = 70000;
        double primeiraFaixa = 9.7 / 100;
        double segundaFaixa = 37.35 / 100;
        double terceiraFaixa = 49.50 / 100;
        double resultado;
        String valorDoImposto = "Você vai pagar um imposto de: ";

        String taxa;

        if (salarioAnual < 34713){
            taxa = ("Sua taxa é de 9.70%");
            resultado = salarioAnual * primeiraFaixa;
        }else if(salarioAnual >= 34713 && salarioAnual <= 68507){
            taxa = ("Sua taxa é de 37.35%");
            resultado = salarioAnual * segundaFaixa;
        }else{
            taxa = ("Sua taxa é de 49.50%");
            resultado = salarioAnual * terceiraFaixa;
        }
        System.out.println(taxa);
        System.out.println(valorDoImposto + resultado);
    }
}
