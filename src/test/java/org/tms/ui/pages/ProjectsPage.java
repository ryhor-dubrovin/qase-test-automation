package org.tms.ui.pages;

import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.tms.api.models.Project;
import org.tms.utils.constants.Urls;

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


    @Step("Opening the Projects Page.")
    public ProjectsPage openPage() {
        driver.get(Urls.PROJECTS_PAGE);
        return this;
    }
    @Step("Check if the \"Create New Project\" button is displayed.")
    public boolean isCreateNewProjectButtonDisplayed() {
        return waitVisibilityOf(createNewProjectButton).isDisplayed();
    }

    @Step("Checking if the chat \"Message\" button is displayed.")
    public boolean isChatMessagesButtonDisplayed() {
        driver.switchTo().frame(chatFrame);
        return waitVisibilityOf(chatMessagesButton).isDisplayed();
    }

    @Step("Clicking the \"Create New Project\" button.")
    public ProjectsPage clickCreateNewProjectButton() {
        waitElementToBeClickable(createNewProjectButton).click();
        return this;
    }

    @Step("Clicking the \"Chat\" button.")
    public ProjectsPage clickChatButton() {
        waitElementToBeClickable(chatButton).click();
        return this;
    }

    @Step("Clicking the \"Create Project\" button.")
    public void clickCreateProjectButton() {
        waitElementToBeClickable(createProjectButton).click();
//        return new SingleProjectPage();
    }

    @Step("Entering the \"Project name\".")
    public ProjectsPage fillInProjectNameField(String projectName) {
        waitVisibilityOf(projectNameField).sendKeys(projectName);
        return this;
    }
    @Step("Clicking the \"Menu\" button for the project.")
    public ProjectsPage clickProjectMenuButton(int index) {
        waitElementToBeClickable(projectMenuButtons.get(index)).click();
        return this;
    }
    @Step("Clicking the \"Delete\" button from the project menu.")
    public ProjectsPage clickProjectMenuDeleteButton(int index) {
        waitElementToBeClickable(projectMenuDeleteButtons.get(index)).click();
        return this;
    }
    @Step("Clicking the \"Delete\" project button.")
    public ProjectsPage clickDeleteProjectButton() {
        waitElementToBeClickable(getDeleteProjectButton()).click();
        return this;
    }

}
