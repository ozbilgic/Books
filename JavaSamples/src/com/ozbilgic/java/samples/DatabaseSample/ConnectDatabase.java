package com.ozbilgic.java.samples.DatabaseSample;

import java.sql.*;

/**
 * @author Vision2
 * @version 0.0.0.1
 * @since 20.12.2014
 */
public class ConnectDatabase implements DataSource {
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;
    private String dbPath;
    private final String URL = "jdbc:sqlite:";
    private boolean connectionStatus;

    public ConnectDatabase(String dbPath) {
        this.dbPath = dbPath;
    }

    @Override
    public void connect() {
        try {
            Class.forName("org.sqlite.JDBC").newInstance();
            connection = DriverManager.getConnection(URL+dbPath);
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM ANATABLO");
            connectionStatus = true;
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void disconnect() {
        try {
            connection.close();
            connectionStatus = false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean isConnectionStatus() {
        return connectionStatus;
    }

    @Override
    public void setData(String isim, String tel) {
        try {
            if (!isConnectionStatus()) connect();
            statement.executeUpdate("INSERT INTO ANATABLO (ISIM, TEL) VALUES ('"+isim+"', '"+tel+"')");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (isConnectionStatus()) disconnect();
        }
    }

    @Override
    public void getAllData() {
        try {
            if (!isConnectionStatus()) connect();
            while (resultSet.next()) {
                System.out.println(resultSet.getInt("IDX")+" "+resultSet.getString("ISIM")+" "+resultSet.getString("TEL"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (isConnectionStatus()) disconnect();
        }
    }
}
