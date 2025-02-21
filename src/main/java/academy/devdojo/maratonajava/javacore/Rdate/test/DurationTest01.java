package academy.devdojo.maratonajava.javacore.Rdate.test;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class DurationTest01 {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime nowAfterTwoYears =
                LocalDateTime.now().plusYears(2).plusMinutes(8);
        LocalTime timeNow = LocalTime.now();
        LocalTime timeMinus7Hours = LocalTime.now().minusHours(7);

        Duration d1 = Duration.between(now, nowAfterTwoYears);
        System.out.println(d1);
        //o P é quando se trabalha com datas, então após o P ele vai
        // aprensetar a data quando solicitado e novamente o T é o time, ele
        // vai apresentar as horas, minutos e segundos até aquela data.

        Duration d2 = Duration.between(timeNow, timeMinus7Hours);
        System.out.println(d2);

        Duration d3 = Duration.between(Instant.now(),
                Instant.now().plusSeconds(1000));
        System.out.println(d3);

        //A durantion não aceita LocalDate pelo fato do LocalDate não ter
        // secundos

        Duration d4 = Duration.ofDays(20);
        System.out.println(d4);

        Duration d5 = Duration.ofMinutes(3);
        System.out.println(d5);

        Duration d6 = Duration.of(3, ChronoUnit.HOURS);
        System.out.println(d6);
    }
}
