package driver;

import constants.Browser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static constants.Browser.*;

public class DriverFactory {
    public static WebDriver initDriver(Browser browser) {
        WebDriver driver = switch (browser) {
            case CHROME -> new ChromeDriver();
            case FIREFOX -> new FirefoxDriver();
            case EDGE -> new EdgeDriver();
        };
        DriverManager.setDriver(driver);
        driver.manage().window().maximize();
        return driver;
    }
}
