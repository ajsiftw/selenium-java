package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "classpath:features",
        glue = {"steps", "hooks"},
        monochrome = true,
        plugin = {"pretty", "html:output/reports/cucumber-testng-report.html"}
)
public class CucumberTestNGRunner extends AbstractTestNGCucumberTests {}