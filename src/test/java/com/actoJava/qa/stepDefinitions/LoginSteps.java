package com.actoJava.qa.stepDefinitions;

import com.actoJava.qa.factory.DriverFactory;
import com.actoJava.qa.pages.HomePage;
import com.actoJava.qa.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class LoginSteps {

    private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());

    @Given("Application Login page is displayed")
    public void applicationLoginPageIsDisplayed() {
        Assert.assertTrue(loginPage.isLoginPageDisplayed(), "Login Page is NOT displayed.");
    }

    @When("You click on create account button")
    public void clickOnCreateAccountButton() {
        loginPage.navigateToRegisterPage();
    }

    @When("^You login with the valid user (.*) and valid password (.*)$")
    public void performLoginWithValidUser(String email, String pwd) {
        HomePage homePage = loginPage.loginToApplication(email, pwd);
    }

}