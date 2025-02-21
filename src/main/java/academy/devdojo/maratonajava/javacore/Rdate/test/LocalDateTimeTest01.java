package academy.devdojo.maratonajava.javacore.Rdate.test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

public class LocalDateTimeTest01 {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now.withNano(0));

        System.out.println("-------------------");

        LocalDate date = LocalDate.of(2019, Month.NOVEMBER, 18);
        LocalTime time = LocalTime.of(16, 30, 59);
        System.out.println(date);
        System.out.println(time);

        System.out.println("-------------------");

        LocalDate date2 = LocalDate.parse("2019-08-18");
        LocalTime time2 = LocalTime.parse("16:30:59");
        System.out.println(date2);
        System.out.println(time2);

        System.out.println("-------------------");

        LocalDateTime date3 = date.atTime(time);
        System.out.println(date3);

        System.out.println("-------------------");

        LocalDateTime date4 = time.atDate(date);
        System.out.println(date4);
    }
}
