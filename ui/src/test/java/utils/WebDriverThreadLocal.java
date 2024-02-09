package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverThreadLocal {
    private static ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();
    private static ConfigReader configReader = new ConfigReader();

    private WebDriverThreadLocal() {
    }

    public static WebDriver getDriver() {
        if (driverThreadLocal.get() == null) {
            String driverPath = configReader.getDriverPath();
            System.setProperty(configReader.getBrowserProperty(), driverPath);
            driverThreadLocal.set(new ChromeDriver());
        }
        return driverThreadLocal.get();
    }

    public static void quitDriver() {
        WebDriver driver = driverThreadLocal.get();
        if (driver != null) {
            driver.quit();
            driverThreadLocal.remove();
        }
    }
}
