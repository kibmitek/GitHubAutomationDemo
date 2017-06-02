/*
 */
package configuration;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

import static javaslang.API.*;

import java.io.IOException;

public class WebdriverConfig {
    private final String CHROME = "Chrome";
    private final String FIREFOX = "Firefox";

    @Value("${webdriver.browser:Firefox}")
    private String browserName;


    @Bean(destroyMethod = "quit")
    public WebDriver webDriver() throws IOException {
        return Match(browserName).of(
                Case(CHROME::equalsIgnoreCase, this::initChrome),
                Case(FIREFOX::equalsIgnoreCase, this::initFirefox)
        );
    }

    private WebDriver initFirefox() {
        FirefoxDriverManager.getInstance().arch32().setup();
        return new FirefoxDriver();
    }

    private WebDriver initChrome() {
        ChromeDriverManager.getInstance().setup();
        return new ChromeDriver();
    }
}
