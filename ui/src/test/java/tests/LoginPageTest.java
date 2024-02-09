package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import steps.BaseSteps;
import steps.HomePageSteps;
import steps.LoginPageSteps;
import utils.WebDriverExtension;

@ExtendWith(WebDriverExtension.class)
public class LoginPageTest {
    private LoginPageSteps loginPageSteps = new LoginPageSteps();
    private HomePageSteps homePageSteps = new HomePageSteps();
    private BaseSteps baseSteps = new BaseSteps();

    @BeforeEach
    public void setUp() {
    }

    @Test
    public void checkErrorMessageDisplayedWhenPasswordIncorrect() {
        openDiscogsLoginPage();

        loginPageSteps
                .enterUserName("User")
                .enterPassword("Password")
                .clickContinueButton()
                .checkErrorMessageDisplayed();

        //Verify home page
//        Assert.assertTrue(objHomePage.getHomePageDashboardUserName().toLowerCase().contains("manger id : mgr123"));
    }

    @Test
    public void checkErrorMessageDisplayedWhenLoginIncorrect() {
        openDiscogsLoginPage();

        loginPageSteps
                .enterUserName("User???")
                .enterPassword("Password")
                .clickContinueButton()
                .checkErrorMessageDisplayed();

        //Verify home page
//        Assert.assertTrue(objHomePage.getHomePageDashboardUserName().toLowerCase().contains("manger id : mgr123"));
    }

    private void openDiscogsLoginPage() {
        baseSteps.openPage("https://discogs.com/");
        homePageSteps
//                .clickRejectCookiesButton()
                .clickLogInButton();
        loginPageSteps
                .checkHeaderLoaded();
    }
}
