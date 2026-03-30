package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
    public static WebDriver initDriver(String browser) {
        WebDriver driver = switch (browser) {
            case "chrome" -> new ChromeDriver();
            case "firefox" -> new FirefoxDriver();
            default -> throw new IllegalArgumentException("Browser not supported");
        };
        DriverManager.setDriver(driver);
        driver.manage().window().maximize();
        return driver;
    }
}
