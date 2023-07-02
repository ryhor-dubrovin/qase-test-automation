package org.tms.ui.services;

import org.openqa.selenium.WebElement;
import org.tms.ui.pages.ProjectsPage;

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

    public ProjectsPageService openPage() {
        projectsPage.openPage();
        return this;
    }
    public SingleProjectPageService createNewProject(String projectName) {
        projectsPage
                .clickCreateNewProjectButton()
                .fillInProjectNameField(projectName)
                .clickCreateProjectButton();
        return new SingleProjectPageService();
    }
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
    public ProjectsPageService deleteProject(int index) {
        projectsPage.getProjectMenuButtons().get(index).click();
        projectsPage.getProjectMenuDeleteButtons().get(index).click();
        projectsPage.getDeleteProjectButton().click();
        return this;
    }


    /*
    private int projectIndex;
    private ProjectsPagePanel projectsPagePanel = new ProjectsPagePanel(projectIndex);

    public String createNewProject() {
        String projectName = TestDataGenerator.getTestProjectName();
        projectsPage
                .clickCreateNewProjectButton()
                .fillInProjectNameField(projectName)
                .clickCreateProjectButton();
        return projectName;
    }

    public void deleteProject(int projectIndex) {
        projectsPage.getProjectsPanels().get(projectIndex).getProjectMenuButton().click();
        projectsPage.getProjectsPanels().get(projectIndex).getMenuDeleteButton().click();
        projectsPage.getProjectsPanels().get(projectIndex).getDeleteProjectButton().click();
    }

    public int getProjectIndexByName(String projectName) {
        int index = 0;
        for (WebElement button : projectsPage.getProjectButtons()) {
            if (button.getText().equals(projectName)) {
                return index;
            }
            index++;
        }
        return -1;
    }

     */

}
