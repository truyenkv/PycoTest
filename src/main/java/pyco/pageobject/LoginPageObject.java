package pyco.pageobject;

import pyco.core.AbstractPage;
import pyco.pageui.LoginPageUI;
import org.openqa.selenium.WebDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginPageObject extends AbstractPage {
    private WebDriver driver;

    public LoginPageObject(WebDriver driver){
        this.driver = driver;
    }

    public void inputUserNameAndPassword(String username, String password) {
        waitForElementVisible(driver, LoginPageUI.EMAIL_FIELD);
        inputText(driver, LoginPageUI.EMAIL_FIELD, username);
        waitForElementVisible(driver, LoginPageUI.PASSWORD_FIELD);
        inputText(driver, LoginPageUI.PASSWORD_FIELD, password);

    }

    public void verifyEmailErrDisplay(String errMess) {
        waitForElementVisible(driver, LoginPageUI.EMAIL_ERR);
        String err = getElementText(driver, LoginPageUI.EMAIL_ERR);
        assertThat(err).isEqualTo(errMess);
    }

    public void verifyPasswordErrDisplay(String errMess) {
        waitForElementVisible(driver, LoginPageUI.PASSWORD_ERR);
        String err = getElementText(driver, LoginPageUI.PASSWORD_ERR);
        assertThat(err).isEqualTo(errMess);
    }

    public WelComePageObject clickLoginButton() {
        waitForElementClickable(driver, LoginPageUI.LOGIN_BTN);
        clickToElement(driver, LoginPageUI.LOGIN_BTN);
        return PageObjectManager.getWelcomPage(driver);
    }

}

