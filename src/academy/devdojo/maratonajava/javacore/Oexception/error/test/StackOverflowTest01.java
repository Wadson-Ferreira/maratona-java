package academy.devdojo.maratonajava.javacore.Oexception.error.test;

public class StackOverflowTest01 {
    public static void main(String[] args) {
        recursividade();
    }

    public static void recursividade (){
        recursividade();
    }

    /*Error é algo que acontece na JVM que provavelmente não vai ser possível
     recurar a execução!*/
}
