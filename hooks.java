package com.hooks;

import com.config.ConfigReader;
import com.driverFactory.DriverFactory;
import io.cucumber.java.Before;
import io.cucumber.java.After;

public class Hooks { 

    @Before 
    public void setUp() {
        DriverFactory.initDriver(ConfigReader.getProperty("browser"));
        DriverFactory.getDriver().get(ConfigReader.getProperty("url"));
    } 

    @After 
    public void tearDown() {
        DriverFactory.quitDriver();
    } 
}
