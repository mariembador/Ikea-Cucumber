package org.example.stepsDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.example.pages.checkoutPage;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class Checkout {
    checkoutPage checkout = new checkoutPage();

    @And("Go to checkout & fill billing address fields")
    public void goToCheckoutFillBillingAddressFields() throws InterruptedException {
        checkout.checkOutButton.click();
        Thread.sleep(2000);

        checkout.nameField.sendKeys(Hooks.fake.name().fullName());

        Hooks.soft.assertTrue(checkout.governorate.isDisplayed());
        Select governorate = new Select(checkout.governorate);
        governorate.selectByIndex(Hooks.random.nextInt(governorate.getOptions().size()));
        Thread.sleep(3000);

        Hooks.soft.assertTrue(checkout.area.isDisplayed());
        Select area = new Select(checkout.area);
        area.selectByIndex(Hooks.random.nextInt(area.getOptions().size()));

        checkout.email.sendKeys(Hooks.fake.internet().emailAddress());
        checkout.phoneNumber.sendKeys(Hooks.fake.number().digits(11));
        checkout.address.sendKeys(Hooks.fake.address().fullAddress());
        checkout.address2.sendKeys(Hooks.fake.address().secondaryAddress());
        checkout.continueButton.click();
    }

    @And("Choose delivery date and time")
    public void chooseDeliveryDateAndTime() throws InterruptedException {
        Thread.sleep(8000);
        Actions action = new Actions(Hooks.driver);
        action.moveToElement(checkout.deliveryContinueButton).perform();
        Hooks.wait.until(ExpectedConditions.elementToBeClickable(checkout.deliveryContinueButton)).click();
    }

    @And("Choose payment method & place order")
    public void choosePaymentMethodPlaceOrder() throws InterruptedException {
        Thread.sleep(4000);
        checkout.cashOnDeliveryOption.click();
        Hooks.soft.assertTrue(checkout.placeOrderButton.isDisplayed());
        checkout.placeOrderButton.click();
    }

    @Then("Ensure OTP message displayed")
    public void ensureOTPMessageDisplayed() {
        Hooks.soft.assertTrue(checkout.otpMessage.isDisplayed());
    }
}
