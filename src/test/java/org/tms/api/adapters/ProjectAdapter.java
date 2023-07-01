package org.tms.api.adapters;

import io.restassured.response.Response;

import static org.tms.utils.constants.Urls.PROJECT_URI;

public class ProjectAdapter extends BaseAdapter{
    public Response getProjects() {
        return get(PROJECT_URI);
    }
}
