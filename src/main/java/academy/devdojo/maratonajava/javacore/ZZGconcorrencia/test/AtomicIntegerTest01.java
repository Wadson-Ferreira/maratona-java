package academy.devdojo.maratonajava.javacore.ZZGconcorrencia.test;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Contador {
    private int contador;
    private final AtomicInteger atomicInteger = new AtomicInteger();
    private final Lock lock = new ReentrantLock();

    public int getContador() {
        return contador;
    }

    void incrementar() {
        lock.lock();
        try{
            contador++;
            atomicInteger.incrementAndGet();
        }finally {
            lock.unlock();
        }
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
