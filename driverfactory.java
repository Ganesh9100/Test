package com.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverFactory {

    private static WebDriver driver;

    public static void initDriver(String browser) {

        if (browser == null || browser.isEmpty()) {
            browser = "chrome";
        }

        switch (browser.toLowerCase()) {

            case "chrome":
                ChromeOptions options = new ChromeOptions();
                driver = new ChromeDriver(options);
                break;

            case "firefox":
                driver = new FirefoxDriver();
                break;

            default:
                throw new IllegalArgumentException(
                    "Unsupported browser: " + browser
                );
        }

        driver.manage().window().maximize();
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            throw new IllegalStateException(
                "WebDriver is not initialized. Call initDriver() first."
            );
        }

        return driver;
    }

    public static void quitDriver() {

        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
