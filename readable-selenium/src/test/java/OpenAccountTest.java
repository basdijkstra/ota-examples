import dataentities.Account;
import dataentities.AccountType;
import dataentities.LoanRequest;
import dataentities.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import static org.assertj.core.api.Assertions.assertThat;

public class OpenAccountTest {

    private WebDriver driver;

    @Before
    public void createBrowser() {

        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();

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
