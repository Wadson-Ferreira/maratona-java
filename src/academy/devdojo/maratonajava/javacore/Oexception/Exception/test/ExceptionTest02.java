package academy.devdojo.maratonajava.javacore.Oexception.Exception.test;

import java.io.File;
import java.io.IOException;
import java.rmi.RemoteException;

public class ExceptionTest02 {
    public static void main(String[] args) throws IOException {
        criarNovoArquivo();

    }

    private static void criarNovoArquivo() throws IOException {
        File file = new File("arquivo\\teste.txt");
        try{
            boolean isCriado = file.createNewFile();
            System.out.println("Arquivo criado " +isCriado);
        }catch (IOException e){
            e.printStackTrace();
            throw new RemoteException("Problema na hora de criar o arquivo ");
        }

    }
}
