package academy.devdojo.maratonajava.javacore.ZZKJunit.servico;

import academy.devdojo.maratonajava.javacore.ZZKJunit.dominio.Pessoa;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PessoaServicoTest {

    private Pessoa adulto;
    private Pessoa naoAdulto;
    private PessoaServico pessoaServico;

    @BeforeEach
    public void setUp(){
        adulto = new Pessoa(18);
        naoAdulto = new Pessoa(15);
        pessoaServico = new PessoaServico();
    }

    @Test
    @DisplayName("Uma pessoa não deve ser considerada adulta quando a idade for inferior a 18 anos")
    void eAdulto_ReturnFalse_QuandoAIdadeEMenorQue18() {
        assertFalse(pessoaServico.eAdulto(naoAdulto));
    }

    @Test
    @DisplayName("Uma pessoa deve ser considerada adulta quando a idade for superior ou igual a 18 anos")
    void eAdulto_ReturnTrue_QuandoAIdadeEMaiorOuIgualQue18() {
        assertTrue(pessoaServico.eAdulto(adulto));
    }

    @Test
    @DisplayName("Deve lançar NullPointerException com mensagem quando a pessoa for nula")
    void eAdulto_ThrowException_QuandoAPessoaNull() {
        assertThrows(IllegalArgumentException.class,
                () -> pessoaServico.eAdulto(null), "Pessoa não pode ser null");
    }

    @Test
    @DisplayName("Deve retornar uma lista com apenas adultos")
    void filtroRemovendoNaoAdult_ReturnListaComApenasAdultos_QuandoAListaPessoaComAdultosEPassada() {
        Pessoa pessoa1 = new Pessoa(17);
        Pessoa pessoa2 = new Pessoa(18);
        Pessoa pessoa3 = new Pessoa(21);
        List<Pessoa> listPessoas = List.of(pessoa1, pessoa2, pessoa3);
        assertEquals(2, pessoaServico.filtroRemovendoNaoAdult(listPessoas).size());
    }
}