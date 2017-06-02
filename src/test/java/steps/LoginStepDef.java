package steps;

import models.User;
import org.assertj.core.api.SoftAssertions;
import org.springframework.stereotype.Component;

@Component
public class LoginStepDef extends CommonStepDef{
    public void loginAs(User user){
        homePagePublic.open();
        homePagePublic.clickSignIn();
        loginPage.loginAs(user);
    }

}
