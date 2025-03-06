package academy.devdojo.maratonajava.javacore.ZZIjdbc.repositorio;

import academy.devdojo.maratonajava.javacore.ZZIjdbc.conn.ConnectionFactory;
import academy.devdojo.maratonajava.javacore.ZZIjdbc.dominio.Produtor;
import lombok.extern.log4j.Log4j2;

import javax.sql.rowset.JdbcRowSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Log4j2
public class RepositorioProdutorRowSet {
    public static List<Produtor> procurarPorNomeJdbcRowSet(String nome) {

        log.info("Buscando Produtores pelo nome: '{}'", nome);

        String sql = "SELECT * FROM anime_loja.produtor where nome like ?;";
        List<Produtor> produtores = new ArrayList<>();
        try (JdbcRowSet jrs = ConnectionFactory.getJdbcRowSet()) {
            jrs.setCommand(sql);
            jrs.setString(1, String.format("%%%s%%", nome));
            jrs.execute();
            while (jrs.next()) {
                produtores.add(getProdutor(jrs));
            }
        } catch (SQLException e) {
            log.error("Erro ao buscar produtor pelo nome: '{}' ", nome, e);
        }
        return produtores;
    }

    private static Produtor getProdutor(JdbcRowSet jrs) throws SQLException {
        return Produtor.builder().id(jrs.getInt("idProdutor")).nome(jrs.getString("nome")).build();
    }

}
