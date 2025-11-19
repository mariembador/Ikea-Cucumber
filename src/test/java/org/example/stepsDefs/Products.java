package org.example.stepsDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.productsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;
import java.util.stream.Collectors;

import static org.example.stepsDefs.Hooks.actions;

public class Products {

    productsPage products = new productsPage();

    WebElement lampsRandomProduct;
    WebElement randomProduct;

    String productLink;
    String productName;
    String productDescription;
    String productPrice;

    @When("Click on a random product displayed on the home page")
    public void clickOnARandomProductDisplayedOnTheHomePage() throws InterruptedException {
        List<WebElement> visibleProducts = products.allProducts.stream().filter(WebElement::isDisplayed).collect(Collectors.toList());
        randomProduct = visibleProducts.get(Hooks.random.nextInt(visibleProducts.size()));
        productLink = randomProduct.findElement(By.tagName("a")).getAttribute("href");
        productName = randomProduct.getDomAttribute("data-product-name");
        productDescription = randomProduct.findElement(By.xpath(".//span[@class=\"pip-text pip-typography-label-m pip-typography-regular pip-price-module__description\"]")).getText().split(",")[0];
        productPrice = randomProduct.findElement(By.xpath(".//span[@class=\"pip-price__integer\"]")).getText();
        randomProduct.click();
    }

    @Then("Verify that the product details page is opened")
    public void verifyThatTheProductDetailsPageIsOpened() {
        Hooks.soft.assertEquals(productLink,Hooks.driver.getCurrentUrl());
    }

    @And("Ensure that product details in the home page same as in the product page")
    public void ensureThatProductDetailsInTheHomePageSameAsInTheProductPage() {
        Hooks.soft.assertEquals(productName,products.productName.getText());
        Hooks.soft.assertTrue(productDescription.contains(products.productDescription.getText().split(",")[0]),"Product description isn't the same");
        Hooks.soft.assertEquals(productPrice,products.productPrice.getText());
    }

    @And("Click on Add to Bag button on a random product")
    public void clickOnAddToBagButtonOnARandomProduct() throws InterruptedException {
        lampsRandomProduct = products.lampsProducts.get(Hooks.random.nextInt(products.lampsProducts.size()));
        WebElement lampsAddToBagButton = lampsRandomProduct.findElement(By.xpath(".//a[@id=\"link-button-17575146242610\"]"));
        products.adCloseButton.click();
        Hooks.soft.assertTrue(lampsAddToBagButton.isEnabled(), "lamps add to bag button not enabled");
        Thread.sleep(1000);
        lampsAddToBagButton.click();
        Thread.sleep(1000);
    }
    @And("Click on the same product and add it to the bag")
    public void clickOnTheSameProductAndAddItToTheBag() {
        lampsRandomProduct.click();
        Hooks.soft.assertTrue(products.addToBagButton.isEnabled(), "add to bag button not enabled");
        products.addToBagButton.click();
        products.xButton.click();
    }

    @Then("Ensure that quantity displayed in the bag is two")
    public void ensureThatQuantityDisplayedInTheBagIsTwo() throws InterruptedException {
        actions.moveToLocation(0,200).perform();
        Hooks.soft.assertTrue(products.bagItemsCount.isDisplayed(), "items count not displayed");
        Thread.sleep(2000);
        Hooks.soft.assertEquals(Integer.parseInt(products.bagItemsCount.getText()),2);
    }

    @When("Add a random product to the favorite")
    public void addARandomProductToTheFavorite() {
        List<WebElement> visibleProducts = products.allProducts.stream().filter(WebElement::isDisplayed).collect(Collectors.toList());
        randomProduct = visibleProducts.get(Hooks.random.nextInt(visibleProducts.size()));
        productName = randomProduct.getDomAttribute("data-product-name");
        randomProduct.findElement(By.xpath(".//button[3]")).click();
    }

    @Then("Ensure the product displayed")
    public void ensureTheProductDisplayed() throws InterruptedException {
        Hooks.soft.assertTrue(Hooks.driver.getCurrentUrl().contains("https://www.ikea.com/eg/en/favourites/"), "Favorites page url not correct");
        Thread.sleep(500);
        Hooks.soft.assertEquals(productName,products.favProductName.getText());
    }

    @And("Remove the product from the favorite page")
    public void removeTheProductFromTheFavoritePage() throws InterruptedException {
        products.adCloseButton.click();
        Hooks.soft.assertTrue(products.moreButton.isEnabled(), "more button isn't enabled");
        products.moreButton.click();
        Hooks.soft.assertTrue(products.removeItemButton.isEnabled(), "remove item button isn't enabled");
        products.removeItemButton.click();
        Hooks.soft.assertTrue(products.removeButton.isEnabled(), "remove button isn't enabled");
        products.removeButton.click();
    }

    @When("Add a random product to the bag")
    public void addARandomProductToTheBag() throws InterruptedException {
        List<WebElement> visibleProducts = products.allProducts.stream().filter(WebElement::isDisplayed).filter(p -> {
                    String priceStr = p.getAttribute("data-price").replace(",", "");
                    return Double.parseDouble(priceStr) < 20000;
                }).collect(Collectors.toList());
        randomProduct = visibleProducts.get(Hooks.random.nextInt(visibleProducts.size()));
        randomProduct.findElement(By.xpath(".//button[1]")).click();
        Thread.sleep(500);
    }
}