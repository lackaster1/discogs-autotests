package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {
    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = ".//*[@id='log_in_link']")
    public WebElement logInButton;

    @FindBy(xpath = ".//button[@id='onetrust-reject-all-handler']")
    public WebElement rejectCookiesButton;
}
