package org.tms.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DistinctProjectPage extends BasePage {
    @FindBy(xpath = "//span[text() = 'Create new case']")
    private WebElement createNewCaseButton;

    public WebElement getCreateNewCaseButton() {
        return waitElementToBeClickable(createNewCaseButton);
    }
}
