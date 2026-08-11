package com.orangehrm.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    // Encapsulation
    private static Properties properties = new Properties();

    private static final String FILE_PATH =
            "src/test/resources/config/config.properties";

    // Load configuration
    static {
        try {
            FileInputStream file = new FileInputStream(FILE_PATH);
            properties.load(file);
            file.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Private constructor
    private ConfigReader() {
    }

    // Abstraction
    public static String getProperty(String key) {
        return properties.getProperty(key);
    }

    public static int getIntProperty(String key) {
        return Integer.parseInt(properties.getProperty(key));
    }
}