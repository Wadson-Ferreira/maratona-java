package academy.devdojo.maratonajava.javacore.ZZJCrud.repositorio;

import academy.devdojo.maratonajava.javacore.ZZJCrud.conn.ConnectionFactory;
import academy.devdojo.maratonajava.javacore.ZZJCrud.dominio.Produtor;
import lombok.extern.log4j.Log4j2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Log4j2
public class RepositorioProdutor {
    public static List<Produtor> procurarPorNome(String nome) {
        log.info("Buscando Produtores pelo nome: '{}'", nome);
        List<Produtor> produtores = new ArrayList<>();
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = createPreparedStatementProcurarPorNome(conn, nome);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                produtores.add(getProdutor(rs));
            }

        } catch (SQLException e) {
            log.error("Erro ao buscar produtor pelo nome: '{}' ", nome, e);
        }
        return produtores;
    }

    private static PreparedStatement createPreparedStatementProcurarPorNome(Connection conn, String nome) throws SQLException {
        String sql = "SELECT * FROM anime_loja.produtor where nome like ?;";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, String.format("%%%s%%", nome));
        return ps;
    }

    public static void deletar(int id) {
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = createPreparedStatementDeletar(conn, id)) {
            ps.execute();
            log.info("Deletando produtor '{}' do banco de dados", id);
        } catch (SQLException e) {
            log.error("Erro ao deletar produtor '{}'", id, e);
        }
    }

    private static PreparedStatement createPreparedStatementDeletar(Connection conn, Integer id) throws SQLException {
        String sql = "DELETE FROM `anime_loja`.`produtor` WHERE (`idProdutor` = ?);";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        return ps;
    }


    private static Produtor getProdutor(ResultSet rs) throws SQLException {
        return Produtor.builder().idProdutor(rs.getInt("idProdutor")).nome(rs.getString("nome")).build();
    }

}
