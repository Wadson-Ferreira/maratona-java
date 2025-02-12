package academy.devdojo.maratonajava.javacore.ZZGconcorrencia.servico;

import academy.devdojo.maratonajava.javacore.ZZGconcorrencia.dominio.Membros;

public class ServicoEntregaEmail implements Runnable {
    private final Membros membros;

    public ServicoEntregaEmail(Membros membros) {
        this.membros = membros;
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + ": iniciando entrega dos emails.");
        while (membros.aberto() || membros.emailsPendentes() > 0){
            try {
                String email = membros.recuperarEmail();
                if (email == null) continue;
                System.out.println(threadName + ": enviando email para " + email);
                Thread.sleep(2000);
                System.out.println(threadName + ": enviou email com sucesso para: " + email);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(threadName + ": finalizando entrega dos emails com sucesso!");
    }
}
