package org.tms.services;

import org.tms.pages.ProjectsPage;
import org.tms.utils.TestDataGenerator;

public class ProjectsPageService {
    private ProjectsPage projectsPage = new ProjectsPage();

    public boolean isCreateNewProjectButtonDisplayed() {
        return projectsPage.isCreateNewProjectButtonDisplayed();
    }
    public boolean isChatMessagesButtonDisplayed() {
        return projectsPage.isChatMessagesButtonDisplayed();
    }

    public ProjectsPageService clickChatButton() {
        projectsPage.clickChatButton();
        return this;
    }

    public SingleProjectPageService createNewProject() {
        projectsPage
                .clickCreateNewProjectButton()
                .fillInProjectNameField(TestDataGenerator.getTestProjectName())
                .clickCreateProjectButton();
        return new SingleProjectPageService();
    }

}
