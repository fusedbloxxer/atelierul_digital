package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ContactForm {

    @FindBy(id = "id_contact")
    private WebElement subjectHeading;

    @FindBy(id = "email")
    private WebElement emailAddress;

    @FindBy(id = "message")
    private WebElement messageTextBox;

    @FindBy(id = "submitMessage")
    private WebElement sendButton;

    @FindBy(xpath = "//div[@id='center_column']/div/ol/li")
    private WebElement errorMessage;

    public ContactForm(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public ContactForm selectSubjectHeading(String heading) {
        Select selection = new Select(subjectHeading);
        selection.selectByVisibleText(heading);
        return this;
    }

    public ContactForm enterEmailAddress(String email) {
        emailAddress.sendKeys(email);
        return this;
    }

    public ContactForm enterMessage(String message) {
        messageTextBox.sendKeys(message);
        return this;
    }

    public ContactForm submit() {
        sendButton.click();
        return this;
    }

    public void checkErrorMessage(String error) {
        if (!error.equals(errorMessage.getText())) {
            throw new RuntimeException("Error message is invalid.");
        }
    }
}
