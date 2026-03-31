package utils;

import driver.DriverManager;
import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtils {
    private WaitUtils() {}
    private static final ThreadLocal<WebDriverWait> webDriverWait = new ThreadLocal<>();

    public static WebDriverWait getWait() {
       if(webDriverWait.get() == null) {
           webDriverWait.set(new WebDriverWait(DriverManager.getDriver()
                   , Duration.ofSeconds(ConfigReader.getNumericProperty("explicitWait"))));
       }
       return webDriverWait.get();
    }

    public static WebElement waitForElementVisibility(By locator) {
        return getWait().until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static WebElement waitForElementClickable(By locator) {
        return getWait().until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static boolean waitForElementToBeSelected(By locator) {
        return getWait().until(ExpectedConditions.elementToBeSelected(locator));
    }
}
