package database.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DatabaseConfig {
    private static final String PROPERTIES_FILE = "database.properties";

    public static Properties loadProperties() {

        Properties properties = new Properties();

        try (InputStream inputStream = DatabaseConfig.class.getClassLoader().getResourceAsStream(PROPERTIES_FILE)) {
            properties.load(inputStream);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
}
