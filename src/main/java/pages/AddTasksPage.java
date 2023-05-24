package pages;

import org.openqa.selenium.By;

public class AddTasksPage extends BasePage {

    private By addTaskForm = By.name("tasks");
    private By saveTasksButton = By.className("big");

    public void fillListCreationForm(String text) {
        fillInputWithText(addTaskForm, text);
    }

    public void clickSaveTasksButton() {
        clickOnElementLocated(saveTasksButton);
    }
}
