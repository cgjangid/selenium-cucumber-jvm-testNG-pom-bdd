package com.actoJava.qa.stepDefinitions;

import com.actoJava.qa.factory.DriverFactory;
import com.actoJava.qa.pages.LoginPage;
import com.actoJava.qa.pages.UserRegisterPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class userRegistrationSteps {

    private UserRegisterPage userRegisterPage = new UserRegisterPage(DriverFactory.getDriver());

    @Then("User Registration page is displayed")
    public void verifyUserRegistrationPageDisplayed() {
        Assert.assertTrue(userRegisterPage.isRegisterPageDisplayed(), "User Register Page is NOT displayed");
    }

    @When("^Valid (.*), (.*), (.*) and (.*) details are provided on Registration Page and clicked on Register Account Button$")
    public void registerUserWithValidDetails(String firstName, String lastName, String email, String pwd) {
//        List<List<String>> users =  userDetails.
        userRegisterPage.registerUser(firstName, lastName, email, pwd);
    }

    @Then("User is registered successfully")
    public void verifyUserIsRegisteredSuccessfully() {
        // on an actual application, you will write code here to verify the success message displayed after the registration is complete
        // in this dummy application, it simply navigates to login page when registration is successful
        LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
        Assert.assertTrue(loginPage.isLoginPageDisplayed(), "User is NOT registered successfully");
    }
}
