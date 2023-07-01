package org.tms.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.tms.api.adapters.ProjectAdapter;

import static java.net.HttpURLConnection.HTTP_OK;

public class ProjectsTest {
    @Test
    public void getProjectsTest() {
        int statusCode = new ProjectAdapter().getProjects().statusCode();
        Assert.assertEquals(statusCode, HTTP_OK, "GET /project return HTTP " + statusCode);
    }

}
