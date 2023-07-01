package org.tms.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.tms.api.adapters.ProjectAdapter;
import org.tms.api.adapters.SuiteAdapter;
import org.tms.api.models.Project;
import org.tms.api.models.Suite;
import org.tms.utils.tools.TestDataGenerator;

import static java.net.HttpURLConnection.HTTP_OK;

public class ProjectsTest {
    private String projectCode;
    @Test
    public void getProjectsTest() {
        int statusCode = new ProjectAdapter().getProjects().statusCode();
        Assert.assertEquals(statusCode, HTTP_OK, "GET /project return HTTP " + statusCode);
    }
    @Test
    public void createProjectTest() {
        projectCode = TestDataGenerator.createProjectCode();
        Project project = Project.builder()
                .title(TestDataGenerator.createProjectName())
                .code(projectCode)
                .build();
        String projectCodeFromResponse = new ProjectAdapter().createProject(project).body().path("result.code");
        Assert.assertEquals(projectCodeFromResponse, project.getCode(), "POST /project failed!");
    }

    @Test(dependsOnMethods = "createProjectTest")
    public void createSuiteTest() {
        Suite suite = Suite.builder()
                .title(TestDataGenerator.createSuiteTitle())
                .description(TestDataGenerator.createSuiteDescription())
                .build();
        boolean responseStatus = new SuiteAdapter().createSuite(projectCode, suite).body().path("status");
        Assert.assertTrue(responseStatus, "POST /suite/"+ projectCode + " failed!");
    }
}
