package steps;

import io.qameta.allure.Step;
import org.openqa.selenium.support.PageFactory;
import pages.HomePage;

public class HomePageSteps extends BaseSteps {
    private HomePage homePage;

    public HomePageSteps() {
        homePage = PageFactory.initElements(driver, HomePage.class);
    }

    @Step
    public HomePageSteps clickLogInButton() {
        homePage.logInButton.click();
        return this;
    }

    @Step
    public HomePageSteps clickRejectCookiesButton() {
        if (homePage.rejectCookiesButton.isDisplayed()) {
            homePage.rejectCookiesButton.click();
        }
        return this;
    }
}
