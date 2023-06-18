package org.tms.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.tms.model.User;
import org.tms.pages.BasePage;
import org.tms.services.LoginPageService;
import org.tms.services.ProjectsPageService;

public class LoginPageTest extends BasePage {

    private LoginPageService loginPageService;
    @BeforeClass
    public void setUp() {
        loginPageService = new LoginPageService();
    }
    @Test
    public void loginWithUserTest() {
        User user = new User(System.getProperty("email"),System.getProperty("password"));
        ProjectsPageService projectsPageService = loginPageService.loginWithUser(user);
        Assert.assertTrue(projectsPageService.isCreateNewProjectButtonDisplayed(),
                "\"Create new project\" button does not displayed!");
    }
}
