package academy.devdojo.maratonajava.javacore.Sformatacao.test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DateTimeFromatterTest01 {
    public static void main(String[] args) {
        //Todas as vezes que tem a palavra format é por estar transformando o
        // objeto em um objeto e quando vem a palavra parse está
        // transformando uma string em um objeto

        LocalDate date = LocalDate.now();
        String s1 = date.format(DateTimeFormatter.BASIC_ISO_DATE);
        String s2 = date.format(DateTimeFormatter.ISO_DATE);
        String s3 = date.format(DateTimeFormatter.ISO_LOCAL_DATE);

        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        System.out.println("----------------");

        LocalDate parse1 = LocalDate.parse("20241125", DateTimeFormatter.BASIC_ISO_DATE);
        System.out.println(parse1);
        LocalDate parse2 = LocalDate.parse("2024-11-25", DateTimeFormatter.ISO_DATE);
        System.out.println(parse2);
        LocalDate parse3 = LocalDate.parse("2024-11-25", DateTimeFormatter.ISO_LOCAL_DATE);
        System.out.println(parse3);

        System.out.println("-----------------------");

        LocalDateTime now = LocalDateTime.now();
        String s4 = now.format(DateTimeFormatter.ISO_DATE_TIME);
        System.out.println(s4);

        LocalDateTime parse4 = LocalDateTime.parse("2024-11-25T16:00:31.7018775", DateTimeFormatter.ISO_DATE_TIME);
        //Não é preciso passar o DateTimeFormatter.ISO_DATE_TIME
        System.out.println(parse4);

        LocalDateTime parse5 = LocalDateTime.parse(s4, DateTimeFormatter.ISO_DATE_TIME);
        System.out.println(parse5);

        DateTimeFormatter formatterBR = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter formatterEUA = DateTimeFormatter.ofPattern("MM/dd" +
                "/yyyy");

        String formatBR = LocalDate.now().format(formatterBR);
        System.out.println(formatBR);
        LocalDate parseBR = LocalDate.parse("25/11/2024", formatterBR);
        System.out.println(parseBR);

        DateTimeFormatter formatterGR = DateTimeFormatter.ofPattern("dd.MMMM.yyyy", Locale.GERMAN);
        String formatGR = LocalDate.now().format(formatterGR);
        System.out.println(formatGR);

        LocalDate parseGR = LocalDate.parse("25.November.2024", formatterGR);
        System.out.println(parseGR);
    }
}
