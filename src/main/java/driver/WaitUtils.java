package driver;

import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

import static driver.DriverUtils.getDriver;

public class WaitUtils {

    public static <T> T waitFor(ExpectedCondition<T> condition, Duration timeout, Duration polling) {
        return new FluentWait<>(getDriver())
                .withTimeout(timeout)
                .pollingEvery(polling)
                .ignoring(WebDriverException.class, IndexOutOfBoundsException.class)
                .until(condition);
    }

    public static <T> T waitFor(ExpectedCondition<T> condition) {
        return waitFor(condition, Duration.ofSeconds(15), Duration.ofSeconds(1));
    }
}
