package org.tms.pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
@Log4j2
public class ProjectsPage extends BasePage {

    @FindBy(xpath = "//span[text() = 'Create new project']")
    private WebElement createNewProjectButton;
    @FindBy(xpath = "//input[@id='project-name']")
    private WebElement projectNameField;
    @FindBy(xpath = "//span[text() = 'Create project']")
    private WebElement createProjectButton;
    @FindBy(xpath = "//span[@aria-label = 'Chat']")
    private WebElement chatButton;
    @FindBy(xpath = "//iframe[@name='intercom-messenger-frame']")
    private WebElement chatFrame;
    @FindBy(xpath = "//button[@aria-label = 'Messages']")
    private WebElement chatMessagesButton;
    private List<ProjectsPagePanel> projectPanels;
//    @FindBy(xpath = "//a[@class='defect-title']")
//    private List<WebElement> projectButton;
//    @FindBy(xpath = "//a[@class='defect-title']/ancestor::td/following-sibling::td[5]/div/a")
//    private List<WebElement> projectMenuButton;
//    @FindBy(xpath = "//button[text() = 'Delete']")
//    private List<WebElement> deleteProjectButton;
//    private ProjectsPanel projectsPanel;
//
//    public ProjectsPanel getProjectsPanel() {
//        return projectsPanel;
//    }

//    private class ProjectsPanel {
//        private WebElement projectButton;
//        private WebElement projectMenuButton;
//        private WebElement deleteProjectButton;
//        private int projectIndex;
//
//        public ProjectsPanel(int projectIndex) {
//            this.projectButton = ProjectsPage.this.getProjectButton().get(projectIndex);
//            this.projectMenuButton = ProjectsPage.this.getProjectMenuButton().get(projectIndex);
//            this.deleteProjectButton = ProjectsPage.this.getDeleteProjectButton().get(projectIndex);
//            this.projectIndex = projectIndex;
//        }
//
//        public WebElement getProjectButton() {
//            return waitElementToBeClickable(projectButton);
//        }
//
//        public WebElement getProjectMenuButton() {
//            return waitElementToBeClickable(projectMenuButton);
//        }
//
//        public WebElement getDeleteProjectButton() {
//            return waitElementToBeClickable(deleteProjectButton);
//        }
//
//        public String getProjectName() {
//            return getProjectButton().getText();
//        }
//
//        public ProjectsPage clickDeleteProjectButton() {
//            getDeleteProjectButton().click();
//            return ProjectsPage.this;
//        }
////        public int getProjectIndex(String projectName) {
////            int index = 0;
////            for (WebElement button: this.getProjectButton()) {
////                if (button.getText().equals(projectName)) {
////                    return index;
////                }
////                index++;
////            }
////            return -1;
////        }
//    }

    public WebElement getCreateNewProjectButton() {
        return waitElementToBeClickable(createNewProjectButton);
    }

    public WebElement getProjectNameField() {
        return waitVisibilityOf(projectNameField);
    }

    public WebElement getCreateProjectButton() {
        return waitElementToBeClickable(createProjectButton);
    }

    public WebElement getChatButton() {
        return waitElementToBeClickable(chatButton);
    }

    public WebElement getChatMessagesButton() {
        driver.switchTo().frame(chatFrame);
        return waitElementToBeClickable(chatMessagesButton);
    }

//    public WebElement getProjectButton(int index) {
//        return waitElementToBeClickable(projectButton.get(index));
//    }
//
//    public List<WebElement> getProjectButton() {
//        return projectButton;
//    }
//
//    public List<WebElement> getProjectMenuButton() {
//        return projectMenuButton;
//    }
//
//    public List<WebElement> getDeleteProjectButton() {
//        return deleteProjectButton;
//    }

//    public String getProjectName(int index) {
//        return getProjectButton(index).getText();
//    }
//    public int getProjectIndex(String projectName) {
//        int index = 0;
//        for (WebElement button: this.getProjectButton()) {
//            if (button.getText().equals(projectName)) {
//                return index;
//            }
//            index++;
//        }
//        return -1;
//    }
}
