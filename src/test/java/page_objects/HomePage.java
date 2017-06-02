package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import page_objects.annotations.PageObject;

import javax.annotation.PostConstruct;

/**
 * PageObject for home page for signed user
 */
@PageObject
public class HomePage extends AbstractPageObject {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @FindBy(xpath = ".//a[.='Gist' and @href='https://gist.github.com/']")
    private WebElement linkGist;

    @FindBy(xpath = ".//*[@id='user-links']//a[@aria-label='Create new…']")
    private WebElement linkCreateNew;

    @FindBy(xpath = ".//*[@id='user-links']//a[@aria-label='View profile and more']")
    private WebElement linkProfileMenu;

    @PostConstruct
    public void init() {
        PageFactory.initElements(driver, this);
    }

    public boolean isPageOpened() {
        if (!linkGist.isDisplayed()) {
            return false;
        }
        if (!linkCreateNew.isDisplayed()) {
            return false;
        }
        if (!linkProfileMenu.isDisplayed()) {
            return false;
        }
        //TODO: more checks if necessary
        return true;
    }

    public void openProfileSettings() {
        log.info("Open profile settings");
        linkProfileMenu.click();
        linkProfileMenu.findElement(By.xpath("./..//a[contains(.,'Settings')]")).click();
    }

    public void clickCreatNewRepository() {
        log.info("Create new repository");
        linkCreateNew.click();
        linkCreateNew.findElement(By.xpath("./..//a[contains(.,'New repository')]")).click();
    }

    public void clickCreatNewOrganization() {
        log.info("Create new organization");
        linkCreateNew.click();
        linkCreateNew.findElement(By.xpath("./..//a[contains(.,'New organization')]")).click();
    }
}
