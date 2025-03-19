package academy.devdojo.maratonajava.javacore.ZZKJunit.servico;

import academy.devdojo.maratonajava.javacore.ZZKJunit.dominio.Pessoa;

import java.util.List;
import java.util.stream.Collectors;

public class PessoaServico {
    public boolean eAdulto (Pessoa pessoa){
     //   Objects.requireNonNull(pessoa,"Pessoa não pode ser null");
        if (pessoa == null)throw new IllegalArgumentException();
        return pessoa.getIdade() >= 18;
    }

    public List<Pessoa> filtroRemovendoNaoAdult (List<Pessoa> pessoaList){
        return pessoaList.stream().filter(this::eAdulto).collect(Collectors.toList());
    }
}
