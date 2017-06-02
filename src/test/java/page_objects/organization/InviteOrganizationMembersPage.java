package page_objects.organization;

import page_objects.AbstractPageObject;
import page_objects.annotations.PageObject;

@PageObject
public class InviteOrganizationMembersPage extends AbstractPageObject{
    public String getURL(){
        return driver.getCurrentUrl();
    }
}
