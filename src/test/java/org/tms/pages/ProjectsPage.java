package org.tms.pages;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.tms.services.ProjectsPageService;
import org.tms.services.SingleProjectPageService;

@Getter
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
    public boolean isCreateNewProjectButtonDisplayed() {
        return getCreateNewProjectButton().isDisplayed();
    }
    public boolean isChatMessagesButtonDisplayed() {
        return getChatMessagesButton().isDisplayed();
    }
    public ProjectsPage clickCreateNewProjectButton() {
        getCreateNewProjectButton().click();
        return this;
    }
    public ProjectsPage clickChatButton() {
        getChatButton().click();
        return this;
    }
    public SingleProjectPage clickCreateProjectButton() {
        getCreateProjectButton().click();
        return new SingleProjectPage();
    }
    public ProjectsPage fillInProjectName(String projectName) {
        getProjectNameField().sendKeys(projectName);
        return this;
    }

}
