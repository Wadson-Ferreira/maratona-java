package academy.devdojo.maratonajava.javacore.Sformatacao.test;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class NumberFormatTest02 {
    public static void main(String[] args) {

        Locale localeBR = Locale.of("pt","BR");
        Locale localeJP = Locale.JAPAN;
        Locale localeIT = Locale.ITALY;
        NumberFormat[] nfa = new NumberFormat[4];
        nfa[0] = NumberFormat.getCurrencyInstance();
        nfa[1] = NumberFormat.getCurrencyInstance(localeBR);
        nfa[2] = NumberFormat.getCurrencyInstance(localeJP);
        nfa[3] = NumberFormat.getCurrencyInstance(localeIT);
        double valor = 10_000.2130;
        for (NumberFormat numberFormat : nfa){
            System.out.println(numberFormat.getMaximumFractionDigits());
            numberFormat.setMaximumFractionDigits(2);
            //Seta até qual casa decimal vai mostrar!
            System.out.println(numberFormat.format(valor));
        }

        String valorString = "￥10,000.21";
        //Quando é financeiro deve-se usar a forma correta de escrever a
        // moeda que deseja fazer o parse.
        try {
            System.out.println(nfa[2].parse(valorString));
        } catch (ParseException e) {
            e.printStackTrace();
        }


    }
}
