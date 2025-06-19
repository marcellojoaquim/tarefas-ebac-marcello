package br.com.joaquim.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private static Connection connection;
    private ConnectionFactory(Connection connection) {}

    public static Connection getConnection() throws SQLException {
        if(connection == null) {
            connection = initConnection();
        } else if(connection.isClosed()){
            connection = initConnection();
        }
        return connection;
    }

    private static Connection initConnection() {
        try {
            return DriverManager.getConnection(
                    "jdbc:postgresql://172.17.0.1:5433/projeto_03", "postgres", "root");
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
