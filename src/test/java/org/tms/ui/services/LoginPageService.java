package org.tms.ui.services;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.tms.ui.model.User;
import org.tms.ui.pages.LoginPage;

@Log4j2
public class LoginPageService {
    private LoginPage loginPage = new LoginPage();

    @Step("Logging in with the user.")
    public ProjectsPageService loginWithUser(User user) {
        try {
            loginPage
                    .openPage()
                    .fillInEmail(user.getEmail())
                    .fillInPassword(user.getPassword())
                    .clickSingInButton();
        } catch (Exception e) {
            log.error("Failed to login with user! email: " + user.getEmail());
        }

        return new ProjectsPageService();
    }
}
