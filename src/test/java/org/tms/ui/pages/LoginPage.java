package org.tms.ui.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.tms.utils.constants.Urls;

public class LoginPage extends BasePage {
    @FindBy(xpath = "//input[@name='email']")
    private WebElement emailField;
    @FindBy(xpath = "//input[@name='password']")
    private WebElement passwordField;
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement singInButton;

    @Step("Open Login Page")
    public LoginPage openPage() {
        driver.get(Urls.LOGIN_PAGE);
        return this;
    }

    @Step("Enter email")
    public LoginPage fillInEmail(String email) {
        waitVisibilityOf(emailField).sendKeys(email);
        return this;
    }

    @Step("Enter password")
    public LoginPage fillInPassword(String password) {
        waitVisibilityOf(passwordField).sendKeys(password);
        return this;
    }

    @Step("Click \"Sing In\" button")
    public void clickSingInButton() {
        waitElementToBeClickable(singInButton).click();
    }

}
