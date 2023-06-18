package org.tms.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProjectsPage extends BasePage {
    @FindBy(xpath = "//h1")
    private WebElement pageNameSection;

    @FindBy(xpath = "//span[text() = 'Create new project']")
    private WebElement createNewProjectButton;

    public String getPageNameSectionText() {
        return waitVisibilityOf(pageNameSection).getText();
    }
    public WebElement getCreateNewProjectButton() {
        return waitElementToBeClickable(createNewProjectButton);
    }
}
