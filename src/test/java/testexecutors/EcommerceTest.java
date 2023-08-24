package testexecutors;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/features", glue = "stepdefinition",
                 monochrome = true, plugin = "html:target/cucumber.html")
public class EcommerceTest extends AbstractTestNGCucumberTests {
}
