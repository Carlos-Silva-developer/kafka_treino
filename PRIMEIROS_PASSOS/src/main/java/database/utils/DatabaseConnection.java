package database.utils;

import database.config.DatabaseConfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnection {
    public static Connection getConnection() throws SQLException {
        Properties properties = DatabaseConfig.loadProperties();

        String url = properties.getProperty("db.url");
        String user = properties.getProperty("db.user");
        String password = properties.getProperty("db.password");

        return DriverManager.getConnection(url, user, password);
    }

    @Override
    public String toString() {

        var returnedData = new StringBuffer();

        returnedData.append("url: " + DatabaseConfig.loadProperties().getProperty("db.url"));
        returnedData.append("\nuser: " + DatabaseConfig.loadProperties().getProperty("db.user"));
        returnedData.append("\npassword: " + DatabaseConfig.loadProperties().getProperty("db.password"));

        return returnedData.toString();

    }
}

