package driver;

import org.openqa.selenium.WebDriver;

public class DriverManager {
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        WebDriver webDriver = driver.get();
        if (webDriver == null) {
            throw new RuntimeException("WebDriver instance not found for the current thread.");
        }
        return driver.get();

    }

    public static void setDriver(WebDriver driverInstance) {
        if (driverInstance == null) {
            throw new RuntimeException("WebDriver instance not found for the current thread.");
        }
        driver.set(driverInstance);

    }

    public static void cleanUpDriver() {
        WebDriver webDriver = driver.get();
        if (webDriver != null) {
            try {
                webDriver.quit();
            } catch (Exception e) {
                System.err.println(e.getMessage());
            } finally {
                driver.remove();
            }
        }
    }

}
