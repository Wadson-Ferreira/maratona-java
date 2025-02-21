package academy.devdojo.maratonajava.javacore.ZZGconcorrencia.test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Trabalhador implements Runnable {
    private String nome;
    private ReentrantLock lock;

    public Trabalhador(String nome, ReentrantLock lock) {
        this.nome = nome;
        this.lock = lock;
    }

    @Override
    public void run() {

        try {
            lock.tryLock();
            if(lock.isHeldByCurrentThread()) {
                System.out.printf("Thread %s pegou o Lock%n", nome);
            }
            System.out.printf("Thread %s entrou em uma sessão crítica%n", nome);
            System.out.printf("Thread %s vai esperar 2%n", nome);
            Thread.sleep(2000);
            System.out.printf("Thread %s finalizou a espera 2%n", nome);

            System.out.printf("%d Threads esperando na fila%n", lock.getQueueLength());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (lock.isHeldByCurrentThread()) {
                lock.unlock();
            }
        }
    }
}

public class ReentrantLockTEst01 {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        new Thread(new Trabalhador("A", lock)).start();
        new Thread(new Trabalhador("B", lock)).start();
        new Thread(new Trabalhador("C", lock)).start();
        new Thread(new Trabalhador("D", lock)).start();
        new Thread(new Trabalhador("E", lock)).start();
        new Thread(new Trabalhador("F", lock)).start();
        new Thread(new Trabalhador("G", lock)).start();


    }
}
