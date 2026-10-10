package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import base.BaseClass; // Assuming your driver initialization is here
import utils.wait; // Your custom wait utility from the screenshot

public class AdminLoginPage extends BaseClass {

    // 1. Define Locators using @FindBy
    @FindBy(id = "username")
    private WebElement usernameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement loginButton;

    // 2. Constructor to initialize PageFactory
    public AdminLoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // 3. Page Actions (Replacing ElementUtils with standard Selenium)
    public void enterUsername(String username) {
        // Example of using your wait.java utility (assuming it has a waitForVisibility method)
        // wait.waitForVisibility(driver, usernameField, 10); 
        usernameField.clear();
        usernameField.sendKeys(username);
    }

    public void enterPassword(String password) {
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void clickLogin() {
        loginButton.click();
    }

    // Combined method for convenience
    public void loginToAdminPortal(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }
}
