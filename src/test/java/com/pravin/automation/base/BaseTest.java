package com.pravin.automation.base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.pravin.automation.utils.ExtentManager;
import com.pravin.automation.utils.ScreenshotUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;


public class BaseTest  {

    protected WebDriver driver;
    protected static ExtentReports extent;
    protected ExtentTest test;

    @BeforeSuite (alwaysRun = true)
    public void setupReport(){
        extent= ExtentManager.getInstance();
    }

    @BeforeMethod (alwaysRun = true)
        public void setup (Method method ){

        // 🔥 Safety check (VERY IMPORTANT)
        if (extent == null) {
            extent = ExtentManager.getInstance();
        }

        driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Create Test Entry in test report
        test = extent.createTest(method.getName());
    }


    @AfterMethod
    public void tearDown (ITestResult result){
        if (result.getStatus() == ITestResult.FAILURE) {

            String screenshotPath =ScreenshotUtil.captureScreenshot(driver, result.getName());

            test.fail(result.getThrowable());

            try {
                test.addScreenCaptureFromPath(screenshotPath);
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (result.getStatus() == ITestResult.SUCCESS) {

            test.pass("Test Passed");

        } else {

            test.skip("Test Skipped");
        }

        if (driver != null) {
            driver.quit();
        }

    }

    @AfterSuite (alwaysRun = true)
    public void flushReport (){
        extent.flush();
    }
}
