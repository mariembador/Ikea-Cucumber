package org.example.stepsDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.homePage;
import org.openqa.selenium.WebElement;

public class Home {

    homePage home = new homePage();
    @Given("Home page is visible successfully")
    public void homePageIsVisibleSuccessfully() throws InterruptedException {
        Hooks.soft.assertEquals(Hooks.driver.getCurrentUrl(), "https://www.ikea.com/eg/en/");
        Hooks.soft.assertEquals(home.homeTitle.getText(), "Welcome to IKEA Egypt");
        Thread.sleep(1000);
        home.cookiesButton.click();
    }

    @When("Click login button")
    public void clickLoginButton() throws InterruptedException {
        home.loginSignUpButton.click();
        Thread.sleep(500);
        Hooks.soft.assertEquals(home.loginText.getText(), "Log in to your account");
    }

    @Then("Verify that user logged in successfully")
    public void verifyThatUserLoggedInSuccessfully() throws InterruptedException {
        Thread.sleep(2000);
        Hooks.soft.assertTrue(home.profileName.getText().contains(Register.firstName), "user name is incorrect"+home.profileName.getText()+"expected" + Register.firstName);
    }

    @When("Enter a product keyword in the search bar")
    public void enterAProductKeywordInTheSearchBar() {
        home.searchField.sendKeys("desk");
    }

    @And("Click the search icon")
    public void clickTheSearchIcon() {
        Hooks.soft.assertTrue(home.searchButton.isEnabled());
        home.searchButton.click();
        Hooks.soft.assertEquals(Hooks.driver.getCurrentUrl(), "https://www.ikea.com/eg/en/search/?q=desk");
    }

    @Then("Ensure the products displayed related to the keyword")
    public void ensureTheProductsDisplayedRelatedToTheKeyword() {
        System.out.println(home.searchResults.size());
        for(WebElement result: home.searchResults){
            Hooks.soft.assertTrue(result.getText().toLowerCase().contains("desk")||result.getText().toLowerCase().contains("table")||result.getText().toLowerCase().contains("workstation"));
        }
    }

    @When("Click on a lighting category on the home page")
    public void clickOnALightingCategoryOnTheHomePage() {
        home.lightingCategory.click();
    }

    @And("Go to Lamps")
    public void goToLamps() {
        home.lamps.click();
        Hooks.soft.assertEquals(Hooks.driver.getCurrentUrl(), "https://www.ikea.com/eg/en/cat/lamps-li002/");
    }

    @And("Click on View button")
    public void clickOnViewButton() throws InterruptedException {
        Thread.sleep(1000);
        Hooks.soft.assertTrue(home.viewButton.isEnabled(), "view button isn't enabled");
        home.viewButton.click();
    }

    @Then("Delete account")
    public void deleteAccount() throws InterruptedException {
        Thread.sleep(4000);
        home.profileButton.click();
        home.deleteAccount.click();
        home.password.sendKeys(Register.password);
        home.deleteAccountButton.click();
    }
}
