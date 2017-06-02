package page_objects.repository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import page_objects.AbstractPageObject;
import page_objects.annotations.PageObject;

import javax.annotation.PostConstruct;

@PageObject
public class CreateNewRepositoryPage  extends AbstractPageObject {
    @FindBy(xpath = ".//*[@id='repository_name']")
    private WebElement inputRepositoryName;

    @FindBy(xpath = ".//*[@id='new_repository']//button[@type = 'submit' and contains(.,'Create repository')]")
    private WebElement buttonCreateRepository;

    @PostConstruct
    public void init() {
        PageFactory.initElements(driver, this);
    }

    public void setRepositoryName(String value){
        inputRepositoryName.sendKeys(value);
    }

    public void clickCreateRepository(){
        buttonCreateRepository.click();
    }
}
