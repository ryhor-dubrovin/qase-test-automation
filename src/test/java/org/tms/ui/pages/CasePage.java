package org.tms.ui.pages;

import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class CasePage extends BasePage {
    @FindBy(xpath = "//input[@id='title']")
    private WebElement titleField;
    @FindBy(xpath = "//button/span[text() = 'Save']")
    private WebElement saveButton;

    @Step("Fill in the case title")
    public CasePage fillInCaseTitle(String caseTitle) {
        waitVisibilityOf(titleField).sendKeys(caseTitle);
        return this;
    }

    @Step("Click on the Save button")
    public SingleProjectPage clickSaveButton() {
        waitElementToBeClickable(saveButton).click();
        return new SingleProjectPage();
    }

    @Step("Check if the Save button is displayed")
    public boolean isSaveButtonDisplayed() {
        return waitVisibilityOf(saveButton).isDisplayed();
    }
}
