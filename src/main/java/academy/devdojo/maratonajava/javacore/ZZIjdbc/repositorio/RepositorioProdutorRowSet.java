package academy.devdojo.maratonajava.javacore.ZZIjdbc.repositorio;

import academy.devdojo.maratonajava.javacore.ZZIjdbc.conn.ConnectionFactory;
import academy.devdojo.maratonajava.javacore.ZZIjdbc.dominio.Produtor;
import academy.devdojo.maratonajava.javacore.ZZIjdbc.linister.CustomRowSetListener;
import lombok.extern.log4j.Log4j2;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.JdbcRowSet;
import java.sql.Connection;
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
            jrs.addRowSetListener(new CustomRowSetListener());
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

//    public static void atualizarJdbcRowSet(Produtor produtor) {
//
//        log.info("Atualizando Produtor: '{}'", produtor.getNome());
//
//        String sql = "UPDATE `anime_loja`.`produtor` SET `nome` = ?  WHERE (`idProdutor` = ?);";
//        try (JdbcRowSet jrs = ConnectionFactory.getJdbcRowSet()) {
//            jrs.setCommand(sql);
//            jrs.setString(1, produtor.getNome());
//            jrs.setInt(2, produtor.getId());
//            jrs.execute();
//        } catch (SQLException e) {
//            log.error("Erro ao atualizar produtor: '{}' ", produtor.getNome(), e);
//        }
//    }

    public static void atualizarJdbcRowSet(Produtor produtor) {

        logAtualizando(produtor);

        String sql = "SELECT * FROM anime_loja.produtor WHERE (`idProdutor` = ?);";
        try (JdbcRowSet jrs = ConnectionFactory.getJdbcRowSet()) {
            jrs.addRowSetListener(new CustomRowSetListener());
            jrs.setCommand(sql);
            jrs.setInt(1, produtor.getId());
            jrs.execute();
            if(!jrs.next()) return;
            jrs.updateString("nome", produtor.getNome());
            jrs.updateRow();
        } catch (SQLException e) {
            log.error("Erro ao atualizar produtor: '{}' ", produtor.getNome(), e);
        }
    }

    public static void atualizarCachedRowSet(Produtor produtor) {

        logAtualizando(produtor);

        String sql = "SELECT * FROM produtor WHERE (`idProdutor` = ?);";
        try (CachedRowSet crs = ConnectionFactory.getCachedRowSet();
             Connection connection = ConnectionFactory.getConnection()) {
            connection.setAutoCommit(false);
            crs.setCommand(sql);
            crs.setInt(1, produtor.getId());
            crs.execute(connection);
            if(!crs.next()) return;
            crs.updateString("nome", produtor.getNome());
            crs.updateRow();
            crs.acceptChanges();
        } catch (SQLException e) {
            log.error("Erro ao atualizar produtor: '{}' ", produtor.getNome(), e);
        }
    }

    private static void logAtualizando(Produtor produtor) {
        log.info("Atualizando nome do Produtor id: '{}' para: '{}'", produtor.getId(), produtor.getNome());
    }

    private static Produtor getProdutor(JdbcRowSet jrs) throws SQLException {
        return Produtor.builder().id(jrs.getInt("idProdutor")).nome(jrs.getString("nome")).build();
    }

}
