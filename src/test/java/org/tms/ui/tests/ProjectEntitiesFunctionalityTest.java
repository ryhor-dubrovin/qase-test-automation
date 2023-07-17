package org.tms.ui.tests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.tms.ui.model.User;
import org.tms.ui.services.CasePageService;
import org.tms.ui.services.LoginPageService;
import org.tms.ui.services.ProjectsPageService;
import org.tms.ui.services.SingleProjectPageService;
import org.tms.utils.tools.TestDataGenerator;

public class ProjectEntitiesFunctionalityTest extends BaseTest {
    private static final String PROJECT_NAME = "Demo project";
    private static final String EMPTY_CASE_TITLE = "";
    private String suiteName = TestDataGenerator.createSuiteTitle();
    private String caseTitle;
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

    @Test(description = "Verify that new case can be created")
    @Description("Verify that new case can be created")
    public void verifyNewCaseCanBeCreatedTest() {
        caseTitle = TestDataGenerator.createCaseTitle();
        boolean isCaseCreated = singleProjectPageService
                .createCase(caseTitle)
                .isCaseCreationMessageDisplayed();
        Assert.assertTrue(isCaseCreated, "Failed to create new case!");
    }

    @Test(description = "Verify that case can be deleted", dependsOnMethods = "verifyNewCaseCanBeCreatedTest")
    @Description("Verify that case can be deleted")
    public void verifyCaseCanBeDeletedTest() {
        boolean isCaseDeleted = singleProjectPageService
                .deleteCase(caseTitle)
                .isCaseDeletionMessageDisplayed();
        Assert.assertTrue(isCaseDeleted, "Failed to delete case!");

    }

    @Test(description = "Verifying that suite can be created", dependsOnMethods = "verifyCaseCanBeDeletedTest")
    @Description("Verify that suite can be created")
    public void verifySuiteCanBeCreatedTest() {
        boolean isSuiteCreationMessageDisplayed = singleProjectPageService
                .createSuite(suiteName)
                .isSuiteCreationMessageDisplayed();
        Assert.assertTrue(isSuiteCreationMessageDisplayed, "Failed to create suite");
    }

    @Test(description = "Verify that case cannot be created without title", dependsOnMethods = "verifySuiteCanBeCreatedTest")
    @Description("Verify that case cannot be created without title")
    public void verifyCaseCanNotBeCreatedWithNoTitleTest() {
        singleProjectPageService
                .createCase(EMPTY_CASE_TITLE);
        boolean isSaveButtonDisplayed = casePageService
                .isSaveButtonDisplayed();
        Assert.assertTrue(isSaveButtonDisplayed, "Case created with no title!");
    }
}
