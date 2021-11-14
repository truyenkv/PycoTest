package pyco.pageobject;


import org.openqa.selenium.WebDriver;
import pyco.core.AbstractPage;
import pyco.pageui.LoginPageUI;
import pyco.pageui.WelcomePageUI;

import static org.assertj.core.api.Assertions.assertThat;

public class WelComePageObject extends AbstractPage {
    private WebDriver driver;

    public WelComePageObject(WebDriver driver){
        this.driver = driver;
    }

    public void verifyLoginSuccessMessageDisplay(String message) {
        waitForElementVisible(driver, WelcomePageUI.LOGIN_SUCCESS_MESS);
        String err = getElementText(driver, WelcomePageUI.LOGIN_SUCCESS_MESS);
        assertThat(err).isEqualTo(message);
    }




}

