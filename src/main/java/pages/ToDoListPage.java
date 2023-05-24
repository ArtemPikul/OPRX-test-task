package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ToDoListPage extends BasePage {

    private By taskNameRow = By.xpath("//tbody/tr/td[@class='text']");
    private By editButton = By.cssSelector("#headline > a");

    public int getAmountOfTasksCreated() {

        List<WebElement> tasksList = getListOfWebElements(taskNameRow);
        return tasksList.size();
    }

    public List<String> getTextOfTasksCreated() {

        List<WebElement> tasksList = getListOfWebElements(taskNameRow);
        List<String> tasksTextList = new ArrayList<>();

        for (WebElement element : tasksList) {
            tasksTextList.add(element.getText());
        }
        return tasksTextList;
    }

    public void clickEditButton() {
        clickOnElementLocated(editButton);
    }

}
