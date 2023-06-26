package org.tms.services;

import org.tms.pages.ProjectsPage;
import org.tms.pages.ProjectsPagePanel;
import org.tms.utils.TestDataGenerator;

public class ProjectsPageService {
    private int projectIndex;
    private ProjectsPage projectsPage = new ProjectsPage();
    private ProjectsPagePanel projectsPagePanel = new ProjectsPagePanel(projectIndex);

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
    public void deleteProject(int projectIndex) {
        this.projectIndex = projectIndex;
        projectsPagePanel.openProjectMenu().clickMenuDeleteButton().clickDeleteButton();
    }

}
