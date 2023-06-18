package org.tms.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    @FindBy(xpath = "//input[@name='email']")
    private WebElement emailField;
    @FindBy(xpath = "//input[@name='password']")
    private WebElement passwordField;
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement singInButton;

    public LoginPage fillInEmail(String email) {
        waitVisibilityOf(emailField).sendKeys(email);
        return this;
    }

    public LoginPage fillInPassword(String password) {
        waitVisibilityOf(emailField).sendKeys(password);
        return this;
    }

    public void clickSingInButton() {
        waitElementToBeClickable(singInButton);
    } 
    //javauser95@gmail.com
    //AQA20onl
}
