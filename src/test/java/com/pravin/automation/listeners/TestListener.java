package com.pravin.automation.listeners;

import com.aventstack.extentreports.*;
import com.pravin.automation.base.DriverFactory;
import com.pravin.automation.utils.ExtentManager;
import com.pravin.automation.utils.ScreenshotUtil;
import org.openqa.selenium.WebDriver;
import org.testng.*;

public class TestListener implements ITestListener {

    private static ExtentReports extent = ExtentManager.getInstance();

    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    // 🔥 On Test Start
    @Override
    public void onTestStart(ITestResult result) {

        ExtentTest extentTest = extent.createTest(
                result.getMethod().getMethodName() +
                        " | Thread-" + Thread.currentThread().getId()
        );

        test.set(extentTest);
    }

    // 🔥 On Test Success
    @Override
    public void onTestSuccess(ITestResult result) {

        Object retryObj = result.getAttribute("retryCount");
        int retryCount = (retryObj != null) ? (int) retryObj : 0;

        test.get().pass("Test Passed");

        if (retryCount > 0) {
            test.get().warning("FLAKY TEST ⚠️ - Passed after " + retryCount + " retries");
        }
    }

    // 🔥 On Test Failure
    @Override
    public void onTestFailure(ITestResult result) {

        WebDriver driver = DriverFactory.getDriver();

        Object retryObj = result.getAttribute("retryCount");
        int retryCount = (retryObj != null) ? (int) retryObj : 0;

        test.get().fail(result.getThrowable());

        String screenshotPath = ScreenshotUtil.captureScreenshot(driver, result.getName());

        try {
            test.get().addScreenCaptureFromPath(screenshotPath);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (retryCount > 0) {
            test.get().info("Retried " + retryCount + " times but still FAILED");
        }
    }

    // 🔥 On Test Skipped
    @Override
    public void onTestSkipped(ITestResult result) {
        test.get().skip("Test Skipped");
    }

    // 🔥 Flush report at end
    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
}