package com.actoJava.qa.stepDefinitions.base;

import com.actoJava.qa.factory.DriverFactory;
import com.actoJava.qa.pages.HomePage;
import com.actoJava.qa.util.PropertyReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

public class BaseTest {

    // declaring all variables
    private WebDriver driver;
    private Properties prop;
    private DriverFactory driverFactory;
    private HomePage homePage;

    @Before
    public void setup() {
        // this method will run Before each Scenario we will have

        prop = PropertyReader.getAllProperties();
        driverFactory = new DriverFactory();

        driver = driverFactory.initDriver(prop.getProperty("browser"));
        driver.get(prop.getProperty("url"));
    }

    @After
    public void tearDown(Scenario scenario) {
        // this method will run After each Scenario we will have
        if (scenario.isFailed()) {
            // take screenshot:
            String screenshotName = scenario.getName().replaceAll(" ", "_");
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", screenshotName);
        }
        PropertyReader.cleanUp();
        driver.quit();
    }
}