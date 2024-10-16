package academy.devdojo.maratonajava.javacore.Oexception.Exception.dominio;

import java.io.FileNotFoundException;

public class Funcionario extends Pessoa{
    public void salvar() throws LoginInvalidoException, FileNotFoundException {
        System.out.println("Salvando funcionário");
    }
}
