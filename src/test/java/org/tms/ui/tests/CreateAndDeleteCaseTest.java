package org.tms.ui.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.tms.ui.model.User;
import org.tms.ui.services.CasePageService;
import org.tms.ui.services.LoginPageService;
import org.tms.ui.services.ProjectsPageService;
import org.tms.ui.services.SingleProjectPageService;
import org.tms.utils.tools.TestDataGenerator;

public class CreateAndDeleteCaseTest extends BaseTest {
    private static final String PROJECT_NAME = "Demo project";
    private String caseTitle;
    private String emptyCaseTitle = "";
    private LoginPageService loginPageService;
    private ProjectsPageService projectsPageService;
    private SingleProjectPageService singleProjectPageService;
    private CasePageService casePageService;

    @BeforeClass
    public void setUp() {
        loginPageService = new LoginPageService();
        projectsPageService = new ProjectsPageService();
        singleProjectPageService = new SingleProjectPageService();
        casePageService = new CasePageService();
        User user = new User(System.getProperty("email"), System.getProperty("password"));
        loginPageService
                .loginWithUser(user)
                .openProject(projectsPageService.getProjectIndex(PROJECT_NAME));
    }

    @Test
    public void verifyNewCaseCanBeCreatedTest() {
        caseTitle = TestDataGenerator.createCaseTitle();
        boolean isCaseCreated = singleProjectPageService
                .createCase(caseTitle)
                .isCaseCreationMessageDisplayed();
        Assert.assertTrue(isCaseCreated, "Failed to create new case!");
    }

    @Test(dependsOnMethods = "verifyNewCaseCanBeCreatedTest")
    public void verifyCaseCanBeDeletedTest() {
        boolean isCaseDeleted = singleProjectPageService
                .deleteCase(caseTitle)
                .isCaseDeletionMessageDisplayed();
        Assert.assertTrue(isCaseDeleted, "Failed to delete case!");

    }

    @Test
    public void verifyCaseCanNotBeCreatedWithNoTitleTest() {
        singleProjectPageService
                .createCase(emptyCaseTitle);
        boolean isSaveButtonDisplayed = casePageService
                .isSaveButtonDisplayed();
        Assert.assertTrue(isSaveButtonDisplayed, "Case created with no title!");
    }
}
