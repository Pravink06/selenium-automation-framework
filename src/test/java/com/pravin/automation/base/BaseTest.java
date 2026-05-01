package com.pravin.automation.base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.pravin.automation.utils.ExtentManager;
import com.pravin.automation.utils.ScreenshotUtil;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.lang.reflect.Method;

public class BaseTest {

    protected static ExtentReports extent;

    // ✅ ThreadLocal for ExtentTest
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    @BeforeSuite(alwaysRun = true)
    public void setupReport() {
        extent = ExtentManager.getInstance();
    }

    @BeforeMethod(alwaysRun = true)
    public void setup(Method method) {

        if (extent == null) {
            extent = ExtentManager.getInstance();
        }

        // Driver init
        DriverFactory.initDriver();
        DriverFactory.getDriver().manage().window().maximize();

        // ✅ FIX: set ThreadLocal properly
        ExtentTest extentTest = extent.createTest(method.getName());
        test.set(extentTest);
    }

    // ✅ Getter (MANDATORY)
    public static ExtentTest getTest() {
        return test.get();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult result) {

        WebDriver driver = DriverFactory.getDriver();

        if (result.getStatus() == ITestResult.FAILURE) {

            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, result.getName());

            getTest().fail(result.getThrowable());

            try {
                getTest().addScreenCaptureFromPath(screenshotPath);
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (result.getStatus() == ITestResult.SUCCESS) {

            getTest().pass("Test Passed");

        } else {

            getTest().skip("Test Skipped");
        }

        // Cleanup
        DriverFactory.quitDriver();
        test.remove(); // 🔥 VERY IMPORTANT (memory leak prevention)
    }

    @AfterSuite(alwaysRun = true)
    public void flushReport() {
        extent.flush();
    }
}