package org.tms.ui.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.tms.ui.model.User;
import org.tms.ui.services.LoginPageService;
import org.tms.ui.services.ProjectsPageService;

@Story("Login tests")
public class LoginPageTest extends BaseTest {

    private LoginPageService loginPageService;

    @BeforeClass
    public void setUp() {
        loginPageService = new LoginPageService();
    }

    @Test(description = "Login with user")
    @Description("Login with user")
    public void loginWithUserTest() {
        User user = new User(System.getProperty("email"), System.getProperty("password"));
        ProjectsPageService projectsPageService = loginPageService.loginWithUser(user);
        Assert.assertTrue(projectsPageService.isCreateNewProjectButtonDisplayed(),
                "\"Create new project\" button does not displayed!");
    }
}
