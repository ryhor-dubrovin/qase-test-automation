package org.tms.services;

import org.tms.pages.DistinctProjectPage;

public class DistinctProjectPageService {
    DistinctProjectPage distinctProjectPage = new DistinctProjectPage();

    public boolean isCreateNewCaseButtonDisplayed() {
        return distinctProjectPage.getCreateNewCaseButton().isDisplayed();
    }
}
