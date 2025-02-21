package academy.devdojo.maratonajava.javacore.Pwrapper.test;

public class WrapperTest01 {
    public static void main(String[] args) {
        byte byteP = 1;
        short shortP = 1;
        int intP = 1;
        long longP = 10L;
        float floatP = 1.0F;
        double doubleP = 1.0D;
        char charP = 'W';
        boolean booleanP = false;

        Byte byteW = 1;
        Short shortW = 1;
        Integer intW = 1; //autoboxing
        Long longW = 10L;
        Float floatW = 1.0F;
        Double doubleW = 1.0D;
        Character charW = 'W';
        Boolean booleanW = false;

        //É importante sempre darmos prioridade para trabalhar com tipos
        // primitvos, utilizando assim as classes wrapper somente quando
        // necessário por exemplo quando vamos trabalhar com situações onde é
        // necessário trabalhar com a referencia do objeto.

        int i = intW; //unboxing
        Integer intW2 = Integer.parseInt("1");
        boolean verdadeiro = Boolean.parseBoolean("TruE");
        System.out.println(verdadeiro);

        System.out.println(Character.isDigit('A'));
        System.out.println(Character.isDigit('9'));
        System.out.println(Character.isLetterOrDigit('9'));
        System.out.println(Character.isLowerCase('A'));
        System.out.println(Character.isUpperCase('b'));
        System.out.println(Character.toUpperCase('b'));
        System.out.println(Character.toLowerCase('B'));

        //Autoboxing é quando você tem um tipo primitivo e o java faz a
        // conversão automatica para um wrapper e Unboxing é quando você
        // converte um tipo wrapper para um tipo primitivo.

    }
}
