package org.tms.utils.tools;

import io.qameta.allure.Attachment;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.tms.ui.driver.DriverSingleton;

import java.util.concurrent.TimeUnit;

@Log4j2
public class TestListener implements ITestListener {
    @Override
    public void onTestStart(ITestResult iTestResult) {
        log.info(String.format(
                "======================================== STARTING TEST %s ========================================",
                iTestResult.getName()));
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        log.info(String.format(
                "======================================== FINISHED TEST %s Duration: %ss ========================================",
                iTestResult.getName(),
                getExecutionTime(iTestResult)));
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        log.info(String.format(
                "======================================== FAILED TEST %s Duration: %ss ========================================",
                iTestResult.getName(),
                getExecutionTime(iTestResult)));
        takeScreenshot();
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        log.info(String.format("======================================== SKIPPING TEST %s ========================================",
                iTestResult.getName()));
    }

//    @Override
//    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
//    }
//
//    @Override
//    public void onStart(ITestContext iTestContext) {
//        System.out.println("--- !!!START!! ---");
//    }
//
//    @Override
//    public void onFinish(ITestContext iTestContext) {
//        System.out.println("--- !!!FINISHED!!! ---");
//    }

    private long getExecutionTime(ITestResult iTestResult) {
        return TimeUnit.MILLISECONDS.toSeconds(iTestResult.getEndMillis() - iTestResult.getStartMillis());
    }

    @Attachment(value = "Last screen state", type = "image/png")
    private byte[] takeScreenshot() {
        return ((TakesScreenshot) DriverSingleton.getInstance().getDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
