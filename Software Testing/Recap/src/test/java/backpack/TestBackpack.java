package backpack;

import org.springframework.stereotype.Component;

@Component
public class TestBackpack {

    private String messageContent;

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }
}
