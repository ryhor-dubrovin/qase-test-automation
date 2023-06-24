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
        return waitVisibilityOf(createNewProjectButton).isDisplayed();
    }
    public boolean isChatMessagesButtonDisplayed() {
        return waitVisibilityOf(chatMessagesButton).isDisplayed();
    }
    public ProjectsPage clickCreateNewProjectButton() {
        waitElementToBeClickable(createNewProjectButton).click();
        return this;
    }
    public ProjectsPage clickChatButton() {
        waitElementToBeClickable(chatButton).click();
        return this;
    }
    public void clickCreateProjectButton() {
        waitElementToBeClickable(createProjectButton).click();
//        return new SingleProjectPage();
    }
    public ProjectsPage fillInProjectNameField(String projectName) {
        waitVisibilityOf(projectNameField).sendKeys(projectName);
        return this;
    }

}
