package pages;

import org.openqa.selenium.WebDriver;
import utils.WebDriverThreadLocal;

public class BasePage {
    protected WebDriver driver;

    public BasePage() {
        driver = WebDriverThreadLocal.getDriver();
    }
}
