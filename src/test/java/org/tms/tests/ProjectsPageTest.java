package org.tms.tests;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.tms.model.User;
import org.tms.pages.SingleProjectPage;
import org.tms.services.LoginPageService;
import org.tms.services.ProjectsPageService;
import org.tms.services.SingleProjectPageService;
import org.tms.utils.TestDataGenerator;

import static org.tms.constants.Urls.PROJECTS_PAGE;

public class ProjectsPageTest extends BaseTest {
    private LoginPageService loginPageService;

    @BeforeClass
    public void setUp() {
        loginPageService = new LoginPageService();
    }

//    @Test
//    public void createNewProjectTest() {
//        User user = new User(System.getProperty("email"), System.getProperty("password"));
//        ProjectsPageService projectsPageService = loginPageService.loginWithUser(user);
//        SingleProjectPageService singleProjectPageService = new SingleProjectPageService();
//        projectsPageService
//                .createNewProject();
//        Assert.assertTrue(singleProjectPageService.isCreateNewCaseButtonDisplayed(),
//                "Failed to create new project!");
//    }
//    @Test
//    public void createNewProjectTest() {
//        User user = new User(System.getProperty("email"), System.getProperty("password"));
//        ProjectsPageService projectsPageService = loginPageService.loginWithUser(user);
//        boolean isCreateNewCaseButtonDisplayed = projectsPageService
//                .createNewProject()
//                .isCreateNewCaseButtonDisplayed();
//        Assert.assertTrue(isCreateNewCaseButtonDisplayed,
//                "Failed to create new project!");
//    }
//    @Test
//    public void createAndDeleteProjectTest() {
//        User user = new User(System.getProperty("email"), System.getProperty("password"));
//        ProjectsPageService projectsPageService = loginPageService.loginWithUser(user);
//        projectsPageService.createNewProject();
//        driver.get(PROJECTS_PAGE);
//        projectsPageService.deleteProject(2);
//    }
    @Test
    public void openChatTest() {
        User user = new User(System.getProperty("email"), System.getProperty("password"));
        ProjectsPageService projectsPageService = loginPageService.loginWithUser(user);
        boolean isChatMessagesButtonDisplayed = projectsPageService
                .clickChatButton()
                .isChatMessagesButtonDisplayed();
        Assert.assertTrue(isChatMessagesButtonDisplayed, "Failed to load chat window!");
    }
}
