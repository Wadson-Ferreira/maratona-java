package academy.devdojo.maratonajava.javacore.BIntrudoucaoMetodos.test;

import academy.devdojo.maratonajava.javacore.BIntrudoucaoMetodos.dominio.Pessoa;

public class PessoaTest01 {
    public static void main(String[] args) {
        Pessoa pessoa = new Pessoa();
//        pessoa.nome = "Jiraya";
//        pessoa.idade = 50;

        pessoa.setNome("Jiraya");
        pessoa.setIdade(-5);
        pessoa.imprime();
        System.out.println(pessoa.getNome());
        System.out.println(pessoa.getIdade());

    }

}
