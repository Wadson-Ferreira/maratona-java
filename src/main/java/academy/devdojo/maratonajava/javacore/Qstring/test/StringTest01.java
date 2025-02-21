package academy.devdojo.maratonajava.javacore.Qstring.test;

public class StringTest01 {
    public static void main(String[] args) {
        String nome = "William"; //String constant pool
        String nome2 = "William";
        nome = nome.concat(" Suane");
        System.out.println(nome);
        System.out.println(nome == nome2);

        /* Quando trabalhamos com Strings literais, elas fazem referencia ao
        objeto criado dentro da String constant pool, assim elas se tornam
        imutaveis e o java reconhece caso elas sejam iguais. Já ao trabalhar
        com String como objeto (exemplo abaixo) a referencia do objeto é
        criada fora do String constant pool, assim o java não reconhece como
        a referencia sendo a mesma*/

        String nome3 = new String("William"); //1 variavel de refência, 2
        // objeto do tipo string, 3 uma string no pool de string
        System.out.println(nome2 == nome3);
        System.out.println(nome2 == nome3.intern());

    }
}
