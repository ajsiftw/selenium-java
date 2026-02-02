package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static final Properties properties;

    static {
        try {
            properties = new Properties();
            FileInputStream fis = new FileInputStream("src/test/resources/config.properties");
            properties.load(fis);
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load config.properties file");
        }
    }

    public static String getProperty(String key) {
        String value = properties.getProperty(key);
        if (value == null) {
            throw new RuntimeException("Property " + key + " not found in config.properties");
        }
        return value;
    }

    public static int getIntProperty(String key) {
        return Integer.parseInt(getProperty(key));
    }

    public static boolean getBooleanProperty(String key) {
        return Boolean.parseBoolean(getProperty(key));
    }
}