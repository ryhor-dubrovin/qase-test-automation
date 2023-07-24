package org.tms.ui.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.tms.ui.model.User;
import org.tms.ui.services.LoginPageService;
import org.tms.ui.services.ProjectsPageService;
import org.tms.utils.tools.TestDataGenerator;

@Story("Project ui tests")
public class ProjectFunctionalityTest extends BaseTest {
    private static final String EMPTY_PROJECT_NAME = "";
    private String PROJECT_NAME = TestDataGenerator.createProjectName();
    private ProjectsPageService projectsPageService;

    @BeforeClass
    public void setUp() {
        LoginPageService loginPageService = new LoginPageService();
        projectsPageService = new ProjectsPageService();
        User user = new User(System.getProperty("email"), System.getProperty("password"));
        loginPageService
                .loginWithUser(user);
    }

    @Test(description = "Verify that a new project can be created")
    @Description("Verify that a new project can be created")
    public void verifyNewProjectCanBeCreatedTest() {
        boolean isCreateNewCaseButtonDisplayed = projectsPageService
                .createNewProject(PROJECT_NAME)
                .isCreateNewCaseButtonDisplayed();
        Assert.assertTrue(isCreateNewCaseButtonDisplayed,
                "Failed to create a new project!");
    }

    @Test(description = "Verify that project can be deleted", dependsOnMethods = "verifyNewProjectCanBeCreatedTest")
    @Description("Verify that project can be deleted")
    public void verifyProjectCanBeDeletedTest() {
        boolean isCreateNewProjectButtonDisplayed = projectsPageService
                .openPage()
                .deleteProject(projectsPageService.getProjectIndex(PROJECT_NAME))
                .isCreateNewProjectButtonDisplayed();
        Assert.assertTrue(isCreateNewProjectButtonDisplayed,
                "Failed to delete the project!");
    }

    @Test(description = "Verify that project can't be created without name", dependsOnMethods = "verifyProjectCanBeDeletedTest")
    @Description("Verify that project can't be created without name")
    public void verifyProjectCanNotBeCreatedWithNoNameTest() {
        projectsPageService
                .createNewProject(EMPTY_PROJECT_NAME);
        boolean isCreateProjectButtonDisplayed = projectsPageService
                .isCreateProjectButtonDisplayed();
        Assert.assertTrue(isCreateProjectButtonDisplayed,
                "Project created with no name!");
    }
}
