package academy.devdojo.maratonajava.javacore.ZZKJunit.servico;

import academy.devdojo.maratonajava.javacore.ZZKJunit.dominio.Pessoa;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PessoaServicoTest {

    @Test
    @DisplayName("Uma pessoa não deve ser considerada adulta quando a idade for inferior a 18 anos")
    void eAdulto_ReturnFalse_QuandoAIdadeEMenorQue18() {
        Pessoa pessoa = new Pessoa(15);
        PessoaServico pessoaServico = new PessoaServico();
        assertFalse(pessoaServico.eAdulto(pessoa));
    }
}