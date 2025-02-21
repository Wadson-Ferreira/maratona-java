package academy.devdojo.maratonajava.javacore.ZZFthreads.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class ThreadSafeNome{
    private final List<String> nomes = new ArrayList<String>();

    public synchronized void add (String nome){
        nomes.add(nome);
    }

    public synchronized void removerPrimeiro(){
        if(nomes.size() > 0){
            System.out.println(Thread.currentThread().getName());
            System.out.println(nomes.remove(0));
        }
    }
}

public class ThreadSafeTest01 {
    public static void main(String[] args) {
        ThreadSafeNome threadSafeNome = new ThreadSafeNome();
        threadSafeNome.add ("Wadson");
        Runnable r = threadSafeNome::removerPrimeiro;
        new Thread(r).start();
        new Thread(r).start();
    }
}
