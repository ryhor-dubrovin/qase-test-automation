package org.tms.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
}
