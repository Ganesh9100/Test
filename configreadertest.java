
package com.tests;

import com.utilities.ConfigReader;
import org.testng.annotations.Test;

public class ConfigReaderTest {

    @Test
    public void testConfigReader() {
        ConfigReader configReader = new ConfigReader();
        configReader.initProperties();

        String url = ConfigReader.getProperty("url");
        String username = ConfigReader.getProperty("adminUsername");
        String password = ConfigReader.getProperty("adminPassword");

        System.out.println("URL: " + url);
        System.out.println("Username: " + username);
        System.out.println("Password: " + password);

        assert url != null : "URL is null!";
        assert username != null : "Username is null!";
        assert password != null : "Password is null!";
    }
}
