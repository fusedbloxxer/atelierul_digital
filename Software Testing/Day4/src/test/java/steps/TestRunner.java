package steps;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

// We need now to tell cucumber what it should do. Configure Cucumber.
// google cucumber options. Annotations are inherited.
@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty", "json:target/cucumber.json"}, features = "src/test/resources/features", glue = "steps")
public class TestRunner {
}
