package pages;

import dataentities.Customer;
import helpers.SeleniumHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterCustomerResultPage {

    private WebDriver driver;
    private SeleniumHelpers selenium = new SeleniumHelpers();

    private By textlabelConfirmation = By.xpath("//p[text()='Your account was created successfully. You are now logged in.']");

    public RegisterCustomerResultPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean registrationConfirmationIsVisible() {
        return selenium.isDisplayed(driver, textlabelConfirmation);
    }
}
