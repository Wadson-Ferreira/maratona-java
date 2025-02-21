package academy.devdojo.maratonajava.javacore.ZZFthreads.test;

import academy.devdojo.maratonajava.javacore.ZZFthreads.dominio.Membros;
import academy.devdojo.maratonajava.javacore.ZZFthreads.servico.ServicoEntregaEmail;

import javax.swing.*;

public class EmailEntregaTest01 {
    public static void main(String[] args) {
        Membros membros = new Membros();
        Thread jiraya = new Thread(new ServicoEntregaEmail(membros), "Jiraya");
        Thread kakashi = new Thread(new ServicoEntregaEmail(membros), "Kakashi");

        jiraya.start();
        kakashi.start();

        while(true){
            String email = JOptionPane.showInputDialog("Entre com seu email");
            if (email == null || email.isEmpty()){
                membros.fechar();
                break;
            }
            membros.adicionarEmail(email);
        }
    }
}
