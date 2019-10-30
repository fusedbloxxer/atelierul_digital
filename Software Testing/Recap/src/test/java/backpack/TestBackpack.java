package backpack;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
// TestBackpack is Stingleton, ceva legat de Scope ? Fresh beans.
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE,
        proxyMode = ScopedProxyMode.TARGET_CLASS)
public class TestBackpack {

    private String messageContent;
    private String email;
    private String registerToken;
    private String password;
    private String loginToken;

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    public String getRegisterToken() {
        return registerToken;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setRegisterToken(String token) {
        this.registerToken = token;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return this.password;
    }

    public void setLoginToken(String token) {
        this.loginToken = token;
    }

    public String getLoginToken() {
        return loginToken;
    }
}
