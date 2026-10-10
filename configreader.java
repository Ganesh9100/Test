package com.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static Properties prop;

    // Initialize properties from the config file
    public Properties initProperties() {
        prop = new Properties();
        File file = new File("./Config/Config.properties");
        try (FileInputStream fis = new FileInputStream(file)) {
            prop.load(fis);
        } catch (IOException e) {
            System.out.println("Error loading configuration file: " + e.getMessage());
        }
        return prop;
    }

    // Get property value by key
    public static String getProperty(String key) {
        if (prop == null) {
            throw new IllegalStateException("Properties file not initialized. Call initProperties() first.");
        }
        return prop.getProperty(key);
    }
}
