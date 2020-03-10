package pages;

import dataentities.Account;
import helpers.SeleniumHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OpenAccountResultPage {

    private WebDriver driver;
    private SeleniumHelpers selenium = new SeleniumHelpers();

    private By textfieldNewAccountId = By.id("newAccountId");

    public OpenAccountResultPage(WebDriver driver) {
        this.driver = driver;
    }

    public OpenAccountResultPage load() {
        selenium.gotoUrl(driver, "http://parabank.parasoft.com/parabank/openaccount.htm");
        return this;
    }

    public boolean newAccountIdIsDisplayed() {
        return selenium.isDisplayed(driver, textfieldNewAccountId);
    }
}
