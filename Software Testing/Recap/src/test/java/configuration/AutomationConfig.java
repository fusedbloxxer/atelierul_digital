package configuration;

import backpack.TestBackpack;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.*;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.sql.DriverManager;
import java.util.concurrent.TimeUnit;

@EnableAutoConfiguration
@EnableJpaRepositories(basePackages = "database.repository")
@ComponentScan(basePackages = {"backpack", "steps", "database"})
@Configuration // Specificia ca genereaza beans.
@PropertySource("classpath:automation.properties") // De unde sa preia valorile.
@EntityScan(basePackages = "database.model")
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

    @Bean
    public DataSource getDataSource() {
        String url = "jdbc:mysql://localhost:3306/test";
        String username = "root";
        String password = "";
        return new DriverManagerDataSource(url, username, password);
    }

    @Bean
    public JdbcTemplate getTemplate(DataSource source) {
        return new JdbcTemplate(getDataSource());
    }
}
