package org.example.stepsDefs;

import com.github.javafaker.Faker;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.time.Duration;
import java.util.Random;

public class Hooks {
    public static WebDriver driver;
    public static SoftAssert soft = new SoftAssert();
    public static Faker fake = new Faker();
    public static Random random = new Random();
    public static WebDriverWait wait;
    public static Actions actions;


    @Before
    public void openBrowser() throws InterruptedException {
//        ChromeOptions options = new ChromeOptions();
//        options.addExtensions(new File("src/main/resources/AdBlock-—-block-ads-across-the-web-Chrome-Web-Store.crx"));
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        actions = new Actions(driver);

        driver.get("https://www.ikea.com/eg/en/");
    }
    @After
    public void quitBrowser(){
        Hooks.soft.assertAll();
        driver.quit();
    }
}
