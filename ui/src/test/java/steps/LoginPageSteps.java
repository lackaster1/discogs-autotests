package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.support.PageFactory;
import pages.LoginPage;

public class LoginPageSteps extends BaseSteps {
    private LoginPage loginPage;

    public LoginPageSteps() {
        loginPage = PageFactory.initElements(driver, LoginPage.class);
    }

    @Step
    public LoginPageSteps checkHeaderLoaded() {
        loginPage.loginPageHeader.isDisplayed();
        return this;
    }

    @Step
    public LoginPageSteps enterUserName(String userName) {
        loginPage.userNameInput.sendKeys(userName);
        return this;
    }

    @Step
    public LoginPageSteps enterPassword(String password) {
        loginPage.passwordInput.sendKeys(password);
        return this;
    }

    @Step
    public LoginPageSteps clickContinueButton() {
        loginPage.continueButton.click();
        return this;
    }

    @Step
    public LoginPageSteps checkErrorMessageDisplayed() {
        loginPage.errorMessage.isDisplayed();
        return this;
    }
}
