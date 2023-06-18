package org.tms.services;

import org.tms.pages.ProjectsPage;

public class ProjectsPageService {
    ProjectsPage projectsPage = new ProjectsPage();
    public boolean isCreateNewProjectButtonDisplayed() {
        return projectsPage.getCreateNewProjectButton().isDisplayed();
    }
    public ProjectsPageService clickCreateNewProjectButton() {
        projectsPage.getCreateNewProjectButton().click();
        return this;
    }
    public SingleProjectPageService clickCreateProjectButton() {
        projectsPage.getCreateProjectButton().click();
        return new SingleProjectPageService();
    }
    public ProjectsPageService fillInProjectName(String projectName) {
        projectsPage.getProjectNameField().sendKeys(projectName);
        return this;
    }

}
