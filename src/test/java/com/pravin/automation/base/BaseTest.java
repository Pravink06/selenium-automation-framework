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

    //  Single report instance for entire execution
    protected static ExtentReports extent;

    //  Thread-safe test instance (parallel execution safe)
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    @BeforeSuite(alwaysRun = true)
    public void setupReport() {
        // Initialize report once before suite
        extent = ExtentManager.getInstance();
    }

    @BeforeMethod(alwaysRun = true)
    public void setup(Method method) {

        //  Safety check (avoid null in parallel edge cases)
        if (extent == null) {
            extent = ExtentManager.getInstance();
        }

        //  Initialize driver (ThreadLocal inside DriverFactory)
        DriverFactory.initDriver();
        DriverFactory.getDriver().manage().window().maximize();

        //  Create test entry with thread info (important for parallel debug)
        ExtentTest extentTest = extent.createTest(
                method.getName() + " | Thread-" + Thread.currentThread().getId()
        );

        // Store test instance thread-wise
        test.set(extentTest);
    }

    //  Getter to access ExtentTest anywhere
    public static ExtentTest getTest() {
        return test.get();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult result) {

        WebDriver driver = DriverFactory.getDriver();

        // Read retry count from TestNG context
        Object retryObj = result.getAttribute("retryCount");
        int retryCount = (retryObj != null) ? (int) retryObj : 0;

        // ==============================
        //  FAILURE
        // ==============================
        if (result.getStatus() == ITestResult.FAILURE) {

            // Capture screenshot on failure
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, result.getName());

            //  Log failure
            getTest().fail(result.getThrowable());

            try {
                getTest().addScreenCaptureFromPath(screenshotPath);
            } catch (Exception e) {
                e.printStackTrace();
            }

            // If failed after retries → show retry info
            if (retryCount > 0) {
                getTest().info("Test retried " + retryCount + " times but still FAILED");
            }

        }

        // ==============================
        // SUCCESS
        // ==============================
        else if (result.getStatus() == ITestResult.SUCCESS) {

            getTest().pass("Test Passed");

            //  If passed after retry → mark as FLAKY
            if (retryCount > 0) {
                getTest().warning("FLAKY TEST ⚠️ - Passed after " + retryCount + " retries");
            }
        }

        // ==============================
        // SKIPPED
        // ==============================
        else {

            getTest().skip("Test Skipped");
        }

        //  Clean up driver (ThreadLocal quit)
        DriverFactory.quitDriver();

        //  VERY IMPORTANT → remove ThreadLocal to avoid memory leak
        test.remove();
    }

    @AfterSuite(alwaysRun = true)
    public void flushReport() {
        // Flush report once after execution
        extent.flush();
    }
}