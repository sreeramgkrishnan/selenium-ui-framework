package base;

import constants.Browser;
import driver.DriverFactory;
import driver.DriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.ConfigReader;

public class BaseTest {
    @BeforeMethod
    public void setup() {
        String browser = ConfigReader.getProperty("browser");
        Browser browserType = Browser.valueOf(browser.toUpperCase());
        DriverFactory.initDriver(browserType);
        DriverManager.getDriver().get(ConfigReader.getProperty("appURL"));
    }

    @AfterMethod
    public void tearDown() {
        DriverManager.cleanUpDriver();
    }
}
