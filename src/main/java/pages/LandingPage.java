package pages;

import org.openqa.selenium.By;

public class LandingPage extends BasePage{

    private By createDailyToDoListButton = By.cssSelector("#start > input");

    public void clickCreateDailyToDoListButton() {
        clickOnElementLocated(createDailyToDoListButton);
    }
}
