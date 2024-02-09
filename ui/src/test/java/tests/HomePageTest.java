package tests;

import org.junit.jupiter.api.extension.ExtendWith;
import steps.BaseSteps;
import steps.HomePageSteps;
import utils.WebDriverExtension;

@ExtendWith(WebDriverExtension.class)
public class HomePageTest {
    private HomePageSteps homePageSteps = new HomePageSteps();
    private BaseSteps baseSteps = new BaseSteps();

}
