package academy.devdojo.maratonajava.javacore.Rdate.test;

import java.util.Calendar;
import java.util.Date;

public class CalendarTest01 {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar);

        if(calendar.getFirstDayOfWeek() == Calendar.SUNDAY){
            System.out.println("Domingo é o primeiro dia da semana!");
        }

        System.out.println(calendar.get(Calendar.DAY_OF_WEEK));
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
        System.out.println(calendar.get(Calendar.DAY_OF_YEAR));
        System.out.println(calendar.get(Calendar.MONTH));
        System.out.println(calendar.get(Calendar.YEAR));
        System.out.println(calendar.get(Calendar.DATE));
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
        System.out.println(calendar.get(Calendar.WEEK_OF_MONTH));

        calendar.add(Calendar.DAY_OF_MONTH, 2);
        calendar.add(Calendar.HOUR,2);

        calendar.roll(Calendar.HOUR,2);
        //O metodo Roll Adiciona sem virar o dia, ou o mês ou o ano

        Date date = calendar.getTime();
        System.out.println(date);
        //Essa é uma forma de imprimir a data utilizando a classe Date

    }
}
