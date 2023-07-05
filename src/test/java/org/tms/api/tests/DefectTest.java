package org.tms.api.tests;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.tms.api.adapters.DefectAdapter;
import org.tms.api.models.Defect;
import org.tms.utils.tools.TestDataGenerator;

import static org.tms.utils.constants.DefectSeverity.*;


public class DefectTest {
    private static final String projectName = "DEMO";
    private int defectId;
    private DefectAdapter defectAdapter = new DefectAdapter();
    private Defect defect = Defect.builder()
            .title(TestDataGenerator.createDefectTitle())
            .actualResult(TestDataGenerator.createDefectActualResult())
            .severity(BLOCKER_DEFECT_SEVERITY_INT)
            .build();

    @Test
    public void getAllDefects() {
        boolean responseStatus = defectAdapter.getDefects(projectName).body().path("status");
        Assert.assertTrue(responseStatus, "GET /defect/" + projectName + " failed!");
    }

    @Test
    public void createDefectTest() {
        Response response = defectAdapter.createDefect(projectName, defect);
        boolean responseStatus = response.body().path("status");
        defectId = response.body().path("result.id");
        Assert.assertTrue(responseStatus, "POST /defect/" + projectName + " failed!");
    }

    @Test(dependsOnMethods = "createDefectTest")
    public void updateDefectTest() {
        defect.setSeverity(TRIVIAL_DEFECT_SEVERITY_INT);
        boolean responseStatus = defectAdapter.updateDefect(projectName, defectId, defect).body().path("status");
        Assert.assertTrue(responseStatus, String.format("PATCH /defect/%s/%d failed!", projectName, defectId));
    }

    @Test(dependsOnMethods = "updateDefectTest")
    public void getDefect() {
        boolean responseStatus = defectAdapter.getDefect(projectName, defectId).body().path("status");
        Assert.assertTrue(responseStatus, String.format("GET /defect/%s/%d failed!", projectName, defectId));
    }

    @Test(dependsOnMethods = "getDefect")
    public void deleteDefect() {
        boolean responseStatus = defectAdapter.deleteDefect(projectName, defectId).body().path("status");
        Assert.assertTrue(responseStatus, String.format("DELETE /defect/%s/%d failed!", projectName, defectId));
    }
}
