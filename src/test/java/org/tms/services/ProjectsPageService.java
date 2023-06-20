package org.tms.services;

import org.openqa.selenium.WebElement;
import org.tms.pages.ProjectsPage;

public class ProjectsPageService {
    ProjectsPage projectsPage = new ProjectsPage();
    

    public boolean isCreateNewProjectButtonDisplayed() {
        return projectsPage.getCreateNewProjectButton().isDisplayed();
    }
    public boolean isChatMessagesButtonDisplayed() {
        return projectsPage.getChatMessagesButton().isDisplayed();
    }

    public ProjectsPageService clickCreateNewProjectButton() {
        projectsPage.getCreateNewProjectButton().click();
        return this;
    }
    public ProjectsPageService clickChatButton() {
        projectsPage.getChatButton().click();
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

    public ProjectsPageService deleteProject(String projectName) {
        
        projectsPage.getProjectsPanel().getDeleteProjectButton();
        return this;
    }

}
