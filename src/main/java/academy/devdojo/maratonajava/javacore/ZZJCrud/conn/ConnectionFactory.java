package academy.devdojo.maratonajava.javacore.ZZJCrud.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    //java.sql = Connection, Statement, ResultSet, DriverManager

    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/anime_loja";
        String username = "root";
        String password = "root";
        return DriverManager.getConnection(url, username, password);
    }
}
