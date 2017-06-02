package tests.login;

import configuration.AppConfig;
import models.User;
import org.assertj.core.api.SoftAssertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import steps.CommonStepDef;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
public class LoginTest extends CommonStepDef{
    @Value("${user.username:user}")
    private String username;
    @Value("${user.password:password}")
    private String password;

    @Test
    public void loginTest(){
        User user = new User(username,password);
        loginStepDef.loginAs(user);
        SoftAssertions softAssert = new SoftAssertions();
        softAssert.assertThat(homePage.isPageOpened()).as("Check that home page is opened after login").isTrue();
        softAssert.assertAll();
    }

}
