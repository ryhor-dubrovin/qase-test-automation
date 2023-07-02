package org.tms.ui.pages;

import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class SingleProjectPage extends BasePage {
    @FindBy(xpath = "//span[text() = 'Create new case']")
    private WebElement createNewCaseButton;
    @FindBy(xpath = "//h1/text()[1]")
    private WebElement projectCode;

    @Step("Check is \"Create New Case\" button displayed")
    public boolean isCreateNewCaseButtonDisplayed() {
        return waitVisibilityOf(createNewCaseButton).isDisplayed();
    }

}
