package org.tms.api.tests;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.tms.api.adapters.DefectAdapter;
import org.tms.api.models.Defect;
import org.tms.utils.tools.TestDataGenerator;

import static org.tms.utils.constants.DefectSeverity.*;


public class DefectTest {
    private static final String PROJECT_NAME = "DEMO";
    private int defectId;
    private DefectAdapter defectAdapter;
    private Defect defect;

    @BeforeClass
    public void setUp() {
        defectAdapter = new DefectAdapter();
        defect = Defect.builder()
                .title(TestDataGenerator.createDefectTitle())
                .actualResult(TestDataGenerator.createDefectActualResult())
                .severity(BLOCKER_DEFECT_SEVERITY_INT)
                .build();
    }

    @Test
    public void verifyGetAllDefectsSuccessTest() {
        boolean responseStatus = defectAdapter.getDefects(PROJECT_NAME).body().path("status");
        Assert.assertTrue(responseStatus, "GET /defect/" + PROJECT_NAME + " failed!");
    }

    @Test
    public void verifyCreateDefectSuccessTest() {
        Response response = defectAdapter.createDefect(PROJECT_NAME, defect);
        boolean responseStatus = response.body().path("status");
        defectId = response.body().path("result.id");
        Assert.assertTrue(responseStatus, "POST /defect/" + PROJECT_NAME + " failed!");
    }

    @Test(dependsOnMethods = "verifyCreateDefectSuccessTest")
    public void verifyUpdateDefectSuccessTest() {
        defect.setSeverity(TRIVIAL_DEFECT_SEVERITY_INT);
        boolean responseStatus = defectAdapter.updateDefect(PROJECT_NAME, defectId, defect).body().path("status");
        Assert.assertTrue(responseStatus, String.format("PATCH /defect/%s/%d failed!", PROJECT_NAME, defectId));
    }

    @Test(dependsOnMethods = "verifyUpdateDefectSuccessTest")
    public void verifyGetDefectSuccessTest() {
        boolean responseStatus = defectAdapter.getDefect(PROJECT_NAME, defectId).body().path("status");
        Assert.assertTrue(responseStatus, String.format("GET /defect/%s/%d failed!", PROJECT_NAME, defectId));
    }

    @Test(dependsOnMethods = "verifyGetDefectSuccessTest")
    public void verifyDeleteDefectSuccessTest() {
        boolean responseStatus = defectAdapter.deleteDefect(PROJECT_NAME, defectId).body().path("status");
        Assert.assertTrue(responseStatus, String.format("DELETE /defect/%s/%d failed!", PROJECT_NAME, defectId));
    }
}
