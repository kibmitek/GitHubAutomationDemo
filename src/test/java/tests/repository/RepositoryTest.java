package tests.repository;

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
import page_objects.repository.CreateNewRepositoryPage;
import page_objects.repository.RepositoryMainPage;
import steps.CommonStepDef;
import utils.DateTimeUtils;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
public class RepositoryTest extends CommonStepDef {
    @Value("${user.username:user}")
    private String username;
    @Value("${user.password:password}")
    private String password;

    @Autowired @Lazy
    CreateNewRepositoryPage createNewRepositoryPage;
    @Autowired @Lazy
    RepositoryMainPage repositoryMainPage;

    @Test
    public void createRepositoryTest() {
        User user = new User(username, password);
        loginStepDef.loginAs(user);
        homePage.clickCreatNewRepository();
        String newRepoName = DateTimeUtils.addTimeStampPostfix("EPAM_demo_repo_", "yyyyMMddHHmmss");
        createNewRepositoryPage.setRepositoryName(newRepoName);
        createNewRepositoryPage.clickCreateRepository();
        Assert.assertTrue(repositoryMainPage.getURL().endsWith(newRepoName));
    }
}
