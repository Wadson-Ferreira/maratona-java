package academy.devdojo.maratonajava.javacore.Rdate.test;

import java.time.Instant;
import java.time.LocalDateTime;

public class InstantTest01 {
    public static void main(String[] args) {
        Instant now = Instant.now();
        System.out.println(now);
        System.out.println(LocalDateTime.now());
        System.out.println(now.getEpochSecond());
        System.out.println(now.getNano());
        System.out.println(Instant.ofEpochSecond(3));
        System.out.println(Instant.ofEpochSecond(3, 0));
        System.out.println(Instant.ofEpochSecond(3, 1_000_000_000));
        System.out.println(Instant.ofEpochSecond(3, -1_000_000_000));


        //o T representa o ponto onde para de contar a data e começa o tempo!
        //O Z represeta Zulu time que é o horario neutro, em cima da linha de Greenwich
        // No caso o Instant vai fornecer o horario Zulu, o que facilita no
        // salvamento em banco de dados por ser um horário neutro.
    }

}
