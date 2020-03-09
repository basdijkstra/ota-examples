package pages;

import dataentities.LoanRequest;
import helpers.SeleniumHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RequestLoanPage {

    private WebDriver driver;
    private SeleniumHelpers selenium = new SeleniumHelpers();

    private By textfieldLoanAmount = By.id("amount");
    private By textfieldDownPayment = By.id("downPayment");
    private By dropdownFromAccountId = By.id("fromAccountId");
    private By buttonApplyForLoan = By.xpath("//input[@value='Apply Now']");

    public RequestLoanPage(WebDriver driver) {
        this.driver = driver;
    }

    public RequestLoanPage load() {
        selenium.gotoUrl(driver, "http://parabank.parasoft.com/parabank/requestloan.htm");
        return this;
    }

    public void submit(LoanRequest loanRequest) {
       selenium.sendKeys(driver, textfieldLoanAmount, loanRequest.getLoanAmount());
       selenium.sendKeys(driver, textfieldDownPayment, loanRequest.getDownPayment());
       selenium.select(driver, dropdownFromAccountId, loanRequest.getFromAccountId());
       selenium.click(driver, buttonApplyForLoan);
    }
}
