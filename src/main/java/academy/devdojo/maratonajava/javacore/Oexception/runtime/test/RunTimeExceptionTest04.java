package academy.devdojo.maratonajava.javacore.Oexception.runtime.test;

import java.io.FileNotFoundException;
import java.sql.SQLException;

public class RunTimeExceptionTest04 {
    public static void main(String[] args) {
        try {
            throw new RuntimeException();
        } catch (ArrayIndexOutOfBoundsException | IllegalArgumentException | ArithmeticException e) {
            System.out.println("Dentro de ArrayIndexOutOfBoundsException | IllegalArgumentException | ArithmeticException");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Dentro do IndexOutOfBoundsException");
        }catch (RuntimeException e) {
            System.out.println("Dentro do RuntimeException");
        }

        try{
            talvezLanceException();
        }catch (SQLException|FileNotFoundException e){
            e.printStackTrace();
        }
    }

    private static void talvezLanceException() throws SQLException, FileNotFoundException {

    }
}

