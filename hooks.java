package com.hooks;

import com.utilities.ConfigReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Hooks {

    private static WebDriver driver;

    @Before
    public void setUp() {
        // Initialize ConfigReader
        ConfigReader configReader = new ConfigReader();
        configReader.init_prop();

        // Get browser type from config
        String browser = ConfigReader.getProperty("browser");

        // Initialize WebDriver based on browser type
        if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver");
            driver = new FirefoxDriver();
        } else {
            throw new IllegalArgumentException("Unsupported browser: " + browser);
        }

        // Maximize browser window and navigate to URL
        driver.manage().window().maximize();
        driver.get(ConfigReader.getProperty("url"));
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    public static WebDriver getDriver() {
        return driver;
    }
}
