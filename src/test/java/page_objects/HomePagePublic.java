/*
 */
package page_objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import page_objects.annotations.PageObject;

import javax.annotation.PostConstruct;

/**
 * PageObject for the main page of the site before user signed in.
 */

@PageObject
public class HomePagePublic extends AbstractPageObject {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Value("${site.url:localhost}")
    protected String siteUrl;

    @FindBy(xpath = ".//a[@href='/login']")
    private WebElement linkSignIn;

    @PostConstruct
    public void init() {
        PageFactory.initElements(driver, this);
    }

    public void open(){
        log.info("Open main page");
        driver.get(siteUrl);
        driver.manage().window().maximize();
    }

    public void clickSignIn(){
        linkSignIn.click();
    }


}
