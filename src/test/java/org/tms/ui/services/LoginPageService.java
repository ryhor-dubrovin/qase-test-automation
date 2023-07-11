package org.tms.ui.services;

import io.qameta.allure.Step;
import org.tms.ui.model.User;
import org.tms.ui.pages.LoginPage;

public class LoginPageService {
    private LoginPage loginPage = new LoginPage();

    @Step("Logging in with the user.")
    public ProjectsPageService loginWithUser(User user) {
        loginPage
                .openPage()
                .fillInEmail(user.getEmail())
                .fillInPassword(user.getPassword())
                .clickSingInButton();
        return new ProjectsPageService();
    }
}
