package org.tms.ui.pages;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class SingleProjectPage extends BasePage {
    @FindBy(xpath = "//span[text() = 'Create new case']")
    private WebElement createNewCaseButton;

    public boolean isCreateNewCaseButtonDisplayed() {
        return waitVisibilityOf(createNewCaseButton).isDisplayed();
    }

}
