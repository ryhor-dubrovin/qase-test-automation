package org.tms.ui.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.tms.ui.model.User;
import org.tms.ui.pages.SingleProjectPage;
import org.tms.ui.services.LoginPageService;
import org.tms.ui.services.ProjectsPageService;
import org.tms.ui.services.SingleProjectPageService;
import org.tms.utils.tools.TestDataGenerator;

@Story("Projects tests")
public class ProjectsPageTest extends BaseTest {
    private LoginPageService loginPageService;
    private static final String projectName = TestDataGenerator.createProjectName();
    @BeforeClass
    public void setUp() {
        loginPageService = new LoginPageService();
    }

    @Test(description = "Create new project")
    @Description("Create new project")
    public void createNewProjectTest() {
        User user = new User(System.getProperty("email"), System.getProperty("password"));
        SingleProjectPageService singleProjectPageService = loginPageService
                .loginWithUser(user)
                .createNewProject(projectName);
        boolean isCreateNewCaseButtonDisplayed = singleProjectPageService
                .isCreateNewCaseButtonDisplayed();
        Assert.assertTrue(isCreateNewCaseButtonDisplayed,
                "Failed to create new project!");
    }

    @Test(dependsOnMethods = "createNewProjectTest", description = "Delete the project")
    @Description("Delete the Project")
    public void deleteProjectTest() {
        ProjectsPageService projectsPageService = new ProjectsPageService();
        int projectIndex = projectsPageService
                .openPage()
                .getProjectIndex(projectName);
        projectsPageService.deleteProject(projectIndex);
        Assert.assertTrue(projectsPageService.isCreateNewProjectButtonDisplayed());
    }
}
