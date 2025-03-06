package academy.devdojo.maratonajava.javacore.ZZIjdbc.test;

import academy.devdojo.maratonajava.javacore.ZZIjdbc.dominio.Produtor;
import academy.devdojo.maratonajava.javacore.ZZIjdbc.service.ProdutorServicoRowSet;
import lombok.extern.log4j.Log4j2;

import java.util.List;

@Log4j2
public class ConnectionFactoryTest02 {
    public static void main(String[] args) {
        Produtor atualizarProdutor = Produtor.builder().id(1).nome("MADHOUSE").build();
        ProdutorServicoRowSet.atualizarJdbcRowSet(atualizarProdutor);

        log.info("-------------------");

        List<Produtor> produtor = ProdutorServicoRowSet.procurarPorNomeJdbcRowSet("");
        log.info(produtor);
    }
}
