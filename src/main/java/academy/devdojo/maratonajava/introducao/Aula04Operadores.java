package academy.devdojo.maratonajava.introducao;

public class Aula04Operadores {
    public static void main(String[] args) {
          // operadores básicos: + - * /
        int numero01 = 10;
        int numero02 = 20;
        int resultadosoma = numero01 + numero02;
        int resultadodiv = numero01 / numero02;

        System.out.println(numero02-numero01);
        System.out.println(numero02+numero01);
        System.out.println(numero02*numero01);
        System.out.println(numero02/numero01);
        System.out.println("Valor "+numero02+numero01);
        System.out.println(numero02+numero01+"Valor "+numero02+numero01);
        System.out.println(resultadosoma);
        System.out.println(resultadodiv);

        //operador de resto %
        int resto = 21 % 2;
        System.out.println(resto);

        // Os operadores relacionais sempre vão retornar um valor booleano, sempre true or false < > <= >= == !=
        boolean isDezMaiorQueVinte = 10 > 20;
        boolean isDezMenorQueVinte = 10 < 20;
        boolean isDezIgualQueVinte = 10 == 20;
        boolean isDezIgualQueDez = 10 == 10;
        boolean isDezDiferenteQueDez = 10 != 10;

        System.out.println("isDezMaiorQueVinte "+ isDezMaiorQueVinte);
        System.out.println("isDezMenorQueVinte "+ isDezMenorQueVinte);
        System.out.println("isDezIgualQueVinte "+ isDezIgualQueVinte);
        System.out.println("isDezIgualQueDez "+ isDezIgualQueDez);
        System.out.println("isDezDiferenteQueDez "+ isDezDiferenteQueDez);

        // operadores lógicos && (AND) || (or) ! (Logical not)

        int idade = 29;
        float salario = 3500F;
        boolean isDentroDaLeiDaLeiMaiorQueTrina = idade >= 30 && salario >= 4612;
        boolean isDentroDaLeiDaLeiMenorQueTrina = idade < 30 && salario >= 3381;

        System.out.println("isDentroDaLeiDaLeiMaiorQueTrina " + isDentroDaLeiDaLeiMaiorQueTrina);
        System.out.println("isDentroDaLeiDaLeiMenorQueTrina " + isDentroDaLeiDaLeiMenorQueTrina);

        double valorTotalContaCorrente = 200;
        double valorTotalContaPoupanca = 3500;
        float valorPlaystation = 3200F;
        boolean isPlaystationCincoCompravel =
                valorTotalContaCorrente > valorPlaystation || valorTotalContaPoupanca > valorPlaystation;
        System.out.println("isPlaystationCincoCompravel " + isPlaystationCincoCompravel);

        //Operadores de atribução = += -= *= /= %=

        double bonus = 1800;
//        bonus = bonus + 1000;
        bonus += 1000;
        bonus -= 1000;
        bonus *= 2;
        bonus /= 2;
        bonus %= 2;
        System.out.println(bonus);

        //++ --
        int contador = 0;
        contador += 1;
        contador ++;
        contador --;
        ++contador;
        --contador;
        int contador2 = 0;
        System.out.println(contador2++);
        System.out.println(++contador2);
        System.out.println(contador);

    }
}
