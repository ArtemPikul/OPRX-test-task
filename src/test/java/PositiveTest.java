import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.AddTasksPage;
import pages.EditToDoListPage;
import pages.LandingPage;
import pages.ToDoListPage;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PositiveTest extends BaseTest {

    private LandingPage landingPage = new LandingPage();
    private AddTasksPage addTasksPage = new AddTasksPage();
    private ToDoListPage toDoListPage = new ToDoListPage();
    private EditToDoListPage editToDoListPage = new EditToDoListPage();


    @DisplayName("Verify that TODO list is created with the input provided")
    @Test
    public void testCreateToDoList() {

        List<String> testData = new ArrayList<>();
        testData.add("Task 1");
        testData.add("Task 2");
        testData.add("Task 3");

        visit(BASE_URL);
        landingPage.clickCreateDailyToDoListButton();
        addTasksPage.fillListCreationForm(String.join("\n", testData));
        addTasksPage.clickSaveTasksButton();

        assertEquals(testData.size(), toDoListPage.getAmountOfTasksCreated());
        assertEquals(testData, toDoListPage.getTextOfTasksCreated());
    }

    @DisplayName("Verify TODO list is edited with the input provided")
    @Test
    public void testEditToDoList() {

        String addTaskTestValue = "Task 1";

        List<String> editTaskTestData = new ArrayList<>();
        editTaskTestData.add("Task 2");
        editTaskTestData.add("Task 3");

        visit(BASE_URL);
        landingPage.clickCreateDailyToDoListButton();
        addTasksPage.fillListCreationForm(addTaskTestValue);
        addTasksPage.clickSaveTasksButton();
        toDoListPage.clickEditButton();
        editToDoListPage.clearAndFillEditTasksForm(String.join("\n", editTaskTestData));
        editToDoListPage.clickSaveTasksButton();

        assertEquals(editTaskTestData.size(), toDoListPage.getAmountOfTasksCreated());
        assertEquals(editTaskTestData, toDoListPage.getTextOfTasksCreated());
    }
}
