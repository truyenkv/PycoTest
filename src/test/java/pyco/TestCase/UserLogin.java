package pyco.TestCase;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pyco.core.AbstractTest;
import pyco.dataProvider.DataTest;
import pyco.pageobject.LoginPageObject;
import pyco.pageobject.WelComePageObject;

public class UserLogin extends AbstractTest {
    private WebDriver driver;
    private LoginPageObject loginPageObject;
    private WelComePageObject welComePageObject;

    @DataProvider(name = "invalidEmail")
    public Object[][] InvalidEmail() {
        return new Object[][]{{" "}, {"truyen.com"}, {"truyen@.com"},
                {"truyen@gmail"}, {"truyen@gmail.com1"}, {"not_existed@gmail.com"}
        };
    }

    @DataProvider(name = "invalidPass")
    public Object[][] InvalidLogin() {
        return new Object[][]{{" "}, {"invalid_pasword"}
        };
    }

    @Parameters({"browser"})
    @BeforeMethod
    public void beforeMethod(String browser){
        driver = getDriver(browser);
        loginPageObject = new LoginPageObject(driver);
        welComePageObject = new WelComePageObject(driver);
    }

    @Test(priority = 1, dataProvider = "invalidEmail")
    public void verify_Display_Email_Error(String email){
        loginPageObject.inputUserNameAndPassword(email, DataTest.VALID_PASSWORD);
        loginPageObject.clickLoginButton();
        loginPageObject.verifyEmailErrDisplay(DataTest.EMAIL_ERROR_MESS);
    }

    @Test(priority = 2, dataProvider = "invalidPass")
    public void verify_Display_Password_Error(String password){
        loginPageObject.inputUserNameAndPassword(DataTest.VALID_EMAIL, password);
        loginPageObject.clickLoginButton();
        loginPageObject.verifyPasswordErrDisplay(DataTest.PASSWORD_ERROR_MESS);
    }

    @Test(priority = 3)
    public void verify_Login_Successfull(){
        loginPageObject.inputUserNameAndPassword(DataTest.VALID_EMAIL, DataTest.VALID_PASSWORD);
        welComePageObject = loginPageObject.clickLoginButton();
        welComePageObject.verifyLoginSuccessMessageDisplay(DataTest.LOGIN_SUCCESS_MESSAGE);
    }

    @AfterMethod
    public void afterMethod(){
        driver.quit();
    }
}
