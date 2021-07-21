package com.actoJava.qa.factory;

import com.actoJava.qa.util.WebDriverEventListenerImpl;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.Reporter;

import java.util.concurrent.TimeUnit;

public class DriverFactory {
    private static WebDriver driver;
    private static EventFiringWebDriver e_driver;
    private static WebDriverEventListenerImpl eventListener;

    public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

    public WebDriver initDriver(String browser) {

        browser = browser.toUpperCase();

        // use WebDriverManager to automatically setup driver of the browser
        WebDriverManager.getInstance(DriverManagerType.valueOf(browser)).setup();
        // launch appropriate browser
        switch (browser) {
            case "CHROME":
                tlDriver.set(new ChromeDriver());
                break;
            case "FIREFOX":
                tlDriver.set(new FirefoxDriver());
                break;
            case "SAFARI":
                tlDriver.set(new SafariDriver());
                break;
            case "EDGE":
                tlDriver.set(new EdgeDriver());
                break;
            case "OPERA":
                tlDriver.set(new OperaDriver());
                break;
            case "IEXPLORER":
                tlDriver.set(new InternetExplorerDriver());
                break;
        }
        Reporter.log("======Launch Browser======", true);

        // initiate Event Firing Driver so that it will capture all events
        // e_driver = new EventFiringWebDriver(tlDriver.get());

        // create an object of WebDriverEventListenerImpl class
        // the WebDriverEventListenerImpl class is an implementation class of Selenium's WebDriverEventListener interface
        // this class is created in the next step.
        /*eventListener = new WebDriverEventListenerImpl();

        e_driver.register((eventListener));
        driver = e_driver;

        // navigate to application and set the pace of script
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);*/
        getDriver().manage().deleteAllCookies();
        getDriver().manage().window().maximize();
        return getDriver();
    }

    public static synchronized WebDriver getDriver() {
        return tlDriver.get();
    }
}
