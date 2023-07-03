package org.tms.api.adapters;

import io.restassured.response.Response;
import org.tms.api.models.Suite;

import static org.tms.utils.constants.Urls.SUITE_URI;

public class SuiteAdapter extends BaseAdapter {
    public Response createSuite(String projectCode, Suite suite) {
        return post(SUITE_URI + projectCode, gsonConverter.toJson(suite));
    }
    public Response deleteSuite(String projectCode,int suiteId) {
        String uri = projectCode + "/" + suiteId;
        return delete(SUITE_URI + uri);
    }
}
