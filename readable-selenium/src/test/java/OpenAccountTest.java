import dataentities.*;
import helpers.DriverHelpers;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import pages.*;

import static org.assertj.core.api.Assertions.assertThat;

public class OpenAccountTest {

    private WebDriver driver;

    @Before
    public void startBrowserAndLogIn() {

        driver = DriverHelpers.createADriverOfType(DriverType.CHROME);

        User john = User.builder().username("john").password("demo").build();

        new LoginPage(driver).
                load().
                loginAs(john);
    }

    @Test
    public void openAccount_withSufficientFunds_shouldSucceed() {

        Account aNewCheckingAccount =
                Account.builder().accountType(AccountType.CHECKING).build();

        new OpenAccountPage(driver).
                load().
                open(aNewCheckingAccount, "12345");

        boolean newAccountIdIsDisplayed = new OpenAccountResultPage(driver).newAccountIdIsDisplayed();

        assertThat(newAccountIdIsDisplayed).isTrue();
    }

    @After
    public void closeBrowser() {

        driver.quit();
    }
}
