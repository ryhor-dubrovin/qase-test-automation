package org.tms.ui.services;

import org.tms.ui.pages.SingleProjectPage;

public class SingleProjectPageService {
    private SingleProjectPage singleProjectPage = new SingleProjectPage();

    public boolean isCreateNewCaseButtonDisplayed() {
        return singleProjectPage.isCreateNewCaseButtonDisplayed();
    }
    public String getProjectCode() {
        return singleProjectPage.getProjectCode().getText();
    }
}
