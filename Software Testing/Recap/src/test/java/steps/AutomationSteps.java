package steps;

import backpack.TestBackpack;
import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.test.context.ActiveProfiles;
import pageobjects.ContactForm;
import pageobjects.ContactFormSuccess;
import pageobjects.HomePage;
import testlink.TestLink;
import testlink.api.java.client.TestLinkAPIClient;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class AutomationSteps extends TestRunner {

    @Value("${browser.url}")
    private String url;

    @Autowired
    @Qualifier("chrome")
    private WebDriver driver;

    @Autowired
    private TestBackpack backpack;

    private static ContactForm contactForm;

    @Given("I access the website in automation.properties")
    public void iAccessWebsite() {
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @When("I click on Contact us")
    public void iClickOn() {
        HomePage homePage = new HomePage(driver);
        contactForm = homePage.clickContactUs();
    }

    @And("I select {string}")
    public void iSelect(String subjectHeading) {
        contactForm.selectSubjectHeading(subjectHeading);
    }


    @And("I enter an email address {string}")
    public void iEnterAnEmailAddress(String email) {
        contactForm.enterEmailAddress(email);
    }

    @And("I write a message {string}")
    public void iWriteAMessage(String message) {
        contactForm.enterMessage(message);
        backpack.setMessageContent(message);
    }

    @And("I click on button Send")
    public void iClickOnButton() {
        contactForm.submit();
    }

    @Then("I receive success message {string}")
    public void iReceiveMessage(String message) {
        ContactFormSuccess formSuccess = new ContactFormSuccess(driver);
        formSuccess.checkSuccessMessage(message);
    }

    @Then("I receive error message {string}")
    public void iReceiveErrorMessage(String error) {
        contactForm.checkErrorMessage(error);
    }

    @When("I search for {string}")
    public void iSearchFor(String item) {
        WebElement searchBox = driver.findElement(By.id("search_query_top"));
        searchBox.clear();
        searchBox.sendKeys(item);
        WebElement submitSearch = driver.findElement(By.xpath("//button[@type='submit']"));
        submitSearch.click();
    }

    @Then("I check that results have {string}")
    public void iCheckThatResultsHave(String searchedItem) {
        List<WebElement> searchResults = driver.findElements(By.xpath("//div[@class='product-container' //a[@class='product-name']"));
        List<String> productNames = searchResults.stream().map(WebElement::getText).collect(Collectors.toList());
        System.out.println(productNames);
        Assert.assertTrue(productNames.stream().allMatch(name -> name.toLowerCase().contains(searchedItem)));
    }

    @And("I quit the driver")
    public void iQuiteTheDriver() {
        driver.quit();
    }

    @io.cucumber.java.en.Given("I navigate to {string}")
    public void iNavigateTo(String link) {
        driver.get(link);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @io.cucumber.java.en.When("I click on contact link")
    public void iClickOnContactLink() {
        HomePage homePage = new HomePage(driver);
        contactForm = homePage.clickContactUs();
    }

    @io.cucumber.java.en.When("I complete contact details")
    public void iCompleteContactDetails() {
        contactForm.selectSubjectHeading("Customer service")
                .enterEmailAddress("test@test.com")
                .enterMessage("My Message");
    }

    @io.cucumber.java.en.Then("I submit contact form")
    public void iSubmitContactForm() {
        contactForm.submit();
    }

    @After("~@api")
    public void quit(Scenario scenario) {
        TestLink testLink = new TestLink().ping();
        if (scenario.getStatus().isOk(true)) {
            testLink.updateTest(TestLink.TEST_CASE_NAME, TestLinkAPIClient.TEST_PASSED);
        } else {
            testLink.updateTest(TestLink.TEST_CASE_NAME, TestLinkAPIClient.TEST_FAILED);
        }
        driver.quit();
    }
}
