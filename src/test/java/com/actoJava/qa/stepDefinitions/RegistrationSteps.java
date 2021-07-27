package com.actoJava.qa.stepDefinitions;

import com.actoJava.qa.factory.DriverFactory;
import com.actoJava.qa.pages.LoginPage;
import com.actoJava.qa.pages.RegistrationPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class RegistrationSteps {

    private RegistrationPage registrationPage = new RegistrationPage(DriverFactory.getDriver());

    @Then("User Registration page is displayed")
    public void verifyUserRegistrationPageDisplayed() {
        Assert.assertTrue(registrationPage.isRegisterPageDisplayed(), "User Register Page is NOT displayed.");
    }

    @When("^User details of (.*), (.*), (.*) and (.*) are provided on Registration Page and clicked on Register Account Button$")
    public void registerUserWithValidDetails(String firstName, String lastName, String email, String pwd) {
        registrationPage.registerUser(firstName, lastName, email, pwd);
    }

    @Then("User is registered successfully")
    public void verifyUserIsRegisteredSuccessfully() {
        // on an actual application, you will write code here to verify the success message displayed after the registration is complete
        // in this dummy application, it simply navigates to login page when registration is successful
        LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
        Assert.assertTrue(loginPage.isLoginPageDisplayed(), "User is NOT registered successfully.");
    }

    @Then("User Registration is failed")
    public void verifyUserRegisterationFailed() {
        // on an actual application, you will write code here to verify the error message displayed after the registration is complete
        // in this dummy application, it simply navigates remains on the registration page
        Assert.assertTrue(registrationPage.isRegisterPageDisplayed(), "User got registered for invalid details.");
    }
}
