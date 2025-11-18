package org.example.stepsDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.registerPage;

public class Register {

    registerPage register = new registerPage();

    public static String firstName;
    public static String lastName;
    public static String email;
    public static String password;


    @When("Navigate to the Create Account page")
    public void navigateToTheCreateAccountPage() throws InterruptedException {
        register.createAccountButton.click();
        Thread.sleep(500);
        Hooks.soft.assertEquals(register.createAccountPageTitle.getText(), "Create an IKEA account");
    }

    @And("Enter valid data")
    public void enterValidData() {
        firstName = Hooks.fake.name().firstName();
        lastName = Hooks.fake.name().lastName();
        email = Hooks.fake.internet().emailAddress();
        password = Hooks.fake.internet().password(8,20,true,true,true);
        System.out.println(email);
        System.out.println(password);

        register.firstName.sendKeys(firstName);
        Hooks.soft.assertEquals(register.firstName.getDomAttribute("value"), firstName);
        register.lastName.sendKeys(lastName);
        Hooks.soft.assertEquals(register.lastName.getDomAttribute("value"), lastName);
        register.email.sendKeys(email);
        Hooks.soft.assertEquals(register.email.getDomAttribute("value"), email);
        register.password.sendKeys(password);
        register.policyCheckbox.click();
        Hooks.soft.assertTrue(register.policyCheckbox.isSelected());
    }

    @And("Click on Register button")
    public void clickOnRegisterButton() throws InterruptedException {
        Hooks.soft.assertTrue(register.signUpCreateAccountButton.isEnabled());
        register.signUpCreateAccountButton.click();
        Thread.sleep(2000);
        Hooks.soft.assertEquals(Hooks.driver.getCurrentUrl(), "https://www.ikea.com/eg/en/profile/");
    }

    @And("Enter valid email and password")
    public void enterValidEmailAndPassword() {
        register.loginEmail.sendKeys(Register.email);
        Hooks.soft.assertEquals(register.loginEmail.getDomAttribute("value"), Register.email);
        register.loginPassword.sendKeys(Register.password);
    }

    @And("Click on Login button")
    public void clickOnLoginButton() throws InterruptedException {
        Hooks.soft.assertTrue(register.loginButton.isEnabled());
        register.loginButton.click();
        Thread.sleep(1000);
        Hooks.soft.assertEquals(Hooks.driver.getCurrentUrl(), "https://www.ikea.com/eg/en/");
    }
}