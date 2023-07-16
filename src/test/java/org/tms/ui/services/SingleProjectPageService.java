package org.tms.ui.services;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
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
                .fillInTitle(caseTitle)
                .clickSaveButton();
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

    @Step("")
    public SingleProjectPageService clickCaseButton(String caseTitle) {
        singleProjectPage.clickCaseButton(caseTitle);
        return this;
    }
}
