package org.tms.services;

import org.openqa.selenium.WebElement;
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
//
//    public SingleProjectPageService createNewProject() {
//        projectsPage
//                .clickCreateNewProjectButton()
//                .fillInProjectNameField(TestDataGenerator.getTestProjectName())
//                .clickCreateProjectButton();
//        return new SingleProjectPageService();
//    }
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

}
