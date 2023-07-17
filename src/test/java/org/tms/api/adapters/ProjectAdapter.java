package org.tms.api.adapters;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.tms.api.models.Project;

import static org.tms.utils.constants.Urls.PROJECT_URI;

public class ProjectAdapter extends BaseAdapter {
    @Step("Get all projects")
    public Response getProjects() {
        return get(PROJECT_URI);
    }

    @Step("Get a project by its code")
    public Response getProjectByCode(String projectCode) {
        return get(PROJECT_URI + projectCode);
    }

    @Step("Create a new project")
    public Response createProject(Project project) {
        return post(PROJECT_URI, gsonConverter.toJson(project));
    }

    @Step("Delete a project")
    public Response deleteProject(String projectCode) {
        return delete(PROJECT_URI + projectCode);
    }
}
