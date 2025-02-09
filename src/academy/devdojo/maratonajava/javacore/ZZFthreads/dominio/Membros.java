package academy.devdojo.maratonajava.javacore.ZZFthreads.dominio;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class Membros {
    private final Queue<String> emails = new ArrayBlockingQueue<>(10);
    private boolean aberto = true;

    public boolean aberto(){
        return aberto;
    }

    public int emailsPendentes() {
        synchronized (emails){
            return emails.size();
        }
    }

    public void adicionarEmail (String email) {
        synchronized (this.emails){
            String threadNome = Thread.currentThread().getName();
            System.out.println(threadNome + " adicionando email " + email + " na lista");
            this.emails.add(email);
            this.emails.notifyAll();
        }
    }

    public String recuperarEmail () throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " verificando se há emails.");
        synchronized (this.emails){
            while (this.emails.size() == 0) {
                if(!aberto) return null;
                System.out.println(Thread.currentThread().getName()+ " Não tem email disponível na lista, entrando em modo de espera.");
                this.emails.wait();
            }
            return this.emails.poll();
        }
    }

    public void fechar (){
        aberto = false;
        synchronized (this.emails){
            System.out.println(Thread.currentThread().getName() + " Notificando que não estamos pegando mais e-mails.");
            this.emails.notifyAll();
        }
    }
}
