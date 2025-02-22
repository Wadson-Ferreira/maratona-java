package academy.devdojo.maratonajava.javacore.ZZIjdbc.repositorio;

import academy.devdojo.maratonajava.javacore.ZZIjdbc.conn.ConnectionFactory;
import academy.devdojo.maratonajava.javacore.ZZIjdbc.dominio.Produtor;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class ProdutorRepositorio {
    public static void salvar(Produtor produtor) {
        String sql = "INSERT INTO `anime_loja`.`produtor` (`nome`) VALUES ('%s');".formatted(produtor.getNome());
        try(Connection conn = ConnectionFactory.getConnection();
            Statement stmt = conn.createStatement()){
            int executed = stmt.executeUpdate(sql);
            System.out.println("Executed " + executed + " rows");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
