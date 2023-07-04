package org.tms.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.tms.api.adapters.DefectAdapter;
import org.tms.api.models.Defect;

public class DefectTest {
    private static final String projectName = "DEMO";
    private int defectId;
    private Defect defect = Defect.builder()
            .title("Java defect")
            .actualResult("Actual result")
            .severity(3)
            .build();

    @Test
    public void getAllDefects() {
        boolean responseStatus = new DefectAdapter().getDefects(projectName).body().path("status");
        Assert.assertTrue(responseStatus, "GET /defect/" + projectName + " failed!");
    }
    @Test
    public void createDefectTest() {
        new DefectAdapter().createDefect(projectName,defect);
    }
    @Test
    public void updateDefectTest() {
        defect.setSeverity(6);
        new DefectAdapter().updateDefect(projectName,7,defect);
    }
    @Test
    public void getDefect() {
        new DefectAdapter().getDefect(projectName,7);
    }
    @Test
    public void deleteDefect() {
        new DefectAdapter().deleteDefect(projectName, 7);
    }
}
