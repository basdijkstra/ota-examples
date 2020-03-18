import dataentities.*;
import helpers.ApiHelpers;
import helpers.DriverHelpers;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import pages.*;

import static org.assertj.core.api.Assertions.assertThat;

public class OpenAccountTest {

    private WebDriver driver;

    @Before
    public void initializeDatabaseAndLogin() {

        ApiHelpers.initializeDatabaseBeforeTest();

        driver = DriverHelpers.createADriverOfType(DriverType.CHROME);

        Credentials johnsCredentials = Credentials.builder().username("john").password("demo").build();

        new LoginPage(driver).
                load().
                loginUsing(johnsCredentials);
    }

    @Test
    public void openAccount_withSufficientFunds_shouldSucceed() {

        Account aNewCheckingAccount =
                Account.builder().type(AccountType.CHECKING).build();

        Account depositingFromAccount =
                Account.builder().id(12345).build();

        new OpenAccountPage(driver).
                load().
                open(aNewCheckingAccount, depositingFromAccount);

        boolean newAccountIdIsDisplayed = new OpenAccountResultPage(driver).newAccountIdIsDisplayed();

        assertThat(newAccountIdIsDisplayed).isTrue();
    }

    @After
    public void closeBrowser() {

        driver.quit();
    }
}
