package org.tms.driver;

import org.openqa.selenium.WebDriver;

public class DriverSingleton {
    private WebDriver driver;
    private static ThreadLocal<DriverSingleton> instance = new ThreadLocal<>();

    private DriverSingleton() {
        driver = WebDriverFactory.getWebDriver();
    }

    public static synchronized DriverSingleton getInstance() {
        if (null == instance.get()) {
            instance.set(new DriverSingleton());
        }
        return instance.get();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void closeDriver() {
        try {
            driver.quit();
            driver = null;
        } finally {
            instance.remove();
        }
    }
}
