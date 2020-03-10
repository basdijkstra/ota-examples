package pages;

import helpers.SeleniumHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountsOverviewPage {

    private WebDriver driver;
    private SeleniumHelpers selenium = new SeleniumHelpers();

    private By textlabelPageHeader = By.xpath("//h1[text()='Accounts Overview']");

    public AccountsOverviewPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isLoaded() {
        return selenium.isDisplayed(driver, textlabelPageHeader);
    }

    public void selectMenuItem(String menuItem) {
        selenium.click(driver, By.linkText(menuItem));
    }
}
