package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static final Properties properties;
    private ConfigReader() {
        // private constructor to prevent instantiation
    }


   static {
        try {
            FileInputStream fis = new FileInputStream("src/main/resources/config.properties");
            properties = new Properties();
            properties.load(fis);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static String getProperty(String key) {
        return properties.getProperty(key);
    }

    public static int getNumericProperty(String key) {
        return Integer.parseInt(properties.getProperty(key));
    }


}
