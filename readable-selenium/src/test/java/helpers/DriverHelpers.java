package helpers;

import dataentities.DriverType;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverHelpers {

    public static WebDriver createADriverOfType(DriverType driverType) {

        switch(driverType) {
            case CHROME:
                System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
                WebDriver driver = new ChromeDriver();
                driver.manage().window().maximize();
                return driver;
            default:
                Assert.fail("Unsupported driver type: " + driverType.toString());
                return null;
        }
    }
}
