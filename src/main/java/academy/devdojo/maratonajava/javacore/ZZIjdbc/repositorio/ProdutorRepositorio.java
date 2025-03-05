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

    public static void metaDadosDoProdutor()  {
        log.info("Mostrando metadados dados do Produtor");
        String sql = "SELECT * FROM anime_loja.produtor";
        try (Connection conn = ConnectionFactory.getConnection(); Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            ResultSetMetaData rsMetaData = rs.getMetaData();
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

    public static void driverMetaDadosDoProdutor()  {
        log.info("Mostrando metadados dados do Produtor");
        try (Connection conn = ConnectionFactory.getConnection()) {
            DatabaseMetaData dbMetaData = conn.getMetaData();
            if(dbMetaData.supportsResultSetType(ResultSet.TYPE_FORWARD_ONLY)) {
                log.info("Suporta TYPE_FORWARD_ONLY");
                if(dbMetaData.supportsResultSetConcurrency(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE)){
                    log.info("E Suporta CONCUR_UPDATABLE");
                }
            }

            if(dbMetaData.supportsResultSetType(ResultSet.TYPE_SCROLL_INSENSITIVE)) {
                log.info("Suporta TYPE_SCROLL_INSENSITIVE");
                if(dbMetaData.supportsResultSetConcurrency(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE)){
                    log.info("E Suporta CONCUR_UPDATABLE");
                }
            }

            if(dbMetaData.supportsResultSetType(ResultSet.TYPE_SCROLL_SENSITIVE)) {
                log.info("Suporta TYPE_SCROLL_SENSITIVE");
                if(dbMetaData.supportsResultSetConcurrency(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE)){
                    log.info("E Suporta CONCUR_UPDATABLE");
                }
            }
        } catch (SQLException e) {
            log.error("Erro ao buscar metadados", e);
        }
    }

    public static void mostrarTypeScrollTrabalhando () {
        String sql = "SELECT * FROM anime_loja.produtor;";
        try (Connection conn = ConnectionFactory.getConnection();
             Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
             ResultSet rs = stmt.executeQuery(sql)){

            log.info("Ultima linha? '{}'", rs.last());
            log.info("Número da linha: '{}'", rs.getRow());
            log.info(Produtor.builder().id(rs.getInt("idProdutor")).nome(rs.getString("nome")).build());

            log.info("Primeira linha? '{}'", rs.first());
            log.info("Número da linha: '{}'", rs.getRow());
            log.info(Produtor.builder().id(rs.getInt("idProdutor")).nome(rs.getString("nome")).build());

            log.info("Linha Absolute? '{}'", rs.absolute(2));
            log.info("Número da linha: '{}'", rs.getRow());
            log.info(Produtor.builder().id(rs.getInt("idProdutor")).nome(rs.getString("nome")).build());

            log.info("Linha Relative '{}'", rs.relative(-1));
            log.info("Número da linha: '{}'", rs.getRow());
            log.info(Produtor.builder().id(rs.getInt("idProdutor")).nome(rs.getString("nome")).build());

            log.info("E a Última linha? '{}'", rs.isLast());
            log.info("Número da linha: '{}'", rs.getRow());

            log.info("E a Primeira linha? '{}'", rs.isFirst());
            log.info("Número da linha: '{}'", rs.getRow());

        } catch (SQLException e) {
            log.error("Erro ao buscar produtores", e);
        }

    }

    public static List<Produtor> procurarPorNomeEAtualizarToUpperCase (String nome) {
        log.info("Buscando Produtores pelo nome: '{}'", nome);
        String sql = "SELECT * FROM anime_loja.produtor where nome like '%s';".formatted("%" + nome + "%");
        List<Produtor> produtores = new ArrayList<>();
        try (Connection conn = ConnectionFactory.getConnection();
             Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                rs.updateString("nome", rs.getString("nome").toUpperCase());
                rs.updateRow();
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
}


