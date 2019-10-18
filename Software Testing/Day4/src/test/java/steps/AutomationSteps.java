package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AutomationSteps extends TestRunner {
    // From selenium.
    public WebDriver driver;

    @Then("I go to {string}")
    public void iGoTo(String url) {
        driver.get(url);
    }

    @Given("I setup driver")
    public void iSetupDriver() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver.exe");
        // From selenium
        ChromeOptions chromeOptions = new ChromeOptions();
        driver = new ChromeDriver(chromeOptions);

        // Mai vezi optiuni la metodele driver.
        driver.manage().window().maximize();
    }
}
