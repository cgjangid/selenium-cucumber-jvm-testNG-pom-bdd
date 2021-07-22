package com.actoJava.qa.stepDefinitions;

import com.actoJava.qa.factory.DriverFactory;
import com.actoJava.qa.pages.HomePage;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class HomePageSteps {

    private HomePage homePage = new HomePage(DriverFactory.getDriver());

    @Then("User is logged-in successfully")
    public void verifyUserIsLoggedInSuccessfully() {
        Assert.assertTrue(homePage.isHomePageDisplayed(), "User Login is NOT successful.");
    }

    @Then("Logged-in user name is displayed on Home Page")
    public void verifyLoggedInUserName() {
        String loggedInUserName = homePage.getLoggedInUserName();
        Assert.assertEquals(loggedInUserName, "Leonard Harper", "Logged-in user name is incorrect");
    }
}
