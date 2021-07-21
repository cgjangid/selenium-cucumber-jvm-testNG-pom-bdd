package com.actoJava.qa.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    // object repository for login page
    @FindBy(xpath = "/html/body/div/div/div/div/div/div/div[2]/div/div[1]/h1")
    WebElement loginPageGreet;

    @FindBy(xpath = "/html/body/div/div/div/div/div/div/div[2]/div/div[3]/a")
    WebElement createAccountLink;

    @FindBy(xpath = "//*[@id=\"exampleInputEmail\"]")
    WebElement emailLoginField;

    @FindBy(id = "exampleInputPassword")
    WebElement passwordLoginField;

    @FindBy(className = "btn-primary")
    WebElement loginPrimaryButton;

    private WebDriver driver;

    // constructor with PageFactory to initiate all the page objects
    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    // actions or functions on the Login Page
    public boolean isLoginPageDisplayed() {
        try {
            return loginPageGreet.isDisplayed();
        } catch (NoSuchElementException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    // function for logging in to application which will return a Home Page
    public HomePage loginToApplication(String email, String pwd) {
        emailLoginField.sendKeys(email);
        passwordLoginField.sendKeys(pwd);
        loginPrimaryButton.click();
        return new HomePage(driver);
    }

    // function to navigate to User Register Page which will return a Register Page
    public UserRegisterPage navigateToRegisterPage() {
        createAccountLink.click();
        return new UserRegisterPage(driver);
    }
}
