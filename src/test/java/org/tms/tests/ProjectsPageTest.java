package org.tms.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.tms.model.User;
import org.tms.services.LoginPageService;
import org.tms.services.ProjectsPageService;
import org.tms.utils.TestDataGenerator;

public class ProjectsPageTest extends BaseTest {
    private LoginPageService loginPageService;

    @BeforeClass
    public void setUp() {
        loginPageService = new LoginPageService();
    }

    @Test
    public void createNewProjectTest() {
        User user = new User(System.getProperty("email"), System.getProperty("password"));
        ProjectsPageService projectsPageService = loginPageService.loginWithUser(user);
        boolean isCreateNewCaseButtonDisplayed = projectsPageService
                .clickCreateNewProjectButton()
                .fillInProjectName(TestDataGenerator.getTestProjectName())
                .clickCreateProjectButton()
                .isCreateNewCaseButtonDisplayed();
        Assert.assertTrue(isCreateNewCaseButtonDisplayed,
                "\"Create new case\" button does not displayed!");
    }
}
