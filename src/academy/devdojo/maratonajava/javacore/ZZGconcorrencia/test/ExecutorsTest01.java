package academy.devdojo.maratonajava.javacore.ZZGconcorrencia.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Imprimir implements Runnable {
    private final int num;

    public Imprimir(int num) {
        this.num = num;
    }

    @Override
    public void run() {
        System.out.printf("%s Iniciou: %d%n", getName(), num);
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("%s Finalizado %n", getName());
    }

    private static String getName() {
        return Thread.currentThread().getName();
    }
}
public class ExecutorsTest01 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.execute(new Imprimir(1));
        executorService.execute(new Imprimir(2));
        executorService.execute(new Imprimir(3));
        executorService.execute(new Imprimir(4));
        executorService.shutdown();

        System.out.println("Programa finalizado com sucesso!");

    }
}
