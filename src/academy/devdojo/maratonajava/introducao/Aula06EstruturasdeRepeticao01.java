package academy.devdojo.maratonajava.introducao;

public class Aula06EstruturasdeRepeticao01 {
    public static void main(String[] args) {
        // while, do while e o for
        int count = 0;
        while (count < 10) {
            System.out.println(count);
            count += 1;
        }

        count = 0;

        do {
            System.out.println("dentro do do-while " + ++count);
        } while (count < 10);

        for (count=0; count<10; count++ ){
            System.out.println("For " + count);
        }
    }
}
