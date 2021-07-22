package com.actoJava.qa.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Reporter;

import java.util.concurrent.TimeUnit;

public class DriverFactory {

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

        getDriver().manage().deleteAllCookies();
        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
        getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        return getDriver();
    }

    public static synchronized WebDriver getDriver() {
        return tlDriver.get();
    }
}
