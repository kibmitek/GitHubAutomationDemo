package page_objects.profile;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import page_objects.AbstractPageObject;
import page_objects.annotations.PageObject;

import javax.annotation.PostConstruct;

@PageObject
public class UserProfilePage extends AbstractPageObject {
    @FindBy(xpath = ".//*[@id='user_profile_name']")
    private WebElement inputName;

    @FindBy(xpath = ".//*[@id='user_profile_email']")
    private WebElement selectPublicEmail;

    @FindBy(xpath = ".//*[@id='user_profile_bio']")
    private WebElement inputBio;

    @FindBy(xpath = ".//*[@id='user_profile_blog']")
    private WebElement inputURL;

    @FindBy(xpath = ".//*[@id='user_profile_company']")
    private WebElement inputCompany;

    @FindBy(xpath = ".//*[@id='user_profile_location']")
    private WebElement inputLocation;

    @FindBy(xpath = ".//button[@type='submit' and text()='Update profile']")
    private WebElement buttonUpdateProfile;
    //TODO: others controls

    @FindBy(xpath = ".//*[@id='js-pjax-container']//*[contains(.,'Profile updated successfully')]")
    private WebElement alertSuccessUpdate;

    @PostConstruct
    public void init() {
        PageFactory.initElements(driver, this);
    }

    public void setCompany(String value){
        inputCompany.clear();
        inputCompany.sendKeys(value);
    }

    public String getCompanyValue(){
        init();
        return inputCompany.getAttribute("value");
    }

    public void clickUpdateProfile(){
        buttonUpdateProfile.click();
    }

    public boolean isSuccessAlertPresent() {
        return alertSuccessUpdate.isDisplayed();
    }

    //TODO: methods for other inputs
}
