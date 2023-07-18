package org.tms.api.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.tms.api.adapters.CaseAdapter;
import org.tms.api.models.Case;
import org.tms.utils.tools.TestDataGenerator;

@Story("Cases api tests")
public class CasesTest {
    private static final String PROJECT_CODE = "DEMO";
    private CaseAdapter caseAdapter = new CaseAdapter();
    private int caseId;

    @Test(description = "Verify that test case creation is successful")
    @Description("Verify that test case creation is successful")
    public void verifyCreateTestCaseSuccessTest() {
        Case testCase = Case.builder()
                .title(TestDataGenerator.createCaseTitle())
                .build();
        Response response = caseAdapter.createCase(PROJECT_CODE, testCase);
        caseId = response.body().path("result.id");
        boolean responseStatus = response.body().path("status");
        Assert.assertTrue(responseStatus, "POST /case/" + PROJECT_CODE + " failed!");
    }

    @Test(description = "Verify retrieval of created test case", dependsOnMethods = "verifyCreateTestCaseSuccessTest")
    @Description("Verify retrieval of created test case")
    public void verifyGetCreatedTestCaseTest() {
        boolean responseStatus = caseAdapter.getCaseById(PROJECT_CODE, caseId).body().path("status");
        Assert.assertTrue(responseStatus, String.format("GET /project/%s/%d failed!", PROJECT_CODE, caseId));
    }

    @Test(description = "Verify that test case deletion is successful", dependsOnMethods = "verifyGetCreatedTestCaseTest")
    @Description("Verify that test case deletion is successful")
    public void verifyDeleteTestCaseSuccessTest() {
        boolean responseStatus = caseAdapter.deleteCase(PROJECT_CODE, caseId).body().path("status");
        Assert.assertTrue(responseStatus, String.format("DELETE /project/%s/%d failed!", PROJECT_CODE, caseId));
    }
}
