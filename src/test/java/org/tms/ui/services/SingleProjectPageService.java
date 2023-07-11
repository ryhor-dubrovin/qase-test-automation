package org.tms.ui.services;

import io.qameta.allure.Step;
import org.tms.ui.pages.SingleProjectPage;

public class SingleProjectPageService {
    private SingleProjectPage singleProjectPage = new SingleProjectPage();

    @Step("Checking if the \"Create new case\" button is displayed.")
    public boolean isCreateNewCaseButtonDisplayed() {
        return singleProjectPage.isCreateNewCaseButtonDisplayed();
    }
}
