package page_objects;

import models.User;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import page_objects.annotations.PageObject;

import javax.annotation.PostConstruct;

@PageObject
public class LoginPage extends AbstractPageObject{
    @FindBy(xpath = ".//*[@id='login_field']")
    private WebElement inputUsernameOrEmail;

    @FindBy(xpath = ".//*[@id='password']")
    private WebElement inputPassword;

    @FindBy(xpath = ".//input[@type='submit']")
    private WebElement buttonSignIn;

    @PostConstruct
    public void init() {
        PageFactory.initElements(driver, this);
    }

    public void loginAs(User user) {
        inputUsernameOrEmail.sendKeys(user.getUsername());
        inputPassword.sendKeys(user.getPassword());
        buttonSignIn.click();
    }
}
