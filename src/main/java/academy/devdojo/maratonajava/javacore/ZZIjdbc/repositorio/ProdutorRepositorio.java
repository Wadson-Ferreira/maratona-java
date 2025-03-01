package academy.devdojo.maratonajava.javacore.ZZIjdbc.repositorio;

import academy.devdojo.maratonajava.javacore.ZZIjdbc.conn.ConnectionFactory;
import academy.devdojo.maratonajava.javacore.ZZIjdbc.dominio.Produtor;
import lombok.extern.log4j.Log4j2;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Log4j2
public class ProdutorRepositorio {
    public static void salvar(Produtor produtor) {
        String sql = "INSERT INTO `anime_loja`.`produtor` (`nome`) VALUES ('%s');".formatted(produtor.getNome());
        try (Connection conn = ConnectionFactory.getConnection(); Statement stmt = conn.createStatement()) {
            int linhasAfetadas = stmt.executeUpdate(sql);
            log.info("Inserindo produtor '{}' no banco de dados, linhas afetadas '{}'", produtor.getNome(), linhasAfetadas);
        } catch (SQLException e) {
            log.error("Erro ao inserir produtor'{}'", produtor.getNome(), e);
        }
    }

    public static void deletar(int id) {
        String sql = "DELETE FROM `anime_loja`.`produtor` WHERE (`idProdutor` = '%d');".formatted(id);
        try (Connection conn = ConnectionFactory.getConnection(); Statement stmt = conn.createStatement()) {
            int linhasAfetadas = stmt.executeUpdate(sql);
            log.info("Deletando produtor '{}' do banco de dados, linhas afetadas '{}' ", id, linhasAfetadas);
        } catch (SQLException e) {
            log.error("Erro ao deletar produtor '{}'", id, e);
        }
    }

    public static void atualizar(Produtor produtor) {
        String sql = "UPDATE `anime_loja`.`produtor` SET `nome` = '%s' WHERE (`idProdutor` = '%d');".formatted(produtor.getNome(), produtor.getId());
        try (Connection conn = ConnectionFactory.getConnection(); Statement stmt = conn.createStatement()) {
            int linhasAfetadas = stmt.executeUpdate(sql);
            log.info("atualizando produtor id: '{}', linhas afetadas '{}' ", produtor.getId(), linhasAfetadas);
        } catch (SQLException e) {
            log.error("Erro ao atualizar produtor '{}'", produtor.getId(), e);
        }
    }

    public static List<Produtor> procurarTodos() {
        log.info("Buscando todos os Produtores");
        return procurarPorNome("");
    }

    public static List<Produtor> procurarPorNome(String nome) {
        log.info("Buscando Produtores pelo nome: '{}'", nome);
        String sql = "SELECT * FROM anime_loja.produtor where nome like '%s';".formatted("%" + nome + "%");
        List<Produtor> produtores = new ArrayList<>();
        try (Connection conn = ConnectionFactory.getConnection(); Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Produtor produtor = Produtor
                        .builder()
                        .id(rs.getInt("idProdutor"))
                        .nome(rs.getString("nome"))
                        .build();
                produtores.add(produtor);
            }

        } catch (SQLException e) {
            log.error("Erro ao buscar produtor pelo nome: '{}' ", nome, e);
        }
        return produtores;
    }

    public static void metadaDadosProdutor()  {
        log.info("Mostrando metadados dados do Produtor");
        String sql = "SELECT * FROM anime_loja.produtor";
        try (Connection conn = ConnectionFactory.getConnection(); Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            ResultSetMetaData rsMetaData = rs.getMetaData();
            rs.next();
            int columnCount = rs.getMetaData().getColumnCount();
            log.info("Contagens de Colunas '{}'", columnCount);
            for (int i = 1; i <= columnCount; i++) {
                log.info("Nome da tabela: '{}'", rsMetaData.getTableName(i));
                log.info("Nome da coluna: '{}'", rsMetaData.getColumnName(i));
                log.info("Tamanho da coluna: '{}'", rsMetaData.getColumnDisplaySize(i));
                log.info("Tipo de coluna: '{}'", rsMetaData.getColumnTypeName(i));
            }

        } catch (SQLException e) {
            log.error("Erro ao buscar metadados", e);
        }
    }
}


