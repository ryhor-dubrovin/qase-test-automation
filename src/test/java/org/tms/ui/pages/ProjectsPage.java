package org.tms.ui.pages;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

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


    @FindBy(xpath = "//a[@class='defect-title']")
    private List<WebElement> projectButtons;
    @FindBy(xpath = "//a[@class='defect-title']/ancestor::td/following-sibling::td[5]/div/a")
    private List<WebElement> projectMenuButtons;
    @FindBy(xpath = "//button[text() = 'Delete']")
    private List<WebElement> projectMenuDeleteButtons;
    @FindBy(xpath = "//span[text() = 'Delete project']")
    private WebElement deleteProjectButton;


//    private List<ProjectsPagePanel> projectsPanels;

    public boolean isCreateNewProjectButtonDisplayed() {
        return waitVisibilityOf(createNewProjectButton).isDisplayed();
    }

    public boolean isChatMessagesButtonDisplayed() {
        driver.switchTo().frame(chatFrame);
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

//    public int getProjectIndexByName(String projectName) {
//        int index = 0;
//        for (WebElement button : this.getProjectButtons()) {
//            if (button.getText().equals(projectName)) {
//                return index;
//            }
//            index++;
//        }
//        return -1;
//    }

}
