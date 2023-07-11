package org.tms.api.tests;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.tms.api.adapters.ProjectAdapter;

import static java.net.HttpURLConnection.HTTP_OK;

public class ProjectsTest {
    private String projectCode;

    @Test
    public void verifyGetProjectsSuccessTest() {
        Response response = new ProjectAdapter().getProjects();
        int statusCode = response.statusCode();
        projectCode = response.body().path("result.entities[0].code");
        Assert.assertEquals(statusCode, HTTP_OK, "GET /project return HTTP " + statusCode);
    }

    @Test(dependsOnMethods = "verifyGetProjectsSuccessTest")
    public void verifyGetProjectByCodeSuccessTest() {
        boolean responseStatus = new ProjectAdapter().getProjectByCode(projectCode).body().path("status");
        Assert.assertTrue(responseStatus, "GET /project/" + projectCode + " failed!");
    }

}
