package org.tms.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProjectsPage extends BasePage {
    @FindBy(xpath = "//h1")
    private WebElement pageNameSection;

    public String getPageNameSectionText() {
        return waitVisibilityOf(pageNameSection).getText();
    }
}
