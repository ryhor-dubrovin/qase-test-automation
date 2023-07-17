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
    private static final String EMPTY_PROJECT_NAME = "";
    private LoginPageService loginPageService;
    private ProjectsPageService projectsPageService;

    @BeforeClass
    public void setUp() {
        loginPageService = new LoginPageService();
        projectsPageService = new ProjectsPageService();
        User user = new User(System.getProperty("email"), System.getProperty("password"));
        loginPageService
                .loginWithUser(user);
    }

    @Test(description = "Verify new project can be created")
    @Description("Verify new project can be created")
    public void verifyNewProjectCanBeCreatedTest() {
        boolean isCreateNewCaseButtonDisplayed = projectsPageService
                .createNewProject(PROJECT_NAME)
                .isCreateNewCaseButtonDisplayed();
        Assert.assertTrue(isCreateNewCaseButtonDisplayed,
                "Failed to create a new project!");
    }

    @Test(dependsOnMethods = "verifyNewProjectCanBeCreatedTest", description = "Verify project can be deleted")
    @Description("Verify project can be deleted")
    public void verifyProjectCanBeDeletedTest() {
        boolean isCreateNewProjectButtonDisplayed = projectsPageService
                .openPage()
                .deleteProject(projectsPageService.getProjectIndex(PROJECT_NAME))
                .isCreateNewProjectButtonDisplayed();
        Assert.assertTrue(isCreateNewProjectButtonDisplayed,
                "Failed to delete the project!");
    }

    @Test
    @Description("Verify project can not be created with no name")
    public void verifyProjectCanNotBeCreatedWithNoNameTest() {
        boolean isCreateNewCaseButtonDisplayed = projectsPageService
                .createNewProject(EMPTY_PROJECT_NAME)
                .isCreateNewCaseButtonDisplayed();
        Assert.assertFalse(isCreateNewCaseButtonDisplayed,
                "Project created with no name!");
    }
}
