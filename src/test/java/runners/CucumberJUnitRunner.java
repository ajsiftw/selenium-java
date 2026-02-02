package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "classpath:features",
        glue = {"steps", "hooks"},
        monochrome = true,
        plugin = {"pretty", "html:output/reports/cucumber-junit-report.html"}
)

public class CucumberJUnitRunner {

}