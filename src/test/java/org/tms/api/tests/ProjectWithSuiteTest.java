package org.tms.api.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.tms.api.adapters.ProjectAdapter;
import org.tms.api.adapters.SuiteAdapter;
import org.tms.api.models.Project;
import org.tms.api.models.Suite;
import org.tms.utils.tools.TestDataGenerator;

@Story("Project with suite api tests")
public class ProjectWithSuiteTest {
    private ProjectAdapter projectAdapter = new ProjectAdapter();
    private SuiteAdapter suiteAdapter = new SuiteAdapter();
    private String projectCode;
    private int suiteId;

    @Test(description = "Verify successful creation of a project")
    @Description("Verify successful creation of a project")
    public void verifyCreateProjectSuccessTest() {
        projectCode = TestDataGenerator.createProjectCode();
        Project project = Project.builder()
                .title(TestDataGenerator.createProjectName())
                .code(projectCode)
                .build();
        String projectCodeFromResponse = projectAdapter.createProject(project).body().path("result.code");
        Assert.assertEquals(projectCodeFromResponse, project.getCode(), "POST /project failed!");
    }

    @Test(description = "Verify successful creation of a test suite", dependsOnMethods = "verifyCreateProjectSuccessTest")
    @Description("Verify successful creation of a test suite")
    public void verifyCreateSuiteSuccessTest() {
        Suite suite = Suite.builder()
                .title(TestDataGenerator.createSuiteTitle())
                .description(TestDataGenerator.createSuiteDescription())
                .build();
        Response response = suiteAdapter.createSuite(projectCode, suite);

        suiteId = response.body().path("result.id");
        boolean responseStatus = response.body().path("status");

        Assert.assertTrue(responseStatus, "POST /suite/" + projectCode + " failed!");
    }

    @Test(description = "Verify successful deletion of a test suite", dependsOnMethods = "verifyCreateSuiteSuccessTest")
    @Description("Verify successful deletion of a test suite")
    public void verifyDeleteSuiteSuccessTest() {
        boolean responseStatus = suiteAdapter.deleteSuite(projectCode, suiteId).body().path("status");
        Assert.assertTrue(responseStatus, String.format("DELETE /suite/%s/%d failed!", projectCode, suiteId));
    }

    @Test(description = "verifyDeleteProjectSuccessTest", dependsOnMethods = "verifyCreateProjectSuccessTest", priority = 1)
    @Description("verifyDeleteProjectSuccessTest")
    public void verifyDeleteProjectSuccessTest() {
        boolean responseStatus = projectAdapter.deleteProject(projectCode).body().path("status");
        Assert.assertTrue(responseStatus, "DELETE /project/" + projectCode + " failed!");
    }
}
