package com.actoJava.qa.stepDefinitions;

import com.actoJava.qa.factory.DriverFactory;
import com.actoJava.qa.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class userLoginSteps {

    private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());

    @Given("Application Login page is displayed")
    public void applicationLoginPageIsDisplayed() {
        Assert.assertTrue(loginPage.isLoginPageDisplayed(), "Login Page is NOT displayed");
    }

    @When("You click on create account button")
    public void clickOnCreateAccountButton() {
        loginPage.navigateToRegisterPage();
    }

}