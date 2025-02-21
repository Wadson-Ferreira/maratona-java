package academy.devdojo.maratonajava.javacore.ZZGconcorrencia.test;

import java.util.concurrent.*;

public class FutureTest01 {
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Double> requerimentoDollar = executorService.submit(()->{
            TimeUnit.SECONDS.sleep(5);
            return 5.71D;
        });
        System.out.println(fazendoAlgo());
        Double dollarRequerido = requerimentoDollar.get(3, TimeUnit.SECONDS);
        System.out.println("Dollar: " + dollarRequerido);
        executorService.shutdown();
    }
    private static long fazendoAlgo(){
        System.out.println(Thread.currentThread().getName());
        long sum = 0;
        for (int i = 0; i < 1_000_000; i++) {
            sum += i;
        }
        return sum;
    }
}
