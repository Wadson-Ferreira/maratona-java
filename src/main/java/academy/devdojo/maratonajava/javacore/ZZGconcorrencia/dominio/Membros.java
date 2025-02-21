package academy.devdojo.maratonajava.javacore.ZZGconcorrencia.dominio;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Membros {
    private final Queue<String> emails = new ArrayBlockingQueue<>(10);
    private final ReentrantLock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();
    private boolean aberto = true;

    public boolean aberto() {
        return aberto;
    }

    public int emailsPendentes() {
        lock.lock();
        try {
            return emails.size();
        } finally {
            lock.unlock();
        }

    }

    public void adicionarEmail(String email) {
        lock.lock();
        try {
            String threadNome = Thread.currentThread().getName();
            System.out.println(threadNome + " adicionando email " + email + " na lista");
            this.emails.add(email);
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public String recuperarEmail() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " verificando se há emails.");
        lock.lock();
        try {
            while (this.emails.isEmpty()) {
                if (!aberto) return null;
                System.out.println(Thread.currentThread().getName() + " Não tem email disponível na lista, entrando em modo de espera.");
                condition.await();
            }
            return this.emails.poll();
        } finally {
            lock.unlock();
        }
    }

    public void fechar() {
        aberto = false;
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " Notificando que não estamos pegando mais e-mails.");
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }
}
