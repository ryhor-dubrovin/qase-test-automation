package org.tms.services;

import org.tms.model.User;
import org.tms.pages.LoginPage;

public class LoginPageService {
    //business actions
    LoginPage loginPage = new LoginPage();

    public ProjectsPageService loginWithUser(User user) {
        loginPage
                .openPage()
                .fillInEmail(user.getEmail())
                .fillInPassword(user.getPassword())
                .clickSingInButton();
        return new ProjectsPageService();
    }
}
