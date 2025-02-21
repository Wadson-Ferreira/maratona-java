package academy.devdojo.maratonajava.javacore.ZZEstreams.test;

import java.util.stream.LongStream;
import java.util.stream.Stream;

public class StreamTest16 {

    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().availableProcessors());
        long num = 10_000_000;
        somaFor(num);
        System.out.println("-----------");
        somaPorStreamIterate(num);
        System.out.println("-----------");
        somaPorParallelStreamIterate(num);
        System.out.println("-----------");
        somaPorLongStreamIterate(num);
        System.out.println("-----------");
        somaPorParallelLongStreamIterate(num);
    }

    private static void somaFor(long num){
        System.out.println("somaFor");
        long resultado = 0;
        long inicio = System.currentTimeMillis();
        for(long i=1; i<=num; i++){
            resultado += i;
        }
        long fim = System.currentTimeMillis();
        System.out.println(resultado + " " + (fim - inicio) + "ms");
    }

    private static void somaPorStreamIterate (long num){
        System.out.println("somaPorStreamIterate");
        long inicio = System.currentTimeMillis();
        long resultado = Stream.iterate(1L, i-> i+1).limit(num).reduce(0L,Long::sum);
        long fim = System.currentTimeMillis();
        System.out.println(resultado + " " + (fim - inicio) + "ms");
    }

    private static void somaPorParallelStreamIterate (long num){
        System.out.println("somaPorParallelStreamIterate");
        long inicio = System.currentTimeMillis();
        long resultado = Stream.iterate(1L, i-> i+1).parallel().limit(num).reduce(0L,Long::sum);
        long fim = System.currentTimeMillis();
        System.out.println(resultado + " " + (fim - inicio) + "ms");
    }

    private static void somaPorLongStreamIterate (long num){
        System.out.println("somaPorLongStreamIterate");
        long inicio = System.currentTimeMillis();
        long resultado = LongStream.rangeClosed(1L, num).reduce(0L,Long::sum);
        long fim = System.currentTimeMillis();
        System.out.println(resultado + " " + (fim - inicio) + "ms");
    }

    private static void somaPorParallelLongStreamIterate (long num){
        System.out.println("somaPorParallelLongStreamIterate");
        long inicio = System.currentTimeMillis();
        long resultado = LongStream.rangeClosed(1L, num).parallel().reduce(0L,Long::sum);
        long fim = System.currentTimeMillis();
        System.out.println(resultado + " " + (fim - inicio) + "ms");
    }
}
