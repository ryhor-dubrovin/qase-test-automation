package org.tms.tests;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.tms.model.User;
import org.tms.services.LoginPageService;
import org.tms.services.ProjectsPageService;
import org.tms.utils.TestDataGenerator;

public class ProjectsPageTest extends BaseTest {
    private LoginPageService loginPageService;
    private String newProjectName;

    @BeforeClass
    public void setUp() {
        loginPageService = new LoginPageService();
    }

    @Test
    public void createNewProjectTest() {
        User user = new User(System.getProperty("email"), System.getProperty("password"));
        ProjectsPageService projectsPageService = loginPageService.loginWithUser(user);
        newProjectName = TestDataGenerator.getTestProjectName();
        boolean isCreateNewCaseButtonDisplayed = projectsPageService
                .clickCreateNewProjectButton()
                .fillInProjectName(newProjectName)
                .clickCreateProjectButton()
                .isCreateNewCaseButtonDisplayed();
        Assert.assertTrue(isCreateNewCaseButtonDisplayed,
                "\"Create new case\" button does not displayed!");
    }

    @Test
    public void deleteCreatedProjectTest() {
        User user = new User(System.getProperty("email"), System.getProperty("password"));
        ProjectsPageService projectsPageService = loginPageService.loginWithUser(user);

    }
//    @Test
//    public void openChatTest() {
//        User user = new User(System.getProperty("email"), System.getProperty("password"));
//        ProjectsPageService projectsPageService = loginPageService.loginWithUser(user);
//        boolean isChatMessagesButtonDisplayed = projectsPageService
//                .clickChatButton()
//                .isChatMessagesButtonDisplayed();
//        Assert.assertTrue(isChatMessagesButtonDisplayed, "\"Messages\" button from chat does not displayed!");
//    }
}
