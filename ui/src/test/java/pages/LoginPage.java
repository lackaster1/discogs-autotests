package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {
    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = ".//header")
    public WebElement loginPageHeader;

    @FindBy(xpath = ".//input[@name='username']")
    public WebElement userNameInput;

    @FindBy(xpath = ".//input[@name='password']")
    public WebElement passwordInput;

    @FindBy(xpath = ".//button[@name='action']")
    public WebElement continueButton;

    @FindBy(xpath = ".//div[@id='prompt-alert']")
    public WebElement errorMessage;
}
