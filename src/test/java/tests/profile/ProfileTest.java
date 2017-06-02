package tests.profile;

import configuration.AppConfig;
import models.User;
import org.assertj.core.api.SoftAssertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import page_objects.profile.UserProfilePage;
import steps.CommonStepDef;
import utils.DateTimeUtils;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
public class ProfileTest extends CommonStepDef{

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Value("${user.username:user}")
    private String username;
    @Value("${user.password:password}")
    private String password;

    @Autowired @Lazy
    UserProfilePage userProfilePage;

    @Test
    public void profileTest(){
        User user = new User(username,password);
        loginStepDef.loginAs(user);
        homePage.openProfileSettings();

        String newCompanyValue = DateTimeUtils.addTimeStampPostfix("EPAM_", "yyyyMMddHHmmss");
        userProfilePage.setCompany(newCompanyValue);
        userProfilePage.clickUpdateProfile();

        SoftAssertions softAssert = new SoftAssertions();
        softAssert.assertThat(userProfilePage.isSuccessAlertPresent()).as("Check that profile was updated").isTrue();
        softAssert.assertThat(userProfilePage.getCompanyValue()).isEqualTo(newCompanyValue);
        softAssert.assertAll();
    }
}
