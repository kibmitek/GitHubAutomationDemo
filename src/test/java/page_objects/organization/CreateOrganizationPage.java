package page_objects.organization;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import page_objects.AbstractPageObject;
import page_objects.annotations.PageObject;

import javax.annotation.PostConstruct;

@PageObject
public class CreateOrganizationPage extends AbstractPageObject {
    @FindBy(xpath = ".//*[@id='organization_login']")
    private WebElement inputOrganizationName;

    @FindBy(xpath = ".//*[@id='organization_billing_email']")
    private WebElement inputBillingEmail;

    @FindBy(xpath = ".//*[@id='new-organization']//button[@type='submit']")
    private WebElement buttonCreateOrganization;

    @PostConstruct
    public void init() {
        PageFactory.initElements(driver, this);
    }

    public void setOrganizationName(String value){
        inputOrganizationName.sendKeys(value);
    }
    public void setBillingEmail(String value){
        inputBillingEmail.sendKeys(value);
    }
    public void clickCreateOrganization(){
        buttonCreateOrganization.click();
    }

}
