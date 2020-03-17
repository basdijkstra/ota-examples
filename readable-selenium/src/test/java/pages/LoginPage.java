package pages;

import dataentities.Credentials;
import dataentities.User;
import helpers.SeleniumHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;
    private SeleniumHelpers selenium = new SeleniumHelpers();

    private By textfieldUsername = By.name("username");
    private By textfieldPassword = By.name("password");
    private By buttonDoLogin = By.xpath("//input[@value='Log In']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage load() {
        selenium.gotoUrl(driver,"http://parabank.parasoft.com");
        return this;
    }

    public void loginUsing(Credentials credentials) {
        selenium.sendKeys(driver, textfieldUsername, credentials.getUsername());
        selenium.sendKeys(driver, textfieldPassword, credentials.getPassword());
        selenium.click(driver, buttonDoLogin);
    }
}
