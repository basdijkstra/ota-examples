import dataentities.*;
import helpers.DriverHelpers;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import pages.*;

import static org.assertj.core.api.Assertions.assertThat;

public class RegisterCustomerTest {

    private WebDriver driver;

    @Before
    public void createBrowser() {

        driver = DriverHelpers.createADriverOfType(DriverType.CHROME);
    }

    @Test
    public void createCustomer_withValidData_shouldSeeConfirmation() {

        Customer aCustomerWithValidDetails = new Customer().toBuilder().build();

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
