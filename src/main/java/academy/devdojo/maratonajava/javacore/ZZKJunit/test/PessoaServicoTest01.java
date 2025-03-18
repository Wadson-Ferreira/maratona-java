package academy.devdojo.maratonajava.javacore.ZZKJunit.test;

import academy.devdojo.maratonajava.javacore.ZZKJunit.dominio.Pessoa;
import academy.devdojo.maratonajava.javacore.ZZKJunit.servico.PessoaServico;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class PessoaServicoTest01 {
    public static void main(String[] args) {
        Pessoa pessoa = new Pessoa(15);
        PessoaServico pessoaServico = new PessoaServico();
        log.info("É adulto? '{}' ", pessoaServico.eAdulto(pessoa));
    }
}
