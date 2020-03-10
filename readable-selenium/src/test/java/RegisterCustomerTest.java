import dataentities.Account;
import dataentities.AccountType;
import dataentities.Customer;
import dataentities.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import static org.assertj.core.api.Assertions.assertThat;

public class RegisterCustomerTest {

    private WebDriver driver;

    @Before
    public void createBrowser() {

        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void createCustomer_withValidData_shouldBeAbleToLogin() {

        Customer aCustomerWithValidDetails = new Customer().toBuilder().build();

        System.out.println("CUSTOMER: " + aCustomerWithValidDetails.getFirstName());

        new RegisterCustomerPage(driver).
                load().
                register(aCustomerWithValidDetails);

        boolean customerWasRegisteredSuccessfully =
                new RegisterCustomerResultPage(driver).registrationConfirmationIsVisible();

        assertThat(customerWasRegisteredSuccessfully).isTrue();
    }

    @After
    public void closeBrowser() {

        driver.quit();
    }
}
