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
public class UserLoginTest extends BaseTest {

    private LoginPageService loginPageService;

    @BeforeClass
    public void setUp() {
        loginPageService = new LoginPageService();
    }

    @Test(description = "Verify that login with valid user credentials is successful")
    @Description("Verify that login with valid user credentials is successful")
    public void verifyLoginWithUserIsSuccessfulTest() {
        User user = new User(System.getProperty("email"), System.getProperty("password"));
        ProjectsPageService projectsPageService = loginPageService.loginWithUser(user);
        Assert.assertTrue(projectsPageService.isCreateNewProjectButtonDisplayed(),
                "Failed to log in user!");
    }
}
