package utils;

import driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ElementUtils {

    private ElementUtils() {}

    public static void type(By locator, String value) {
       WebElement element = WaitUtils.waitForElementVisibility(locator);
       element.clear();
       element.sendKeys(value);
    }

    public static void click(By locator) {
        WebElement element = WaitUtils.waitForElementClickable(locator);
        element.click();
    }

    public static void click(WebElement element) {
        element.click();
    }
    public static String getText(WebElement element) {
       return element.getText();
    }

    public static String getText(By locator) {
        return WaitUtils.waitForElementVisibility(locator).getText();
    }


}
