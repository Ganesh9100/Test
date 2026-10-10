package com.config;

import java.io.IOException; 
import java.io.InputStream; 
import java.util.Properties;

public final class ConfigReader { 
    
    private static final Properties PROPERTIES = new Properties(); 
    
    static {
        try (InputStream in = ConfigReader.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (in == null) {
                throw new IllegalStateException("config.properties not found in test resources");
            }
            PROPERTIES.load(in);
        } catch (IOException e) {
            throw new RuntimeException("Could not load config.properties", e);
        }
    }

    private ConfigReader() {} 
    
    public static String getProperty(String key) {
        String value = PROPERTIES.getProperty(key);
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException("Missing config property: " + key);
        }
        return value.trim();
    }
}
