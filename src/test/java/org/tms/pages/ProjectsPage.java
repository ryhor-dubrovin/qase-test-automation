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

    public WebElement getCreateNewProjectButton() {
        return waitElementToBeClickable(createNewProjectButton);
    }

    public WebElement getProjectNameField() {
        return waitVisibilityOf(projectNameField);
    }

    public WebElement getCreateProjectButton() {
        return waitElementToBeClickable(createProjectButton);
    }
}
