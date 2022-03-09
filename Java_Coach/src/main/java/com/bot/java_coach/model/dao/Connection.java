package com.bot.java_coach.model.dao;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connection {

    private java.sql.Connection jdbcConnection;
    private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;

    public Connection(String jdbcURL, String jdbcUsername, String jdbcPassword) {
        this.jdbcURL = jdbcURL;
        this.jdbcUsername = jdbcUsername;
        this.jdbcPassword = jdbcPassword;
    }

    public void conectar() throws SQLException {
        if (jdbcConnection == null || jdbcConnection.isClosed()) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new SQLException(e);
            }
            jdbcConnection = DriverManager.getConnection(
                    jdbcURL, jdbcUsername, jdbcPassword);
        }
    }

    public void desconectar() throws SQLException{
        if (jdbcConnection!= null && ! jdbcConnection.isClosed()){
            jdbcConnection.close();
        }
    }


}
