package academy.devdojo.maratonajava.javacore.Rdate.test;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class ZoneIdTest02 {
    public static void main(String[] args) {
        ZoneId zoneSP = ZoneId.of("America/Sao_Paulo");
        ZoneId zoneUTC = ZoneId.of("UTC");

        System.out.println("Fuso horário de São Paulo: " + zoneSP);
        System.out.println("Fuso horário de UTC: " + zoneUTC);

        ZoneId sistema = ZoneId.systemDefault();
        System.out.println("Fuso horário do sistema: " + sistema);

        LocalDateTime now = LocalDateTime.now();
        System.out.println("Horário e data atual: " + now);

        ZonedDateTime zoneDTSP = now.atZone(zoneSP);
        System.out.println(zoneDTSP);
    }
}
