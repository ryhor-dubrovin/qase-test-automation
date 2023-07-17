package org.tms.ui.pages;

import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@Getter
public class SingleProjectPage extends BasePage {
    @FindBy(xpath = "//span[text() = 'Create new case']")
    private WebElement createNewCaseButton;
    @FindBy(xpath = "//span[text() = 'Create']")
    private WebElement createSuiteButton;
    @FindBy(xpath = "//a[@id='create-case-button']")
    private WebElement addCaseButton;
    @FindBy(xpath = "//a[@id='create-suite-button']")
    private WebElement addSuiteButton;
    @FindBy(xpath = "//div/a[contains(@href, '/case') and not(contains(@id, 'create-case-button'))]")
    private List<WebElement> casesButtons;
    @FindBy(xpath = "//button/span[contains(text(), 'Delete')]")
    private WebElement deleteCaseButton;
    @FindBy(xpath = "//button[@type = 'button']/span[contains(text(), 'Delete')]")
    private WebElement approveDeleteCaseButton;
    @FindBy(xpath = "//input[@id='title' and contains(@placeholder, 'For example')]")
    private WebElement suiteNameField;
    @FindBy(xpath = "//span[contains(text(), 'Test case was created')]")
    private WebElement caseCreationMessage;
    @FindBy(xpath = "//span[contains(text(), 'Test case') and contains(text(), 'deleted')]")
    private WebElement caseDeletionMessage;
    @FindBy(xpath = "//span[contains(text(), 'Suite was') and contains(text(), 'created')]")
    private WebElement suiteCreationMessage;


    @Step("Checking if the \"Create New Case\" button is displayed.")
    public boolean isCreateNewCaseButtonDisplayed() {
        return waitVisibilityOf(createNewCaseButton).isDisplayed();
    }

    @Step("Checking if the \"Test case was created\" message is displayed.")
    public boolean isCaseCreationMessageDisplayed() {
        return waitVisibilityOf(caseCreationMessage).isDisplayed();
    }

    @Step("Checking if the \"Suite was created\" message is displayed.")
    public boolean isSuiteCreationMessageDisplayed() {
        return waitVisibilityOf(suiteCreationMessage).isDisplayed();
    }

    @Step("Checking if the \"Test case was deleted\" message is displayed.")
    public boolean isCaseDeletionMessageDisplayed() {
        return waitVisibilityOf(caseDeletionMessage).isDisplayed();
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

    @Step("Clicking add suite button")
    public SingleProjectPage clickAddSuiteButton() {
        waitElementToBeClickable(addSuiteButton).click();
        return this;
    }

    @Step("Clicking create suite button")
    public SingleProjectPage clickCreateSuiteButton() {
        waitElementToBeClickable(createSuiteButton).click();
        return this;
    }

    @Step("")
    public SingleProjectPage clickCaseButton(String caseTitle) {
        waitElementToBeClickable(driver.findElement(By.xpath(String.format("//div[text() = '%s']", caseTitle)))).click();
        return this;
    }

    @Step("Clicking delete case button")
    public SingleProjectPage clickDeleteCaseButton() {
        waitElementToBeClickable(deleteCaseButton).click();
        return this;
    }

    @Step("Clicking delete case button")
    public SingleProjectPage clickApproveDeleteCaseButton() {
        waitElementToBeClickable(approveDeleteCaseButton).click();
        return this;
    }

    @Step("Filling in suite name")
    public SingleProjectPage fillInSuiteName(String suiteName) {
        waitVisibilityOf(suiteNameField).sendKeys(suiteName);
        return this;
    }

}
