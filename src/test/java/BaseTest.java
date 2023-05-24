import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeDriver;

import static driver.DriverUtils.getDriver;
import static driver.DriverUtils.setDriver;

public class BaseTest {

    protected static final String BASE_URL = "https://dailytodo.org/";

    @BeforeAll
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        setDriver(new ChromeDriver());
        getDriver().manage().window().maximize();
    }

    @BeforeEach
    public void clearCookiesBeforeTest() {
        getDriver().manage().deleteAllCookies();
    }

    @AfterAll
    public static void tearDown() {
        getDriver().quit();
    }

    public static void visit(String link) {
        getDriver().get(link);
    }
}
