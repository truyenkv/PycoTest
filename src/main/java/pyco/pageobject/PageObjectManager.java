package pyco.pageobject;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {
    public static LoginPageObject getLoginPage(WebDriver driver){
        return new LoginPageObject(driver);
    }

    public static WelComePageObject getWelcomPage(WebDriver driver){
        return new WelComePageObject(driver);
    }

}
