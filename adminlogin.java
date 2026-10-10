package com.Pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Adminlogin {

    private final WebDriver driver;
    private final WebDriverWait wait;

    public Adminlogin(WebDriver driver) {

        this.driver = driver;

        this.wait = new WebDriverWait(
            driver, Duration.ofSeconds(10)
        );

        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[text()='Admin']")
    public WebElement adminbutton;

    @FindBy(id = "super-admin-email")
    public WebElement emailfield;

    @FindBy(xpath = "//*[@type='password']")
    public WebElement passwordfield;

    @FindBy(xpath = "//button[normalize-space()='Authenticate Super-Admin']")
    public WebElement authenticatebuttonElement;

    @FindBy(id = "enter-admin-2fa-code")
    public WebElement authorizefield;

    @FindBy(xpath = "//button[normalize-space()='Authorize Administrative Session']")
    public WebElement submitbutton;

    @FindBy(xpath = "//*[@class='lucide lucide-log-out w-4 h-4']")
    public WebElement adminlogout;

    @FindBy(xpath = "//*[normalize-space()='Invalid admin credentials']")
    public WebElement invalidemailmessag;

    @FindBy(xpath = "//span[contains(text(),'Invalid admin OTP')]")
    public WebElement invalidotp;

    @FindBy(xpath = "//*[@class='text-xs font-bold text-indigo-950 dark:text-indigo-200']")
    public WebElement FAPagetext;


    // Get page title
    public String getAdminPageTitle() {
        return driver.getTitle();
    }


    // Get current URL
    public String getcurrentUrl() {
        return driver.getCurrentUrl();
    }


    // Click Admin button
    public void clicktheadminbutton() {

        wait.until(
            ExpectedConditions.elementToBeClickable(adminbutton)
        ).click();
    }


    // Enter email
    public void enterEmailid(String email) {

        wait.until(
            ExpectedConditions.visibilityOf(emailfield)
        ).sendKeys(email);
    }


    // Enter password
    public void enterPassword(String password) {

        wait.until(
            ExpectedConditions.visibilityOf(passwordfield)
        ).sendKeys(password);
    }


    // Scroll to element and click
    public void clickauthendicatebutton() {

        wait.until(
            ExpectedConditions.visibilityOf(
                authenticatebuttonElement
            )
        );

        ((JavascriptExecutor) driver).executeScript(
            "arguments[0].scrollIntoView({block:'center'});",
            authenticatebuttonElement
        );

        wait.until(
            ExpectedConditions.elementToBeClickable(
                authenticatebuttonElement
            )
        ).click();
    }


    // Enter OTP
    public void enterpasscode(String otp) {

        wait.until(
            ExpectedConditions.visibilityOf(authorizefield)
        ).sendKeys(otp);
    }


    // Click submit button
    public void clicksubmitbutton() {

        ((JavascriptExecutor) driver).executeScript(
            "arguments[0].scrollIntoView({block:'center'});",
            submitbutton
        );

        wait.until(
            ExpectedConditions.elementToBeClickable(submitbutton)
        ).click();
    }


    // Get invalid credentials message
    public String getvalidationMessage() {

        return wait.until(
            ExpectedConditions.visibilityOf(invalidemailmessag)
        ).getText();
    }


    // Get invalid OTP message
    public String getvalidationMessageotp() {

        return wait.until(
            ExpectedConditions.visibilityOf(invalidotp)
        ).getText();
    }


    // Check whether the 2FA page text is displayed
    public void dipalyedfapage() {

        wait.until(
            ExpectedConditions.visibilityOf(FAPagetext)
        ).isDisplayed();
    }


    // Complete admin login
    public Dashboard doLogin(
            String email,
            String password,
            String otp) {

        enterEmailid(email);

        enterPassword(password);

        clickauthendicatebutton();

        enterpasscode(otp);

        clicksubmitbutton();

        return new Dashboard(driver);
    }
}
