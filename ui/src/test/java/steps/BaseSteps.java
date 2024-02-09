package steps;

import org.openqa.selenium.WebDriver;
import utils.WebDriverThreadLocal;
import java.util.concurrent.TimeUnit;

public class BaseSteps {
    protected WebDriver driver;

    public BaseSteps() {
        driver = WebDriverThreadLocal.getDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    public void openPage(String pageUrl) {
        driver.get(pageUrl);
    }
}
