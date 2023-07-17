package org.tms.ui.services;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.tms.ui.pages.ProjectsPage;

public class ProjectsPageService {

    private ProjectsPage projectsPage = new ProjectsPage();

    public boolean isCreateNewProjectButtonDisplayed() {
        return projectsPage.isCreateNewProjectButtonDisplayed();
    }

    public boolean isChatMessagesButtonDisplayed() {
        return projectsPage.isChatMessagesButtonDisplayed();
    }

    @Step("Opening the Project Page.")
    public ProjectsPageService openPage() {
        projectsPage.openPage();
        return this;
    }

    @Step("Clicking the Chat button.")
    public ProjectsPageService clickChatButton() {
        projectsPage.clickChatButton();
        return this;
    }

    @Step("Creating a new project.")
    public SingleProjectPageService createNewProject(String projectName) {
        projectsPage
                .clickCreateNewProjectButton()
                .fillInProjectNameField(projectName)
                .clickCreateProjectButton();
        return new SingleProjectPageService();
    }

    @Step("Getting the project index.")
    public int getProjectIndex(String projectName) {
        int index = 0;
        for (WebElement button : projectsPage.getProjectButtons()) {
            if (button.getText().equals(projectName)) {
                return index;
            }
            index++;
        }
        return -1;
    }
    @Step("Opening the project")
    public SingleProjectPageService openProject(int projectIndex) {
        projectsPage.openProject(projectIndex);
        return new SingleProjectPageService();
    }

    @Step("Deleting the project.")
    public ProjectsPageService deleteProject(int index) {
        projectsPage
                .clickProjectMenuButton(index)
                .clickProjectMenuDeleteButton(index)
                .clickDeleteProjectButton();
        return this;
    }

//    @Step("Checking if a project with the given name is displayed on the page.")
//    public boolean isProjectDisplayed(String projectName) {
//        return getProjectIndex(projectName) > 0;
//    }

    @Step("Check if the \"Create Project\" button is displayed.")
    public boolean isCreateProjectButtonDisplayed() {
        return projectsPage.isCreateProjectButtonDisplayed();
    }

}
