package steps;

import configuration.AutomationConfig;
import org.springframework.test.context.ContextConfiguration;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;

// Cucumber-Junit poate seta configuratia clasei
// RunWith - Ce clasa sa foloseasca in spate
// CucumberOptions - Unde sa fie outputul testului, unde sunt features, unde e glue code
@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty", "json:target/cucumber.json"},
        features = "src/test/resources/features", glue = "src/test/java/steps")
// ContextConfiguration - face parte din Spring si mentioneaza ce clase pot genera beans.
@ContextConfiguration(classes = AutomationConfig.class)
public class TestRunner {
}
