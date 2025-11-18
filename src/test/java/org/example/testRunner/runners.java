package org.example.testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/main/resources/Features",
        glue = "org/example/stepsDefs",
        tags = "",
        plugin = {
                "pretty",
                "html:target/report.html"
        }
)
public class runners extends AbstractTestNGCucumberTests {
}
