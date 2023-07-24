package org.tms.ui.services;

import org.tms.ui.pages.CasePage;

public class CasePageService {

    public boolean isSaveButtonDisplayed() {
        CasePage casePage = new CasePage();
        return casePage.isSaveButtonDisplayed();
    }
}
