package pyco.core;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public abstract class AbstractPage {
    private int time = 20;
    private Select select;
    private WebDriverWait explicitWait;
    private WebElement element;
    private JavascriptExecutor jsExecutor;
    private Actions actions;
    private List<WebElement> elements;


    protected void sleepInSeccond(int sec){
        try {
            Thread.sleep(sec*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    private By byId(String idValue) {
        return By.id(idValue);
    }

    protected WebElement find(WebDriver driver, String idValue) {
        return driver.findElement(byId(idValue));
    }

    protected void clickToElement(WebDriver driver, String idValue) {
        find(driver, idValue).click();
    }

    protected void waitForElementVisible(WebDriver driver, String idValue) {
        explicitWait = new WebDriverWait(driver, time);
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(byId(idValue)));
    }


    protected void waitForElementClickable(WebDriver driver, String idValue) {
        explicitWait = new WebDriverWait(driver, time);
        explicitWait.until(ExpectedConditions.elementToBeClickable(byId(idValue)));
    }

    public boolean isElementDisplay(WebDriver driver, String xpathValue) {
        return find(driver, xpathValue).isDisplayed();
    }

    protected void checkTheCheckBox(WebDriver driver, String xpathValue) {
        if (!find(driver, xpathValue).isSelected()) {
            find(driver, xpathValue).click();
        }
    }

    protected String getElementText(WebDriver driver, String idValue) {
        return find(driver, idValue).getText();
    }

    protected void inputText(WebDriver driver, String idValue, String value){
        element = find(driver, idValue);
        element.clear();
        element.sendKeys(value);
    }

}
