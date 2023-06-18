package org.tms.services;

import org.tms.model.User;
import org.tms.pages.LoginPage;

public class LoginPageService {
    //business actions
    public ProjectsPageService loginWithUser(User user) {
        LoginPage loginPage = new LoginPage();
        loginPage
                .fillInPassword(user.getEmail())
                .fillInPassword(user.getPassword())
                .clickSingInButton();
        return new ProjectsPageService();
    }
}
