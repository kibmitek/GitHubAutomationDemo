package tests.organization;

import configuration.AppConfig;
import models.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import page_objects.organization.CreateOrganizationPage;
import page_objects.organization.InviteOrganizationMembersPage;
import page_objects.profile.NavigationPanel;
import steps.CommonStepDef;
import utils.DateTimeUtils;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
public class OrganizationTest extends CommonStepDef {

    @Value("${user.username:user}")
    private String username;
    @Value("${user.password:password}")
    private String password;

    @Autowired @Lazy
    NavigationPanel navigationPanel;
    @Autowired @Lazy
    CreateOrganizationPage createOrganizationPage;
    @Autowired @Lazy
    InviteOrganizationMembersPage invitePage;

    @Test
    public void createNewOrganizationTest(){
        User user = new User(username,password);
        loginStepDef.loginAs(user);
        homePage.clickCreatNewOrganization();
        String organizationName = DateTimeUtils.addTimeStampPostfix("EPAM", "yyyyMMddHHmmss");
        createOrganizationPage.setOrganizationName(organizationName);
        String billingEmail = DateTimeUtils.addTimeStampPostfix("epam_mail_", "yyyyMMddHHmmss")+"@mail.ru";
        createOrganizationPage.setBillingEmail(billingEmail);
        createOrganizationPage.clickCreateOrganization();

        Assert.assertTrue(invitePage.getURL().endsWith("organizations/" + organizationName + "/invite"));
    }

}
