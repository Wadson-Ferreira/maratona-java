package academy.devdojo.maratonajava.javacore.ZZIjdbc.service;

import academy.devdojo.maratonajava.javacore.ZZIjdbc.dominio.Produtor;
import academy.devdojo.maratonajava.javacore.ZZIjdbc.repositorio.RepositorioProdutorRowSet;

import java.util.List;

public class ProdutorServicoRowSet {

    public static List<Produtor> procurarPorNomeJdbcRowSet(String nome) {
        return RepositorioProdutorRowSet.procurarPorNomeJdbcRowSet(nome);
    }

    public static void atualizarJdbcRowSet(Produtor produtor) {
        RepositorioProdutorRowSet.atualizarJdbcRowSet(produtor);
    }
}
