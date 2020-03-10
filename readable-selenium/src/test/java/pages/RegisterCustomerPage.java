package pages;

import dataentities.Customer;
import helpers.SeleniumHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterCustomerPage {

    private WebDriver driver;
    private SeleniumHelpers selenium = new SeleniumHelpers();

    private By textfieldFirstName = By.id("customer.firstName");
    private By textfieldLastName = By.id("customer.lastName");
    private By textfieldStreetAndHouseNumber = By.id("customer.address.street");
    private By textfieldCity = By.id("customer.address.city");
    private By textfieldState = By.id("customer.address.state");
    private By textfieldZipCode = By.id("customer.address.zipCode");
    private By textfieldPhoneNumber = By.id("customer.phoneNumber");
    private By textfieldSsn = By.id("customer.ssn");
    private By textfieldUsername = By.id("customer.username");
    private By textfieldPassword = By.id("customer.password");
    private By textfieldPasswordRepeat = By.id("repeatedPassword");
    private By buttonRegister = By.xpath("//input[@value='Register']");

    public RegisterCustomerPage(WebDriver driver) {
        this.driver = driver;
    }

    public RegisterCustomerPage load() {
        selenium.gotoUrl(driver, "http://parabank.parasoft.com/parabank/register.htm");
        return this;
    }

    public void register(Customer customer) {
        selenium.sendKeys(driver, textfieldFirstName, customer.getFirstName());
        selenium.sendKeys(driver, textfieldLastName, customer.getLastName());
        selenium.sendKeys(driver, textfieldStreetAndHouseNumber, customer.getAddress().getStreetAndHouseNumber());
        selenium.sendKeys(driver, textfieldCity, customer.getAddress().getCity());
        selenium.sendKeys(driver, textfieldState, customer.getAddress().getState());
        selenium.sendKeys(driver, textfieldZipCode, customer.getAddress().getZipCode());
        selenium.sendKeys(driver, textfieldPhoneNumber, customer.getPhoneNumber());
        selenium.sendKeys(driver, textfieldSsn, customer.getSsn());
        selenium.sendKeys(driver, textfieldUsername, customer.getCredentials().getUsername());
        selenium.sendKeys(driver, textfieldPassword, customer.getCredentials().getPassword());
        selenium.sendKeys(driver, textfieldPasswordRepeat, customer.getCredentials().getPassword());
        selenium.click(driver, buttonRegister);
    }
}
