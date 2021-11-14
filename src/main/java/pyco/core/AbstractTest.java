package pyco.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import pyco.dataProvider.PropertiesReader;

import java.net.MalformedURLException;
import java.net.URL;

public abstract class AbstractTest {
    private WebDriver driver;
    private URL url;
    public static String browserEnv = System.getProperty("browser");
    PropertiesReader propertiesReader = PropertiesReader.getInstance();

    protected WebDriver getDriver(String browserName){
        if(browserEnv!=null){
            browserName = browserEnv;
        }
        String site = propertiesReader.getValue("url");
        try {
            url = new URL(propertiesReader.getValue("server.test"));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        Browser browser = Browser.valueOf(browserName.toUpperCase());
        if(browser == Browser.CHROME){
            driver = new RemoteWebDriver(url, new ChromeOptions());
        }
        else if (browser == Browser.FIREFOX){
            driver = new RemoteWebDriver(url, new FirefoxOptions());
        }
        driver.manage().window().maximize();
        driver.get(site);
        return driver;
    }
}
