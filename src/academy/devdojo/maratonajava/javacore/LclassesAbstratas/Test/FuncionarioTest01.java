package academy.devdojo.maratonajava.javacore.LclassesAbstratas.Test;

import academy.devdojo.maratonajava.javacore.LclassesAbstratas.dominio.Desenvolvedor;
import academy.devdojo.maratonajava.javacore.LclassesAbstratas.dominio.Funcionario;
import academy.devdojo.maratonajava.javacore.LclassesAbstratas.dominio.Gerente;

public class FuncionarioTest01 {
    public static void main(String[] args) {
        Gerente gerente = new Gerente("Nami", 5000);
        System.out.println(gerente);

        Desenvolvedor desenvolvedor = new Desenvolvedor("Touya", 12000);
        System.out.println(desenvolvedor);
    }
}