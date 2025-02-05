package academy.devdojo.maratonajava.javacore.Rdate.test;

import java.util.Date;

public class DateTest01 {
    public static void main(String[] args) {

        Date date = new Date(1729717762199L); //A classe date trabalha em
        // milisegundos com um long a partir da epoch que é 1° janeiro de 1970 00:00:00 GMT

        System.out.println(date);
        // Dessa forma ele vai imprimir a data referente a data inicial + os milisegundos setados acima

        System.out.println(date.getTime());
        //retorna o long que representa a data.

        date.setTime(date.getTime() + 3_600_000L);
        //Assim podemos adicionar mais 1 hora
    }
}
