package academy.devdojo.maratonajava.javacore.Uregex.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatcherTest01 {
    public static void main(String[] args) {
        // Expressoes regulares funcionam atraves de meta caracteres ele
        // strazem os valores que procuramos e também servem para validacoes

        String regex ="aba";
        // String texto = "abaaba";
        String texto2 = "abababa";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(texto2);
        System.out.println("Texto:  " + texto2);
        System.out.println("Indice: 0123456789");
        System.out.println("regex: " + regex);
        System.out.println("Posicoes encontradas");
        while (matcher.find()) {
            System.out.print(matcher.start() + " ");
        }
    }
}
