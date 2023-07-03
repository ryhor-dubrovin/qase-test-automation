package org.tms.api.tests;

import org.testng.annotations.Test;
import org.tms.api.adapters.DefectAdapter;
import org.tms.api.models.Defect;

public class DefectTest {
    @Test
    public void getAllDefects() {
        new DefectAdapter().getDefects("DEMO");
    }
    @Test
    public void createDefectTest() {
        Defect defect = Defect.builder()
                .title("Java defect")
                .actualResult("Actual result")
                .severity(3)
                .build();
        new DefectAdapter().createDefect("DEMO",defect);
    }
    @Test
    public void updateDefectTest() {

    }
}
