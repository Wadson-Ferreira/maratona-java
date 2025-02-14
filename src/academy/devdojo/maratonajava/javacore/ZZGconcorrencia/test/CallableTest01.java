package academy.devdojo.maratonajava.javacore.ZZGconcorrencia.test;

import java.util.concurrent.*;

class numeroAleatorioCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        int numAleatorio = ThreadLocalRandom.current().nextInt(1, 11);
        for (int i = 0; i < numAleatorio; i++) {
            System.out.printf("%s executando uma tarefa callable...%n", getName());
        }
        return String.format("%s terminou e o número aleatorio é %d", getName(), numAleatorio);
    }

    private static String getName() {
        return Thread.currentThread().getName();
    }
}
public class CallableTest01 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        numeroAleatorioCallable numeroAleatorioCallable = new numeroAleatorioCallable();
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Future<String> future = executorService.submit(numeroAleatorioCallable);
        String s = future.get();
        System.out.printf("Programa finalizado %s", s);
        executorService.shutdown();
    }
}
