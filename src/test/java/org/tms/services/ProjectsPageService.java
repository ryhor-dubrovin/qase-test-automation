package org.tms.services;

import org.tms.pages.ProjectsPage;

public class ProjectsPageService {
    private ProjectsPage projectsPage = new ProjectsPage();

    public boolean isCreateNewProjectButtonDisplayed() {
        return projectsPage.isCreateNewProjectButtonDisplayed();
    }
    public boolean isChatMessagesButtonDisplayed() {
        return projectsPage.isChatMessagesButtonDisplayed();
    }

    public ProjectsPageService clickCreateNewProjectButton() {
        projectsPage.clickCreateNewProjectButton();
        return this;
    }
    public ProjectsPageService clickChatButton() {
        projectsPage.clickChatButton();
        return this;
    }

    public SingleProjectPageService clickCreateProjectButton() {
        projectsPage.clickCreateProjectButton();
        return new SingleProjectPageService();
    }

    public ProjectsPageService fillInProjectName(String projectName) {
        projectsPage.fillInProjectName(projectName);
        return this;
    }

}
