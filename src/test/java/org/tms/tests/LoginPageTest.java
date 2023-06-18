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
        String actualPageTextSectionText = projectsPageService.getPageNameSectionText();
        String expectedPageTextSectionText = "Projects";
        Assert.assertEquals(
                actualPageTextSectionText,
                expectedPageTextSectionText,
                "Actual text from page name section does not match expected!");
    }
}
