package pages;

import helpers.SeleniumHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountsOverviewPage {

    private WebDriver driver;
    private SeleniumHelpers selenium = new SeleniumHelpers();

    public AccountsOverviewPage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectMenuItem(String menuItem) {
        selenium.click(driver, By.linkText(menuItem));
    }
}
