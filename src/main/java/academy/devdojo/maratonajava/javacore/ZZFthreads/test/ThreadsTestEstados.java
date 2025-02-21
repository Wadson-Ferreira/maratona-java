package academy.devdojo.maratonajava.javacore.ZZFthreads.test;

public class ThreadsTestEstados {
    public static void main(String[] args)throws InterruptedException {
        //Cria a thread (estado new)

        Thread t = new Thread(() -> {
            try{
                //Faz a thread dormir por 2 segundos (estado TIMED_WAITTING)
                Thread.sleep(2000);
            } catch(InterruptedException e){
                e.printStackTrace();
            }
        });

        //Exibe o estado inicial (NEW)
        System.out.println("Estado inicial: " + t.getState());

        //inicia a thread (Transição para RUNNABLE)
        t.start();
        System.out.println("Após o start: " + t.getState());

        //Aguarda um pouco para que a thread entre em sleep
        Thread.sleep(500);
        System.out.println("Durante o sleep(): " + t.getState());

        //Aguarda a thread terminar
        t.join();
        System.out.println("após o Join(): " + t.getState());

        //Estado final
        System.out.println("Estado final: " + t.getState());
    }
}
