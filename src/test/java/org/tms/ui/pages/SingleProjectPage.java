package org.tms.ui.pages;

import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@Getter
public class SingleProjectPage extends BasePage {
    @FindBy(xpath = "//span[text() = 'Create new case']")
    private WebElement createNewCaseButton;
    @FindBy(xpath = "//a[@id='create-case-button']")
    private WebElement addCaseButton;
    @FindBy(xpath = "//div/a[contains(@href, '/case') and not(contains(@id, 'create-case-button'))]")
    private List<WebElement> casesButtons;
    @FindBy(xpath = "//span[contains(text(), 'Test case was created')]")
    private WebElement caseCreationMessage;


    @Step("Checking if the \"Create New Case\" button is displayed.")
    public boolean isCreateNewCaseButtonDisplayed() {
        return waitVisibilityOf(createNewCaseButton).isDisplayed();
    }
    @Step("Checking if the \"Test case was created\" message is displayed.")
    public boolean isCaseCreationMessageDisplayed() {
        return waitVisibilityOf(caseCreationMessage).isDisplayed();
    }

    @Step("Opening the case")
    public SingleProjectPage openCase(int caseIndex) {
        waitElementToBeClickable(casesButtons.get(caseIndex)).click();
        return this;
    }

    @Step("Clicking add case button")
    public CasePage clickAddCaseButton() {
        waitElementToBeClickable(addCaseButton).click();
        return new CasePage();
    }
}
