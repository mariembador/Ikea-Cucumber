package org.example.pages;

import org.example.stepsDefs.Hooks;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class productsPage {
    public productsPage(){
        PageFactory.initElements(Hooks.driver, this);
    }

    @FindBy(xpath = "//button[@class=\"pip-btn pip-btn--emphasised pip-btn--fluid\"]")
    public WebElement addToBagButton;

    @FindBy(xpath = "//span[@class=\"hnf-header__cart-counter\"]")
    public WebElement bagItemsCount;

    @FindBy(xpath = "//div[@class=\"pip-product-compact\"]")
    public List<WebElement> allProducts;

    @FindBy(xpath = "//span[@class=\"pip-price-module__name-decorator notranslate\"]")
    public WebElement productName;

    @FindBy(xpath = "//span[@class=\"pip-text pip-typography-label-l pip-typography-regular pip-price-module__description\"]")
    public WebElement productDescription;

    @FindBy(xpath = "//span[@class=\"pip-price__integer\"]")
    public WebElement productPrice;

    @FindBy(xpath = "//div[@id=\"ins-wrap-layout-quadruple-16401899722640\"]")
    public List<WebElement> lampsProducts;

    @FindBy(xpath = "//a[@class=\"_productTitle_1510q_19 fav-link fav-link--black fav-link--subtle\"]")
    public WebElement favProductName;

    @FindBy(xpath = "//button[@data-testid=\"more-button\"]")
    public WebElement moreButton;

    @FindBy(xpath = "(//button[@class=\"fav-list-view-item__action\"])[2]")
    public WebElement removeItemButton;

    @FindBy(xpath = "//button[@class=\"fav-btn fav-btn--primary\"]")
    public WebElement removeButton;

    @FindBy(xpath = "//*[@id=\"close-button-1454703513202\"]/span")
    public WebElement adCloseButton;

    @FindBy(xpath = "//button[@aria-label=\"Close\"]")
    public WebElement xButton;
}
