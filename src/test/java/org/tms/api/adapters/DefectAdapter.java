package org.tms.api.adapters;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.tms.api.models.Defect;

import static org.tms.utils.constants.Urls.DEFECT_URI;

public class DefectAdapter extends BaseAdapter {

    @Step("Get all defects")
    public Response getDefects(String projectCode) {
        return get(DEFECT_URI + projectCode);
    }

    @Step("Create a new defect")
    public Response createDefect(String projectCode, Defect defect) {
        return post(DEFECT_URI + projectCode, gsonConverter.toJson(defect));
    }

    @Step("Update a defect")
    public Response updateDefect(String projectCode, int defectId, Defect defect) {
        return patch(DEFECT_URI + projectCode + "/" + defectId, gsonConverter.toJson(defect));
    }

    @Step("Get a defect")
    public Response getDefect(String projectCode, int defectId) {
        return get(DEFECT_URI + projectCode + "/" + defectId);
    }

    @Step("Delete a defect")
    public Response deleteDefect(String projectCode, int defectId) {
        return delete(DEFECT_URI + projectCode + "/" + defectId);
    }
}
