package pages;

import dataentities.Account;
import helpers.SeleniumHelpers;
import org.openqa.selenium.*;

public class OpenAccountPage {

    private WebDriver driver;
    private SeleniumHelpers selenium = new SeleniumHelpers();

    private By dropdownAccountType = By.id("type");
    private By dropdownFromAccountId = By.id("fromAccountId");
    private By buttonOpenNewAccount = By.xpath("//input[@value='Open New Account']");

    public OpenAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public OpenAccountPage load() {
        selenium.gotoUrl(driver, "http://parabank.parasoft.com/parabank/openaccount.htm");
        return this;
    }

    public void open(Account account, String depositFromAccountWithId) {
        selenium.select(driver, dropdownAccountType, account.getAccountType().toString());
        selenium.selectWithWait(driver, dropdownFromAccountId, depositFromAccountWithId);
        selenium.click(driver, buttonOpenNewAccount);
    }
}
