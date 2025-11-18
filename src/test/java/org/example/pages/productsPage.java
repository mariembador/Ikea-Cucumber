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

    @FindBy(xpath = "//span[@class=\"pip-header-section__title--big notranslate\"]")
    public WebElement productName;

    @FindBy(xpath = "//span[@class=\"pip-header-section__description-text\"]")
    public WebElement productDescription;

    @FindBy(xpath = "//span[@class=\"pip-price__integer\"]")
    public WebElement productPrice;

    @FindBy(xpath = "//div[@class=\"plp-product-list__products \"]/div")
    public List<WebElement> lampsProducts;

    @FindBy(xpath = "//a[@class=\"_productTitle_1e3w0_19 fav-link fav-link--black fav-link--subtle\"]")
    public WebElement favProductName;

    @FindBy(xpath = "//button[@data-testid=\"more-button\"]")
    public WebElement moreButton;

    @FindBy(xpath = "(//button[@class=\"fav-list-view-item__action\"])[2]")
    public WebElement removeItemButton;

    @FindBy(xpath = "//button[@class=\"fav-btn fav-btn--primary\"]")
    public WebElement removeButton;
}
