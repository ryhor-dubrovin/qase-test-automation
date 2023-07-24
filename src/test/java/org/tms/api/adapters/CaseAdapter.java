package org.tms.api.adapters;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.tms.api.models.Case;

import static org.tms.utils.constants.Urls.CASE_URI;

public class CaseAdapter extends BaseAdapter {

    @Step("Get a specific case by its ID")
    public Response getCaseById(String projectCode, int caseId) {
        return get(CASE_URI + projectCode + "/" + caseId);
    }

    @Step("Create a new case")
    public Response createCase(String projectCode, Case testCase) {
        return post(CASE_URI + projectCode, gsonConverter.toJson(testCase));
    }

    @Step("Delete a case")
    public Response deleteCase(String projectCode, int caseId) {
        return delete(CASE_URI + projectCode + "/" + caseId);
    }
}
