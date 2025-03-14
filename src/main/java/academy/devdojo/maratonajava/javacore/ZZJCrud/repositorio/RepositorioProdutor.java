package academy.devdojo.maratonajava.javacore.ZZJCrud.repositorio;

import academy.devdojo.maratonajava.javacore.ZZJCrud.conn.ConnectionFactory;
import academy.devdojo.maratonajava.javacore.ZZJCrud.dominio.Produtor;
import lombok.extern.log4j.Log4j2;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public static Optional<Produtor> procurarPorId(Integer id) {
        log.info("Buscando Produtores pelo id: '{}'", id);
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = createPreparedStatementProcurarPorId(conn, id);
             ResultSet rs = ps.executeQuery()) {
            if (!rs.next()) return Optional.empty();
            return Optional.of(getProdutor(rs));
        } catch (SQLException e) {
            log.error("Erro ao buscar produtor pelo Id: '{}' ", id, e);
        }
        return Optional.empty();
    }

    private static PreparedStatement createPreparedStatementProcurarPorId(Connection conn, Integer id) throws SQLException {
        String sql = "SELECT * FROM anime_loja.produtor where idProdutor = ?;";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
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

    public static void salvar(Produtor produtor) {
        log.info("Salvando Produtor '{}'", produtor.getNome());
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = createPreparedStatementSalvar(conn, produtor)) {
            ps.execute();
        } catch (SQLException e) {
            log.error("Erro ao salvar produtor '{}'", produtor, e);
        }
    }

    private static PreparedStatement createPreparedStatementSalvar(Connection conn, Produtor produtor) throws SQLException {
        String sql = "INSERT INTO `anime_loja`.`produtor` (`nome`) VALUES (?);";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, produtor.getNome());
        return ps;
    }

    public static void atualizar (Produtor produtor) {
        log.info("Atualizando Produtor '{}'", produtor);
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = createPreparedStatementAtualizar(conn,produtor)) {
            ps.execute();
        } catch (SQLException e) {
            log.error("Erro ao atualizar produtor '{}'", produtor.getIdProdutor(), e);
        }
    }

    private static PreparedStatement createPreparedStatementAtualizar(Connection conn, Produtor produtor) throws SQLException {
        String sql = "UPDATE `anime_loja`.`produtor` SET `nome` = ?  WHERE (`idProdutor` = ?);";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, produtor.getNome());
        ps.setInt(2, produtor.getIdProdutor());
        return ps;
    }

    private static Produtor getProdutor(ResultSet rs) throws SQLException {
        return Produtor.builder().idProdutor(rs.getInt("idProdutor")).nome(rs.getString("nome")).build();
    }

}
