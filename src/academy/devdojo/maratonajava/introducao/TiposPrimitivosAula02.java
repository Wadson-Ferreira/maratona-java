package academy.devdojo.maratonajava.introducao;

public class TiposPrimitivosAula02 {
    public static void main(String[] args) {
        // int, double, float, char, byte, short, long, boolean
        int idade = 10;
        long numeroGrande = 100000;
        double  salarioDouble = 2000;
        float  salarioFloat = 2500;
        byte    idadeByte = 127;
        short  idadeShort = 14;
        boolean verdadeiro = true;
        boolean falso = false;
        char caractere = 'M';
        char caractere2 = 15;

        String nome = "Goku";
        var nome2 = "Vegeta";

        System.out.println(idade);
        System.out.println(numeroGrande);
        System.out.println(salarioDouble);
        System.out.println(salarioFloat);
        System.out.println(idadeByte);
        System.out.println(idadeShort);
        System.out.println(verdadeiro);
        System.out.println(falso);
        System.out.println(caractere);
        System.out.println(caractere2);
        System.out.println("Oi meu nome é " + nome);
        System.out.println("Oi meu nome é " + nome2);
        System.out.println("A idade é: " + idade + " anos");
        System.out.println("idade");
    }
}
