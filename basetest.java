package com.base;

import org.openqa.selenium.WebDriver;

import com.factory.DriverFactory;

public class BaseTest {

    protected WebDriver driver;

    public void initializeDriver() {
        driver = DriverFactory.getDriver();
    }

    public WebDriver getDriver() {
        return driver;
    }
}
