package academy.devdojo.maratonajava.javacore.Sformatacao.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateFormatTest01 {
    public static void main(String[] args) {
        String pattern = "yyyy.MM.dd G 'at' HH:mm:ss z";
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        System.out.println(sdf.format(new Date()));

        //Outro exemplo

        String italia = "'Italia' dd 'de' MMMM 'de' yyyy";
        SimpleDateFormat sdfItalia = new SimpleDateFormat(italia);
        System.out.println(sdfItalia.format(new Date()));
        try {
            System.out.println(sdfItalia.parse("Italia 07 de novembro de 2024"));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        //Ao usar o parse deve-se usar o mesmo padrão que o da saída da string

        //Outro exemplo

        String goiania = "'Goiânia' EEEE 'Dia' dd 'de' MMMM 'de' yyyy";
        SimpleDateFormat sdfGoiania = new SimpleDateFormat(goiania);
        System.out.println(sdfGoiania.format(new Date()));
    }
}
