package academy.devdojo.maratonajava.javacore.Oexception.Exception.test;

import academy.devdojo.maratonajava.javacore.Oexception.Exception.dominio.Funcionario;
import academy.devdojo.maratonajava.javacore.Oexception.Exception.dominio.LoginInvalidoException;
import academy.devdojo.maratonajava.javacore.Oexception.Exception.dominio.Pessoa;

import java.io.FileNotFoundException;

public class SobrescritaComExceptiontTest01 {
    public static void main(String[] args) {
        Pessoa pessoa = new Pessoa();
        Funcionario funcionario = new Funcionario();

        try {
            funcionario.salvar();
        } catch (LoginInvalidoException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
