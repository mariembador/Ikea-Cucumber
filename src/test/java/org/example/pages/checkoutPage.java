package org.example.pages;

import org.example.stepsDefs.Hooks;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class checkoutPage {
    public checkoutPage(){
        PageFactory.initElements(Hooks.driver, this);
    }

    @FindBy(xpath = "//button[@data-testid=\"summary-checkout-button\"]")
    public WebElement checkOutButton;

    @FindBy(xpath = "//input[@data-val-required=\"Full name is required.\"]")
    public WebElement nameField;

    @FindBy(xpath = "//select[@id=\"NewAddress_AreaId\"]")
    public WebElement governorate;

    @FindBy(xpath = "//select[@id=\"NewAddress_CityAreaId\"]")
    public WebElement area;

    @FindBy(xpath = "//input[@id=\"NewAddress_Email\"]")
    public WebElement email;

    @FindBy(xpath = "//input[@id=\"NewAddress_PhoneNumber\"]")
    public WebElement phoneNumber;

    @FindBy(xpath = "//input[@id=\"NewAddress_Address1\"]")
    public WebElement address;

    @FindBy(xpath = "//input[@id=\"NewAddress_Address2\"]")
    public WebElement address2;

    @FindBy(xpath = "//button[@id=\"billingSubmitButton\"]")
    public WebElement continueButton;

    @FindBy(xpath = "//button[@id=\"deliveryAndAssemblyContinue\"]")
    public WebElement deliveryContinueButton;

    @FindBy(xpath = "//input[@value=\"cashondelivery\"]")
    public WebElement cashOnDeliveryOption;

    @FindBy(xpath = "//button[text()=\"Place order\"]")
    public WebElement placeOrderButton;

    @FindBy(xpath = "//div[@id=\"confirmCodOtp\"]")
    public WebElement otpMessage;
}
