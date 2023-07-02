package org.tms.ui.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.tms.ui.model.User;
import org.tms.ui.services.LoginPageService;
import org.tms.ui.services.ProjectsPageService;

@Story("Projects tests")
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
    @Test(description = "Create new project")
    @Description("Create new project")
    public void createNewProjectTest() {
        User user = new User(System.getProperty("email"), System.getProperty("password"));
        ProjectsPageService projectsPageService = loginPageService.loginWithUser(user);
        boolean isCreateNewCaseButtonDisplayed = projectsPageService
                .createNewProject()
                .isCreateNewCaseButtonDisplayed();
        Assert.assertTrue(isCreateNewCaseButtonDisplayed,
                "Failed to create new project!");
    }
//    @Test
//    public void createAndDeleteProjectTest() {
//        User user = new User(System.getProperty("email"), System.getProperty("password"));
//        ProjectsPageService projectsPageService = loginPageService.loginWithUser(user);
//        projectsPageService.createNewProject();
//        driver.get(PROJECTS_PAGE);
//        projectsPageService.deleteProject(2);
//    }
    @Test(description = "Open Chat")
    @Description("Open Chat")
    public void openChatTest() {
        User user = new User(System.getProperty("email"), System.getProperty("password"));
        ProjectsPageService projectsPageService = loginPageService.loginWithUser(user);
        boolean isChatMessagesButtonDisplayed = projectsPageService
                .clickChatButton()
                .isChatMessagesButtonDisplayed();
        Assert.assertTrue(isChatMessagesButtonDisplayed, "Failed to load chat window!");
    }
}
