package base;

import driver.DriverFactory;
import driver.DriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.ConfigReader;

public class BaseTest {
    @BeforeMethod
    public void setup() {
        String browser = ConfigReader.getProperty("browser");
        String URL = ConfigReader.getProperty("appURL");
        DriverFactory.initDriver(browser);
        DriverManager.getDriver().get(URL);
    }

    @AfterMethod
    public void tearDown() {
        DriverManager.cleanUpDriver();
    }
}
