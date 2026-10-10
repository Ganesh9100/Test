package utils;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class wait {
    
    public static void waitForElementVisible(WebDriver driver, WebElement element, int timeoutInSeconds) {
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        explicitWait.until(ExpectedConditions.visibilityOf(element));
    }
    
    public static void waitForElementClickable(WebDriver driver, WebElement element, int timeoutInSeconds) {
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        explicitWait.until(ExpectedConditions.elementToBeClickable(element));
    }
}
