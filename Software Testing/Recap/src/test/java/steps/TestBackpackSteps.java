package steps;

import backpack.TestBackpack;
import io.cucumber.java.en.And;
import org.springframework.beans.factory.annotation.Autowired;

public class TestBackpackSteps {

    @Autowired
    private TestBackpack backpack;

    @And("I check TestBackpack for this message {string}")
    public void iCheckTestBackpackForThisMessage(String message) {
        if (!backpack.getMessageContent().equals(message)) {
            throw new RuntimeException("The backpack doesn't contain this message :(");
        }
    }
}
