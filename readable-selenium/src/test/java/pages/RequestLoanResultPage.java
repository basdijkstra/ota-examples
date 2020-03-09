package pages;

import helpers.SeleniumHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RequestLoanResultPage {

    private WebDriver driver;
    private SeleniumHelpers selenium = new SeleniumHelpers();

    private By textfieldApplicationResult = By.id("loanStatus");

    public RequestLoanResultPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getLoanApplicationResult() {
        return selenium.getElementText(driver, textfieldApplicationResult);
    }
}
