package academy.devdojo.maratonajava.javacore.ZZIjdbc.test;

import academy.devdojo.maratonajava.javacore.ZZIjdbc.dominio.Produtor;
import academy.devdojo.maratonajava.javacore.ZZIjdbc.service.ProdutorServico;
import lombok.extern.log4j.Log4j2;

import java.util.List;

@Log4j2
public class ConnectionFactoryTest01 {
    public static void main(String[] args) {
//        Produtor produtor = Produtor.builder().nome("Studio Deen").build();
//        Produtor atualizarProdutor = Produtor.builder().id(1).nome("madhouse").build();
//        ProdutorServico.salvar(produtor);
//        ProdutorServico.deletar(9);
//        ProdutorServico.atualizar(atualizarProdutor);
//        List<Produtor> produtores = ProdutorServico.procurarTodos();
//        List<Produtor> produtores = ProdutorServico.procurarPorNome("MADHOUSE");
//        log.info("Produtor encontrado '{}'", produtores);

//        ProdutorServico.metadaDadosProdutor();
//        ProdutorServico.driverMetaDadosDoProdutor();
//        List<Produtor> prodotures = ProdutorServico.procurarPorNomeEInserirNaoEncontrado("A-1 pictures");

//        List<Produtor> produtores = ProdutorServico.procurarPorNomePreparedStatement("Bo");
//        log.info("Produtor encontrado pelo nome: '{}'", produtores);

//        ProdutorServico.atualizarPreparedStatement(atualizarProdutor);

        List<Produtor> produtores = ProdutorServico.procurarPorNomeCallableStatement("NHK");
        log.info("Produtor encontrado pelo nome: '{}'", produtores);

    }
}
