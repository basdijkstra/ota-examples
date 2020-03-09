package helpers;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

public class SeleniumHelpers {

    public SeleniumHelpers() {
    }

    public void gotoUrl(WebDriver driver, String url) {
        driver.navigate().to(url);
    }

    public void click(WebDriver driver, By by) {

        try {
            new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(by));
            driver.findElement(by).click();
        }
        catch (TimeoutException te) {
            Assert.fail(String.format("Exception in click(): %s", te.getMessage()));
        }
    }

    public void sendKeys(WebDriver driver, By by, String textToType) {

        try {
            new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(by));
            driver.findElement(by).sendKeys(textToType);
        }
        catch (TimeoutException te) {
            Assert.fail(String.format("Exception in sendKeys(): %s", te.getMessage()));
        }
    }

    public void select(WebDriver driver, By by, String valueToSelect) {

        try {
            new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(by));
            new Select(driver.findElement(by)).selectByVisibleText(valueToSelect);
        }
        catch (TimeoutException te) {
            Assert.fail(String.format("Exception in select(): %s", te.getMessage()));
        }
    }

    public void selectWithWait(WebDriver driver, By by, String valueToSelect) {

        try {
            new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfNestedElementLocatedBy(by, By.xpath(String.format("//option[text()='%s']", valueToSelect))));
            new Select(driver.findElement(by)).selectByVisibleText(valueToSelect);
        }
        catch (TimeoutException te) {
            Assert.fail(String.format("Exception in select(): %s", te.getMessage()));
        }
    }

    public boolean isDisplayed(WebDriver driver, By by) {

        try {
            new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(by));
            return true;
        }
        catch (TimeoutException te) {
            return false;
        }
    }

    public String getElementText(WebDriver driver, By by) {

        try {
            new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(by));
            return driver.findElement(by).getText();
        }
        catch (TimeoutException te) {
            return "Element not found";
        }
    }
}
