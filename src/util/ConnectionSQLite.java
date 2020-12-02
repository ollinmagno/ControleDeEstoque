package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionSQLite {

    private Connection connection;
    
    public boolean connect() {

        try {
            String url = "jdbc:sqlite:db/dbestoque.db";

            this.connection = DriverManager.getConnection(url);
            System.out.println("Conectado");

        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return false;
        }

        return true;
    }

    public boolean disconnect() {

        try {
            if (this.connection.isClosed() == false) {
                this.connection.close();
            }
            System.out.println("desconectado");
        } catch (SQLException e) {

            System.err.println(e.getMessage());
            return false;
        }
        return true;
    }
    
    public Statement createStatement() {
        try {
            return this.connection.createStatement();
        } catch (SQLException e) {
            return null;
        }
    }
    
    public PreparedStatement createPreparedStatement(String pSQL, int RETURN_GENERATED_KEYS) {
        try {
            System.out.println("Executando");
            return connection.prepareStatement(pSQL, RETURN_GENERATED_KEYS);
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println(e.getMessage());
            return null;
        }
    }

    public Connection getConexao() {
        return this.connection;
    }

    public PreparedStatement createPreparedStatement(String sql) {
        try {
            return this.connection.prepareStatement(sql);
        } catch (SQLException e) {
            return null;
        }
    }

}