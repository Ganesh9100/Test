package com.pages;

import com.hooks.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdminLogin {

    private WebDriver driver;

    // Locators
    private By usernameField = By.id("username");
    private By passwordField = By.id("password");
    private By loginButton = By.id("loginBtn");

    // Constructor
    public AdminLogin() {
        this.driver = Hooks.getDriver(); // Get WebDriver instance from Hooks
    }

    // Actions
    public void enterUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    // Additional methods for validation, if needed
    public String getPageTitle() {
        return driver.getTitle();
    }
}
