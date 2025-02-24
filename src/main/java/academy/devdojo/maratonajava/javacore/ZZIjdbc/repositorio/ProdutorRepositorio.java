package academy.devdojo.maratonajava.javacore.ZZIjdbc.repositorio;

import academy.devdojo.maratonajava.javacore.ZZIjdbc.conn.ConnectionFactory;
import academy.devdojo.maratonajava.javacore.ZZIjdbc.dominio.Produtor;
import lombok.extern.log4j.Log4j2;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

@Log4j2
public class ProdutorRepositorio {
    public static void salvar(Produtor produtor) {
        String sql = "INSERT INTO `anime_loja`.`produtor` (`nome`) VALUES ('%s');".formatted(produtor.getNome());
        try (Connection conn = ConnectionFactory.getConnection();
             Statement stmt = conn.createStatement()) {
            int linhasAfetadas = stmt.executeUpdate(sql);
            log.info("Inserindo produtor '{}' no banco de dados, linhas afetadas '{}'", produtor.getNome(), linhasAfetadas);
        } catch (SQLException e) {
            log.error("Erro ao inserir produtor'{}'", produtor.getNome(), e);
        }
    }

    public static void deletar(int id) {
        String sql = "DELETE FROM `anime_loja`.`produtor` WHERE (`idProdutor` = '%d');".formatted(id);
        try(Connection conn = ConnectionFactory.getConnection();
        Statement stmt = conn.createStatement()){
            int linhasAfetadas = stmt.executeUpdate(sql);
            log.info("Deletando produtor '{}' do banco de dados, linhas afetadas '{}' ", id, linhasAfetadas);
        } catch (SQLException e) {
            log.error("Erro ao deletar produtor '{}'", id, e);
        }
    }

    public static void atualizar (Produtor produtor) {
        String sql = "UPDATE `anime_loja`.`produtor` SET `nome` = '%s' WHERE (`idProdutor` = '%d');"
                .formatted(produtor.getNome(), produtor.getId());
        try(Connection conn = ConnectionFactory.getConnection();
            Statement stmt = conn.createStatement()){
            int linhasAfetadas = stmt.executeUpdate(sql);
            log.info("atualizando produtor id: '{}', linhas afetadas '{}' ", produtor.getId(), linhasAfetadas);
        } catch (SQLException e) {
            log.error("Erro ao atualizar produtor '{}'", produtor.getId(), e);
        }
    }
}


