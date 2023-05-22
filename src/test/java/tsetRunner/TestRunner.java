package tsetRunner;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Logger;
@RunWith(Cucumber.class)
@CucumberOptions(
        features = ".//Features/Customers.feature",
        glue="stepDefinitions",
        dryRun = false,
        monochrome = true,
       // tags = "@Test2",
        plugin = {"pretty","html:target-output"}
)
public class TestRunner {
}
