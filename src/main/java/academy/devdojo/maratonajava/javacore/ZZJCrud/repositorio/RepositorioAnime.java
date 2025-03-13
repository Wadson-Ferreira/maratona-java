package academy.devdojo.maratonajava.javacore.ZZJCrud.repositorio;

import academy.devdojo.maratonajava.javacore.ZZJCrud.conn.ConnectionFactory;
import academy.devdojo.maratonajava.javacore.ZZJCrud.dominio.Anime;
import academy.devdojo.maratonajava.javacore.ZZJCrud.dominio.Produtor;
import lombok.extern.log4j.Log4j2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Log4j2
public class RepositorioAnime {
    public static List<Anime> procurarPorNome(String nome) {
        log.info("Buscando Anime pelo nome: '{}'", nome);
        List<Anime> animes = new ArrayList<>();
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = createPreparedStatementProcurarPorNome(conn, nome);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                animes.add(getAnime(rs));
            }

        } catch (SQLException e) {
            log.error("Erro ao buscar Anime pelo nome: '{}' ", nome, e);
        }
        return animes;
    }

    private static PreparedStatement createPreparedStatementProcurarPorNome(Connection conn, String nome) throws SQLException {
        String sql = """
              SELECT a.idAnime, a.nomeAnime, a.episodios, a.produtor_id, p.nome as 'nomeProdutor' 
              FROM anime_loja.anime a inner join anime_loja.produtor p on a.produtor_id = p.idProdutor 
              where a.nomeAnime like ?;
                """;
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, String.format("%%%s%%", nome));
        return ps;
    }

    public static Optional<Anime> procurarPorId(Integer id) {
        log.info("Buscando Animes pelo id: '{}'", id);
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = createPreparedStatementProcurarPorId(conn, id);
             ResultSet rs = ps.executeQuery()) {
            if (!rs.next()) return Optional.empty();
            return Optional.of(getAnime(rs));
        } catch (SQLException e) {
            log.error("Erro ao buscar Anime pelo Id: '{}' ", id, e);
        }
        return Optional.empty();
    }

    private static PreparedStatement createPreparedStatementProcurarPorId(Connection conn, Integer id) throws SQLException {
        String sql = """
                SELECT a.idAnime, a.nomeAnime, a.episodios, a.produtor_id, p.nome as 'nomeProdutor' FROM anime_loja.anime a\s
                inner join anime_loja.produtor p on a.produtor_id = p.idProdutor
                where a.idAnime = ?;
                """;
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        return ps;
    }

    public static void deletar(int id) {
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = createPreparedStatementDeletar(conn, id)) {
            ps.execute();
            log.info("Deletando Anime '{}' do banco de dados", id);
        } catch (SQLException e) {
            log.error("Erro ao deletar Anime '{}'", id, e);
        }
    }

    private static PreparedStatement createPreparedStatementDeletar(Connection conn, Integer id) throws SQLException {
        String sql = "DELETE FROM `anime_loja`.`anime` WHERE (`idAnime` = ?);";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        return ps;
    }

    public static void salvar(Anime anime) {
        log.info("Salvando Anime '{}'", anime.getNomeAnime());
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = createPreparedStatementSalvar(conn, anime)) {
            ps.execute();
        } catch (SQLException e) {
            log.error("Erro ao salvar Anime '{}'", anime, e);
        }
    }

    private static PreparedStatement createPreparedStatementSalvar(Connection conn, Anime anime) throws SQLException {
        String sql = "INSERT INTO `anime_loja`.`anime` (`nomeAnime`, `episodios`, `produtor_id`) VALUES (?, ?, ?);";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, anime.getNomeAnime());
        ps.setInt(2, anime.getEpisodios());
        ps.setInt(3, anime.getProdutor().getIdProdutor());
        return ps;
    }

    public static void atualizar (Anime anime) {
        log.info("Atualizando Anime '{}'", anime);
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = createPreparedStatementAtualizar(conn,anime)) {
            ps.execute();
        } catch (SQLException e) {
            log.error("Erro ao atualizar Anime '{}'", anime.getIdAnime(), e);
        }
    }

    private static PreparedStatement createPreparedStatementAtualizar(Connection conn, Anime anime) throws SQLException {
        String sql = "UPDATE `anime_loja`.`anime` SET `nomeAnime` = ?, episodios = ?  WHERE (`idAnime` = ?);";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, anime.getNomeAnime());
        ps.setInt(2, anime.getEpisodios());
        ps.setInt(3, anime.getIdAnime());
        return ps;
    }

    private static Anime getAnime(ResultSet rs) throws SQLException {
        Produtor produtor = Produtor.builder()
                .idProdutor(rs.getInt("produtor_id"))
                .nome(rs.getString("nomeProdutor"))
                .build();
        return Anime.builder()
                .idAnime(rs.getInt("idAnime"))
                .nomeAnime(rs.getString("nomeAnime"))
                .episodios(rs.getInt("episodios"))
                .produtor(produtor)
                .build();
    }

}
