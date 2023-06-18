package org.tms.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.tms.driver.DriverSingleton;

public abstract class BasePage {
    private final static int EXPLICITLY_WAIT_SECONDS = 7;
    protected WebDriver driver = DriverSingleton.getInstance().getDriver();

    protected BasePage() {
        PageFactory.initElements(driver, this);
    }

    // can be moved to utils class
    protected WebElement waitVisibilityOf(WebElement element) {
        return new WebDriverWait(driver, EXPLICITLY_WAIT_SECONDS).until(ExpectedConditions.visibilityOf(element));
    }

    protected WebElement waitElementToBeClickable(WebElement element) {
        return new WebDriverWait(driver, EXPLICITLY_WAIT_SECONDS).until(ExpectedConditions.elementToBeClickable(element));
    }
}
