package org.tms.ui.pages;

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

    public LoginPage openPage() {
        driver.get(Urls.LOGIN_PAGE);
        return this;
    }

    public LoginPage fillInEmail(String email) {
        waitVisibilityOf(emailField).sendKeys(email);
        return this;
    }

    public LoginPage fillInPassword(String password) {
        waitVisibilityOf(passwordField).sendKeys(password);
        return this;
    }

    public void clickSingInButton() {
        waitElementToBeClickable(singInButton).click();
    }

}
