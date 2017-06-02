package page_objects.repository;

import page_objects.AbstractPageObject;
import page_objects.annotations.PageObject;

@PageObject
public class RepositoryMainPage extends AbstractPageObject {
    public String getURL(){
        return driver.getCurrentUrl();
    }

}
