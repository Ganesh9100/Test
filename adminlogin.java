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

    // Locators
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

    // Constructor
    public Adminlogin(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    // Page Actions
    public String getAdminPageTitle() { 
        return driver.getTitle(); 
    }
    
    public String getcurrentUrl() { 
        return driver.getCurrentUrl(); 
    }
    
    public void clicktheadminbutton() { 
        wait.until(ExpectedConditions.elementToBeClickable(adminbutton)).click(); 
    }
    
    public void enterEmailid(String email) { 
        WebElement e = wait.until(ExpectedConditions.visibilityOf(emailfield)); 
        e.clear(); 
        e.sendKeys(email); 
    }
    
    public void enterPassword(String password) { 
        WebElement e = wait.until(ExpectedConditions.visibilityOf(passwordfield)); 
        e.clear(); 
        e.sendKeys(password); 
    }
    
    public void clickauthendicatebutton() { 
        scrollAndClick(authenticatebuttonElement); 
    }
    
    public void enterpasscode(String otp) { 
        WebElement e = wait.until(ExpectedConditions.visibilityOf(authorizefield)); 
        e.clear(); 
        e.sendKeys(otp); 
    }
    
    public void clicksubmitbutton() { 
        scrollAndClick(submitbutton); 
    }
    
    public String getvalidationMessage() { 
        return wait.until(ExpectedConditions.visibilityOf(invalidemailmessag)).getText(); 
    }
    
    public String getvalidationMessageotp() { 
        return wait.until(ExpectedConditions.visibilityOf(invalidotp)).getText(); 
    }
    
    public void dipalyedfapage() { 
        wait.until(ExpectedConditions.visibilityOf(FAPagetext)).isDisplayed(); 
    }
    
    public Dashboard doLogin(String email, String password, String otp) {
        enterEmailid(email); 
        enterPassword(password); 
        clickauthendicatebutton(); 
        enterpasscode(otp); 
        clicksubmitbutton();
        return new Dashboard(driver); // Ensure you have a Dashboard.java class
    }
    
    // Helper method replacing ElementUtils
    private void scrollAndClick(WebElement element) {
        WebElement e = wait.until(ExpectedConditions.visibilityOf(element));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", e);
        wait.until(ExpectedConditions.elementToBeClickable(e)).click();
    }
}
