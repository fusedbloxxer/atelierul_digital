package configuration;

import backpack.TestBackpack;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

import java.util.concurrent.TimeUnit;

@ComponentScan(basePackages = "backpack")
@Configuration // Specificia ca genereaza beans.
@PropertySource("classpath:automation.properties") // De unde sa preia valorile.
public class AutomationConfig {

    @Value("${browser.url}")
    private String url;

    @Bean
    @Lazy
    @Qualifier("chrome")
    public WebDriver getChromeDriver() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }

    @Bean
    @Lazy
    @Qualifier("firefox")
    public WebDriver getFirefoxDriver() {
        System.setProperty("webdriver.gecko.driver", "src/test/resources/driver/geckodriver.exe");
        FirefoxDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        return driver;
    }

    @Bean
    @Lazy
    @Qualifier("ie")
    public WebDriver getExplorerDriver() {
        System.setProperty("webdriver.ie.driver", "src/test/resources/driver/IEDriverServer_64.exe");
        InternetExplorerOptions options = new InternetExplorerOptions()
                .withInitialBrowserUrl(url);
        InternetExplorerDriver driver = new InternetExplorerDriver(options);
        driver.manage().window().maximize();
        return driver;
    }
}
