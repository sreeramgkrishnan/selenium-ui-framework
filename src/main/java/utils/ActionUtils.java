package utils;

import driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionUtils {

    private ActionUtils() {}

    private static final ThreadLocal<Actions> actions = new ThreadLocal<>();

    public static Actions getActions() {
        if(actions.get() == null) {
            actions.set(new Actions(DriverManager.getDriver()));
        }
        return actions.get();
    }

    public static void hover(By locator) {
        WebElement element = WaitUtils.waitForElementVisibility(locator);
        getActions().moveToElement(element).perform();
    }

    public static void rightClick(By locator) {
        WebElement element = WaitUtils.waitForElementClickable(locator);
        getActions().moveToElement(element).contextClick().build().perform();
    }

    public static void clickAndHold(By locator) {
        WebElement element = WaitUtils.waitForElementClickable(locator);
        getActions().moveToElement(element).clickAndHold().build().perform();
    }

    public static void hoverAndClick(By locator) {
        WebElement element = WaitUtils.waitForElementClickable(locator);
        getActions().moveToElement(element).click().build().perform();
    }

    public static void dragAndDrop(By sourceLocator, By targetLocator) {
        WebElement source = WaitUtils.waitForElementClickable(sourceLocator);
        WebElement target = WaitUtils.waitForElementClickable(targetLocator);
        getActions().dragAndDrop(source, target).perform();
    }

    public static void scrollToElement(By locator) {
        WebElement element = WaitUtils.waitForElementVisibility(locator);
        getActions().scrollToElement(element).perform();
    }


}
