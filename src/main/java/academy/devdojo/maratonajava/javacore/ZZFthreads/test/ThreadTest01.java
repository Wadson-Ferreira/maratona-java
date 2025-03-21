package academy.devdojo.maratonajava.javacore.ZZFthreads.test;

import java.util.Arrays;

class ThreadExemplo extends Thread{
    private final char c;

    public ThreadExemplo(char c) {
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
        }
    }
}

    class  TheadExemploRunnable implements Runnable{
    private final char c;

    public TheadExemploRunnable(char c) {
        this.c = c;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        for (int i = 0; i < 500; i++) {
            System.out.print(c);
            if (i % 100 == 0){
                System.out.println();
            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
public class ThreadTest01 {
    public static void main(String[] args) {
//        ThreadExemplo t1 = new ThreadExemplo('A');
//        ThreadExemplo t2 = new ThreadExemplo('B');
//        ThreadExemplo t3 = new ThreadExemplo('C');
//        ThreadExemplo t4 = new ThreadExemplo('D');

        Thread t1 = new Thread(new TheadExemploRunnable('A'), "T1A");
        Thread t2 = new Thread(new TheadExemploRunnable('B'),"T2B");
        Thread t3 = new Thread(new TheadExemploRunnable('C'),"T3C");
        Thread t4 = new Thread(new TheadExemploRunnable('D'),"T4D");

        t4.setPriority(Thread.MAX_PRIORITY);

        for (Thread thread : Arrays.asList(t1, t2, t3, t4)) {
            thread.start();
        }
    }
}
