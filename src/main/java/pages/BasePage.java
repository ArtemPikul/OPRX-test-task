package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static driver.WaitUtils.waitFor;

public class BasePage {

    protected void clickOnElementLocated(By locator) {
        waitFor(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    protected void fillInputWithText(By locator, String text) {
        waitFor(ExpectedConditions.visibilityOfElementLocated(locator)).sendKeys(text);
    }

    protected void clearInputAndFillWithText(By locator, String text) {
        WebElement input = waitFor(ExpectedConditions.visibilityOfElementLocated(locator));
        input.clear();
        input.sendKeys(text);
    }

    protected List<WebElement> getListOfWebElements(By locator) {
        return waitFor(ExpectedConditions.visibilityOfElementLocated(locator)).findElements(locator);
    }
}
