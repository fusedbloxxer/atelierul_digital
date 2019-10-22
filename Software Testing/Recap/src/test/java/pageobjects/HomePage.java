package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class HomePage {

    @FindBy(xpath = "//div[@id='contact-link']/a")
    private WebElement contactUsButton;

    private WebDriver driver;

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public ContactForm clickContactUs() {
        contactUsButton.click();
        return new ContactForm(driver);
    }
}
