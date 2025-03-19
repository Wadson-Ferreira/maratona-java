package academy.devdojo.maratonajava.javacore.ZZKJunit.dominio;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DesenvolvedorTest {
    @Test

    public void instanceOf_ExecutesClasseFilhoMethod_QaundoObjetoETipoFilho(){
        Funcionario funcionarioDesenvolvedor = new Desenvolvedor("1", "Java");
        if (funcionarioDesenvolvedor instanceof Desenvolvedor){
            Desenvolvedor desenvolvedor = (Desenvolvedor) funcionarioDesenvolvedor;
            assertEquals("Java", desenvolvedor.getMainLinguagem());
        }

        if (funcionarioDesenvolvedor instanceof Desenvolvedor desenvolvedor){
            assertEquals("Java", desenvolvedor.getMainLinguagem());
        }
    }

}