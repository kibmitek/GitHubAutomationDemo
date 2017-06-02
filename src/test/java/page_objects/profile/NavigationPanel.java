package page_objects.profile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import page_objects.AbstractPageObject;
import page_objects.annotations.PageObject;

import javax.annotation.PostConstruct;

@PageObject
public class NavigationPanel extends AbstractPageObject{
    @FindBy(xpath = ".//*[@id='js-pjax-container']//div[@role='navigation']")
    private WebElement panelNavigationPanel;

    @PostConstruct
    public void init() {
        PageFactory.initElements(driver, this);
    }

    public void clickNavigationPanelByName(String option){
        panelNavigationPanel.findElement(By.xpath(String.format(".//a[contains(.,'%s')]", option)));
    }
}
