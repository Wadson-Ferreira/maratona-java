package academy.devdojo.maratonajava.javacore.Sformatacao.test;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Locale;

public class LocaLeTest01 {
    public static void main(String[] args) {
        /*
        Locale localeItaly = new Locale("it", "IT");
        Locale localeCH = new Locale("it", "CH");
        Locale localeBR = new Locale("pt", "BR");
        depreciado
        */


        Locale localeItaly = Locale.ITALY;
        Locale localeCH = Locale.of("ch", "CH");
        Locale localeBR = Locale.of("pt", "BR");


        Calendar calendar = Calendar.getInstance();

        DateFormat df1 = DateFormat.getDateInstance(DateFormat.FULL,
                localeItaly);
        DateFormat df2 = DateFormat.getDateInstance(DateFormat.FULL,
                localeCH);

        DateFormat df3 = DateFormat.getDateInstance(DateFormat.FULL,localeBR);
        System.out.println("Italia " + df1.format (calendar.getTime()));
        System.out.println("Suiça " + df2.format(calendar.getTime()));
        System.out.println("Brasil " + df3.format(calendar.getTime()));

        System.out.println(localeItaly.getDisplayCountry());
        System.out.println(localeBR.getDisplayCountry(localeItaly));
        System.out.println(localeCH.getDisplayCountry());


    }
}
