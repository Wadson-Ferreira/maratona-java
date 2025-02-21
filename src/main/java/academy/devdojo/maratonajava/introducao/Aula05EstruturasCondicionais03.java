package academy.devdojo.maratonajava.introducao;

public class Aula05EstruturasCondicionais03 {
    public static void main(String[] args) {
        // Doar se salario > 5000

        double salario = 6000;
        String mensagemDoar = "Eu vou doar 500 para o DevDojo";
        String mensagemNaoDoa = "Ainda não tenho condições, mas vou ter!";
        //(condição) ? verdadeiro : falso
        String resultado = salario > 5000 ? mensagemDoar : mensagemNaoDoa;
        String resultado2 = salario > 5000 ? "Eu vou doar 500 para o DevDojo" :
                "Ainda não tenho condições, mas vou " + "ter!";

        System.out.println(resultado);
        System.out.println(salario > 5000 ? mensagemDoar : mensagemNaoDoa);
        System.out.println(resultado2);

    }
}
