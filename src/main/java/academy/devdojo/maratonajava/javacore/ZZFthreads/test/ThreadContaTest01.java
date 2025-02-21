package academy.devdojo.maratonajava.javacore.ZZFthreads.test;

import academy.devdojo.maratonajava.javacore.ZZFthreads.dominio.Conta;

public class ThreadContaTest01 implements Runnable {
    private final Conta conta = new Conta();

    public static void main(String[] args) {
        ThreadContaTest01 threadContaTest01 = new ThreadContaTest01();
        Thread t1 = new Thread(threadContaTest01, "Hestia");
        Thread t2 = new Thread(threadContaTest01, "Bell Cranel");
        t1.start();
        t2.start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            saque(10);
            if (conta.getSaldo() < 0) {
                System.out.println("Saldo insuficiente");
            }
        }
    }

    private void saque(int valor) {
        System.out.println(getThreadName() + "###### Fora do synchronized");
        synchronized (conta) {
            System.out.println(getThreadName() + "******* Dentro do synchronized");
            if (conta.getSaldo() >= valor) {
                System.out.println(getThreadName() + " está indo sacar dinheiro");
                conta.saque(valor);
                System.out.println(getThreadName() + " Saque concluido com sucesso, saldo atual: " + conta.getSaldo());
            } else {
                System.out.println("Saldo insuficiente para " + getThreadName() + " efetuar o saque" + conta.getSaldo());
            }
        }
    }

    private static String getThreadName() {
        return Thread.currentThread().getName();
    }


}
