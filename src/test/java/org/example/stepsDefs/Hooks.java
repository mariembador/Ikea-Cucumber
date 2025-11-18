package org.example.stepsDefs;

import com.github.javafaker.Faker;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Random;

public class Hooks {
    public static WebDriver driver;
    public static SoftAssert soft = new SoftAssert();
    public static Faker fake = new Faker();
    public static Random random = new Random();
    public static WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


    @Before
    public void openBrowser() throws InterruptedException {
        WebDriverManager.edgedriver().setup();
        EdgeOptions options = new EdgeOptions();
        options.addExtensions(new File("src/main/resources/AdBlock-—-block-ads-across-the-web-Chrome-Web-Store.crx"));
        driver = new EdgeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        Thread.sleep(4000);
        ArrayList<String> edgeTabs = new ArrayList<>(driver.getWindowHandles());
        System.out.println(edgeTabs);
        driver.switchTo().window(edgeTabs.get(1));
        driver.close();
        driver.switchTo().window(edgeTabs.get(0));

        driver.get("https://www.ikea.com/eg/en/");
    }
    @After
    public void quitBrowser(){
        Hooks.soft.assertAll();
        driver.quit();
    }
}
