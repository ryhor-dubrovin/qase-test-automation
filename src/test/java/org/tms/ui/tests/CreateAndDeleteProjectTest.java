package org.tms.ui.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.tms.ui.model.User;
import org.tms.ui.services.LoginPageService;
import org.tms.ui.services.ProjectsPageService;
import org.tms.ui.services.SingleProjectPageService;
import org.tms.utils.tools.TestDataGenerator;

@Story("Projects tests")
public class CreateAndDeleteProjectTest extends BaseTest {
    private static final String PROJECT_NAME = TestDataGenerator.createProjectName();
    private LoginPageService loginPageService;

    @BeforeClass
    public void setUp() {
        loginPageService = new LoginPageService();
    }

    @Test(description = "Verify new project can be created")
    @Description("Verify new project can be created")
    public void verifyNewProjectCanBeCreatedTest() {
        User user = new User(System.getProperty("email"), System.getProperty("password"));
        SingleProjectPageService singleProjectPageService = loginPageService
                .loginWithUser(user)
                .createNewProject(PROJECT_NAME);
        boolean isCreateNewCaseButtonDisplayed = singleProjectPageService
                .isCreateNewCaseButtonDisplayed();
        Assert.assertTrue(isCreateNewCaseButtonDisplayed,
                "Failed to create a new project!");
    }

    @Test(dependsOnMethods = "verifyNewProjectCanBeCreatedTest", description = "Verify project can be deleted")
    @Description("Verify project can be deleted")
    public void verifyProjectCanBeDeletedTest() {
        ProjectsPageService projectsPageService = new ProjectsPageService();
        int projectIndex = projectsPageService
                .openPage()
                .getProjectIndex(PROJECT_NAME);
        projectsPageService.deleteProject(projectIndex);
        Assert.assertTrue(projectsPageService.isCreateNewProjectButtonDisplayed(),
                "Failed to delete the project!");
    }
}
