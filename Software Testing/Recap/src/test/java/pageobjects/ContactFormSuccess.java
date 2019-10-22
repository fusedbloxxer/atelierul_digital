package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactFormSuccess {

    @FindBy(xpath = "//div[@id='center_column']/p")
    private WebElement successMessage;

    public ContactFormSuccess(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void checkSuccessMessage(String success) {
        if (!success.equals(successMessage.getText())) {
            throw new RuntimeException("Success message is invalid.");
        }
    }

}
