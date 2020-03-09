package pages;

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

    public void loginAs(User user) {
        selenium.sendKeys(driver, textfieldUsername, user.getUsername());
        selenium.sendKeys(driver, textfieldPassword, user.getPassword());
        selenium.click(driver, buttonDoLogin);
    }
}
