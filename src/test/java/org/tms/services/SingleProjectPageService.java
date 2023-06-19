package org.tms.services;

import org.tms.pages.SingleProjectPage;

public class SingleProjectPageService {
    SingleProjectPage singleProjectPage = new SingleProjectPage();

    public boolean isCreateNewCaseButtonDisplayed() {
        return singleProjectPage.getCreateNewCaseButton().isDisplayed();
    }
}
