package org.tms.services;

import org.tms.pages.ProjectsPage;

public class ProjectsPageService {
    ProjectsPage projectsPage = new ProjectsPage();
    public boolean isCreateNewProjectButtonDisplayed() {
        return projectsPage.getCreateNewProjectButton().isDisplayed();
    }
}
