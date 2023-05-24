package pages;

import org.openqa.selenium.By;

public class EditToDoListPage extends BasePage {

    private By editTasksForm = By.name("tasks");
    private By saveTasksButton = By.className("big");

    public void clearAndFillEditTasksForm(String text) {
        clearInputAndFillWithText(editTasksForm, text);
    }

    public void clickSaveTasksButton() {
        clickOnElementLocated(saveTasksButton);
    }
}
