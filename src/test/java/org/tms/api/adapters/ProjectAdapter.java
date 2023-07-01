package org.tms.api.adapters;

import io.restassured.response.Response;
import org.tms.api.models.Project;

import static org.tms.utils.constants.Urls.PROJECT_URI;

public class ProjectAdapter extends BaseAdapter{
    public Response getProjects() {
        return get(PROJECT_URI);
    }

    public Response createProject(Project project){
        return post(PROJECT_URI, gsonConverter.toJson(project));
    }
}
