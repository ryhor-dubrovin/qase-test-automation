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
    private CaseAdapter caseAdapter = new CaseAdapter();

    @Test(priority = -1)
    public void verifyGetAllTestCasesCountTest() {
        int totalCases = caseAdapter.getCases(PROJECT_CODE).body().path("result.total");
        Assert.assertEquals(totalCases, CASES_IN_PROJECT, "Incorrect number of cases in DEMO project.");
    }

    @Test
    public void verifyCreateTestCaseSuccessTest() {
        Case testCase = Case.builder()
                .title(TestDataGenerator.createCaseTitle())
                .build();
        Response response = caseAdapter.createCase(PROJECT_CODE, testCase);
        caseId = response.body().path("result.id");
        boolean responseStatus = response.body().path("status");
        Assert.assertTrue(responseStatus, "POST /case/" + PROJECT_CODE + " failed!");
    }

    @Test(dependsOnMethods = "verifyCreateTestCaseSuccessTest")
    public void verifyGetCreatedTestCaseTest() {
        boolean responseStatus = caseAdapter.getCaseById(PROJECT_CODE, caseId).body().path("status");
        Assert.assertTrue(responseStatus, String.format("GET /project/%s/%d failed!", PROJECT_CODE, caseId));
    }

    @Test(dependsOnMethods = "verifyGetCreatedTestCaseTest")
    public void verifyDeleteTestCaseSuccessTest() {
        boolean responseStatus = caseAdapter.deleteCase(PROJECT_CODE, caseId).body().path("status");
        Assert.assertTrue(responseStatus, String.format("DELETE /project/%s/%d failed!", PROJECT_CODE, caseId));
    }
}
