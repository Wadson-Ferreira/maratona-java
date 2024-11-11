package academy.devdojo.maratonajava.javacore.Rdate.test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAdjusters;

public class TemporalAdjustersTest01 {
    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        now = now.withDayOfMonth(11);
        System.out.println(now);
        System.out.println(now.getDayOfWeek());

        //O with vai trocar exatamente o valor que você esta colocando, seja
        // dia, mês ou ano. No exemplo acima mudamos a data para o dia 20 do
        // mês 11

        LocalDate now2 = LocalDate.now();
        now2 = now2.with(ChronoField.DAY_OF_MONTH, 15);
        System.out.println(now2);
        System.out.println("----------------");

        now =
                LocalDate.now().with(TemporalAdjusters.nextOrSame(DayOfWeek.MONDAY));
        System.out.println(now);
        System.out.println(now.getDayOfWeek());

        now =
                LocalDate.now().with(TemporalAdjusters.next(DayOfWeek.MONDAY));
        System.out.println(now);
        System.out.println(now.getDayOfWeek());

        now =
                LocalDate.now().with(TemporalAdjusters.previous(DayOfWeek.MONDAY));
        System.out.println(now);
        System.out.println(now.getDayOfWeek());

        now =
                LocalDate.now().with(TemporalAdjusters.firstDayOfMonth());
        System.out.println(now);
        System.out.println(now.getDayOfWeek());

        now =
                LocalDate.now().with(TemporalAdjusters.lastDayOfMonth());
        System.out.println(now);
        System.out.println(now.getDayOfWeek());

        now =
                LocalDate.now().with(TemporalAdjusters.firstDayOfNextYear());
        System.out.println(now);
        System.out.println(now.getDayOfWeek());

        now =
                LocalDate.now().with(TemporalAdjusters.lastDayOfYear());
        System.out.println(now);
        System.out.println(now.getDayOfWeek());


    }
}
