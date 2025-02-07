package academy.devdojo.maratonajava.javacore.ZZFthreads.test;

import java.util.Arrays;

class TheadExemploRunnable2 implements Runnable {
    private final String c;

    public TheadExemploRunnable2(String c) {
        this.c = c;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        for (int i = 0; i < 500; i++) {
            System.out.print(c);
            if (i % 100 == 0) {
                System.out.println();
            }
            Thread.yield();
        }
    }
}

public class ThreadTest02 {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new TheadExemploRunnable2("KA-"),"T1");
        Thread t2 = new Thread(new TheadExemploRunnable2("ME-"),"T2");
        t1.setPriority(Thread.MAX_PRIORITY);

        t1.start();
        t1.join();
        t2.start();
    }
}
