package org.tms.ui.services;

import io.qameta.allure.Step;
import org.tms.ui.pages.SingleProjectPage;

public class SingleProjectPageService {
    private SingleProjectPage singleProjectPage = new SingleProjectPage();

    @Step("Checking if the \"Create new case\" button is displayed.")
    public boolean isCreateNewCaseButtonDisplayed() {
        return singleProjectPage.isCreateNewCaseButtonDisplayed();
    }

    @Step("Opening the case")
    public SingleProjectPageService openCase(int caseIndex) {
        singleProjectPage.openCase(caseIndex);
        return this;
    }

    @Step("Creating new case")
    public SingleProjectPageService createCase(String caseTitle) {
        singleProjectPage
                .clickAddCaseButton()
                .fillInCaseTitle(caseTitle)
                .clickSaveButton();
        return this;
    }

    @Step("Creating new suite")
    public SingleProjectPageService createSuite(String suiteName) {
        singleProjectPage
                .clickAddSuiteButton()
                .fillInSuiteName(suiteName)
                .clickCreateSuiteButton();
        return this;
    }

    @Step("Deleting case")
    public SingleProjectPageService deleteCase(String caseTitle) {
        singleProjectPage
                .clickCaseButton(caseTitle)
                .clickDeleteCaseButton()
                .clickApproveDeleteCaseButton();
        return this;
    }

    @Step("Checking if the \"Test case was created\" message is displayed.")
    public boolean isCaseCreationMessageDisplayed() {
        return singleProjectPage.isCaseCreationMessageDisplayed();
    }

    @Step("Checking if the \"Test case was deleted\" message is displayed.")
    public boolean isCaseDeletionMessageDisplayed() {
        return singleProjectPage.isCaseDeletionMessageDisplayed();
    }

    @Step("Checking if the \"Suite was created\" message is displayed.")
    public boolean isSuiteCreationMessageDisplayed() {
        return singleProjectPage.isSuiteCreationMessageDisplayed();
    }

    @Step("Click on the case button")
    public SingleProjectPageService clickCaseButton(String caseTitle) {
        singleProjectPage.clickCaseButton(caseTitle);
        return this;
    }
}
