package org.tms.api.tests;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.tms.api.adapters.CaseAdapter;
import org.tms.api.models.Case;
import org.tms.utils.tools.TestDataGenerator;

public class CasesTest {
    private static final String PROJECT_CODE = "DEMO";
    private static final int CASES_IN_PROJECT = 10;
    private int caseId;
    @Test(priority = -1)
    public void getCases() {
        int totalCases = new CaseAdapter().getCases(PROJECT_CODE).body().path("result.total");
        Assert.assertEquals(totalCases, CASES_IN_PROJECT, "Incorrect number of cases in DEMO project.");
    }

    @Test
    public void createCase() {
        Case testCase = Case.builder()
                .title(TestDataGenerator.createCaseTitle())
                .build();
        Response response = new CaseAdapter().createCase(PROJECT_CODE, testCase);
        caseId = response.body().path("result.id");
        boolean responseStatus = response.body().path("status");
        Assert.assertTrue(responseStatus, "POST /case/" + PROJECT_CODE + " failed!");
    }
    @Test(dependsOnMethods = "createCase")
    public void getCase() {
        boolean responseStatus = new CaseAdapter().getCaseById(PROJECT_CODE, caseId).body().path("status");
        Assert.assertTrue(responseStatus, "GET /project/" + PROJECT_CODE + "/" + caseId + " failed!");
    }
    @Test(dependsOnMethods = {"createCase", "getCase"})
    public void deleteCase() {
        boolean responseStatus = new CaseAdapter().deleteCase(PROJECT_CODE, caseId).body().path("status");
        Assert.assertTrue(responseStatus, "DELETE /project/" + PROJECT_CODE + "/" + caseId + " failed!");
    }
}
