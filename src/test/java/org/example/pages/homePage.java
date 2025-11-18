package org.example.pages;

import org.example.stepsDefs.Hooks;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class homePage {
    public homePage(){
        PageFactory.initElements(Hooks.driver,this);
    }

    @FindBy(xpath = "//button[@id=\"onetrust-accept-btn-handler\"]")
    public WebElement cookiesButton;

    @FindBy(xpath = "//h1[@class=\"pub__text pub__text--heading-m _title_oo8u2_122\"]")
    public WebElement homeTitle;

    @FindBy(xpath = "//div[@id=\"hnf-header-profile\"]")
    public WebElement loginSignUpButton;

    @FindBy(xpath = "//h2[@class=\"LoginPage_loginPageHeader__uqaHQ\"]")
    public WebElement loginText;

    @FindBy(xpath = "//a[@class=\"hnf-btn hnf-btn--small hnf-leading-icon hnf-btn--tertiary hnf-header__profile-link__avatar\"]")
    public WebElement profileButton;

    @FindBy(xpath = "(//span[@class=\"hnf-btn__label\"])[4]")
    public WebElement profileName;

    @FindBy(xpath = "//a[@href=\"https://www.ikea.com/eg/en/profile/delete-account/\"]")
    public WebElement deleteAccount;

    @FindBy(xpath = "//input[@type=\"password\"]")
    public WebElement password;

    @FindBy(xpath = "//button[@data-testid=\"delete-account\"]")
    public WebElement deleteAccountButton;

    @FindBy(xpath = "//input[@id=\"ikea-search-input\"]")
    public WebElement searchField;

    @FindBy(xpath = "//button[@type=\"submit\"]")
    public WebElement searchButton;

    @FindBy(xpath = "//div[@class=\"plp-product-list__products \"]//h3/span[@class=\"plp-price-module__description\"]")
    public List<WebElement> searchResults;

    @FindBy(xpath = "//div[@id=\"hnf-carousel__tabs-navigation-products\"]//span[text()=\"Lighting\"]")
    public WebElement lightingCategory;

    @FindBy(xpath = "//a[text()=\"Lamps\"]")
    public WebElement lamps;

    @FindBy(xpath = "//button[@class=\"hnf-btn hnf-btn--small hnf-btn--plain hnf-toast__action-message\"]")
    public WebElement viewButton;
}
