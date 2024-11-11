package academy.devdojo.maratonajava.javacore.Rdate.test;

import java.time.LocalDate;
import java.time.Period;

public class PeriodTest01 {
    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        LocalDate nowAfterTwoYears = LocalDate.now().plusYears(2).plusDays(7);

        Period p1 = Period.between(now, nowAfterTwoYears);
        System.out.println("p1 " + p1);

        Period p2 = Period.ofDays(10);
        System.out.println("p2 " + p2);

        Period p3 = Period.ofWeeks(2);
        System.out.println("p3 " + p3);

        Period p4 = Period.ofMonths(2);
        System.out.println("p4 " + p4);

        Period p5 = Period.ofYears(2);
        System.out.println("p5 " + p5);

        //Está classe não retorna os meses. Podemos fazer algumas "gabirras,
        // mas ainda assim não teremos a quantidade de meses.

        System.out.println(p3.getMonths());
        //aqui por exemplo o retorno é 0 pq o código converte direto para
        // dias sem apresentar a quantidade de meses.

        System.out.println(Period.between(LocalDate.now(),
                LocalDate.now().plusDays(p3.getDays())));
    }
}
