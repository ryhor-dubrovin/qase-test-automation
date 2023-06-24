package org.tms.services;

import org.tms.pages.SingleProjectPage;

public class SingleProjectPageService {
    private SingleProjectPage singleProjectPage = new SingleProjectPage();

    public boolean isCreateNewCaseButtonDisplayed() {
        return singleProjectPage.isCreateNewCaseButtonDisplayed();
    }
}
