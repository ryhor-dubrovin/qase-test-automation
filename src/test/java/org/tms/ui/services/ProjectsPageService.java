package org.tms.ui.services;

import org.tms.ui.pages.ProjectsPage;
import org.tms.utils.tools.TestDataGenerator;

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
                .fillInProjectNameField(TestDataGenerator.createProjectName())
                .clickCreateProjectButton();
        return new SingleProjectPageService();
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
