package academy.devdojo.maratonajava.javacore.ZZGconcorrencia.test;

import java.util.concurrent.atomic.AtomicInteger;

class Contador {
    private int contador;

    public int getContador() {
        return contador;
    }

    private AtomicInteger atomicInteger = new AtomicInteger();

    void incrementar() {
        contador++;
        atomicInteger.incrementAndGet();
    }

    public AtomicInteger getAtomicInteger() {
        return atomicInteger;
    }
}
public class AtomicIntegerTest01 {
    public static void main(String[] args) throws InterruptedException {
        Contador contador = new Contador();
        Runnable r = () -> {
            for (int i = 0; i < 10000; i++) {
                contador.incrementar();
            }
        };
        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(contador.getContador());
        System.out.println(contador.getAtomicInteger());
    }
}
