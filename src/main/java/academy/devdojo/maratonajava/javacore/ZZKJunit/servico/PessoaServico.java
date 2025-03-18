package academy.devdojo.maratonajava.javacore.ZZKJunit.servico;

import academy.devdojo.maratonajava.javacore.ZZKJunit.dominio.Pessoa;

import java.util.Objects;

public class PessoaServico {
    public boolean eAdulto (Pessoa pessoa){
        Objects.requireNonNull(pessoa,"Pessoa não pode ser null");
        return pessoa.getIdade() >= 18;
    }
}
