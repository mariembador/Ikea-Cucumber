package org.example.pages;

import org.example.stepsDefs.Hooks;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class registerPage {
    public registerPage(){
        PageFactory.initElements(Hooks.driver,this);
    }

    @FindBy(xpath = "//input[@id=\"login-email\"]")
    public WebElement loginEmail;

    @FindBy(xpath = "//input[@id=\"login-password\"]")
    public WebElement loginPassword;

    @FindBy(xpath = "//button[@data-testid=\"login\"]")
    public WebElement loginButton;

    @FindBy(xpath = "//button[@data-testid=\"create-account\"]")
    public WebElement createAccountButton;

    @FindBy(xpath = "//section[@class=\"grid_gridLeft__0Kzru\"]//h1")
    public WebElement createAccountPageTitle;

    @FindBy(xpath = "//input[@id=\"first-name\"]")
    public WebElement firstName;

    @FindBy(xpath = "//input[@id=\"last-name\"]")
    public WebElement lastName;

    @FindBy(xpath = "//input[@id=\"email\"]")
    public WebElement email;

    @FindBy(xpath = "//input[@id=\"password\"]")
    public WebElement password;

    @FindBy(xpath = "//input[@name=\"checkboxname\"]")
    public WebElement policyCheckbox;

    @FindBy(xpath = "//button[@data-testid=\"sign-up-create-account\"]")
    public WebElement signUpCreateAccountButton;

}