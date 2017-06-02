/*
 */
package steps;

import configuration.AppConfig;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import page_objects.*;

@ContextConfiguration(classes = {AppConfig.class})
@DirtiesContext
public class CommonStepDef {
    @Value("${site.url:localhost}")
    protected String siteUrl;

    @Autowired @Lazy
    public WebDriver driver;

    @Autowired @Lazy
    protected HomePagePublic homePagePublic;

    @Autowired @Lazy
    protected HomePage homePage;

    @Autowired @Lazy
    protected LoginPage loginPage;

    @Autowired @Lazy
    protected  LoginStepDef loginStepDef;

}
