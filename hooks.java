package com.hooks;

import com.config.ConfigReader;
import com.factory.DriverFactory;

import io.cucumber.java.Before;
import io.cucumber.java.After;

public class Hooks {

    @Before
    public void setUp() {

        String browser = ConfigReader.getProperty("browser");
        String url = ConfigReader.getProperty("url");

        DriverFactory.initDriver(browser);

        DriverFactory.getDriver().get(url);
    }

    @After
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}
