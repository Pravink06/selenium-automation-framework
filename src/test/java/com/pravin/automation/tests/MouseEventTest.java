package com.pravin.automation.tests;

import com.pravin.automation.base.BaseTest;
import com.pravin.automation.base.DriverFactory;
import com.pravin.automation.pages.MouseEventPage;
import com.pravin.automation.utils.ConfigReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MouseEventTest extends BaseTest {
    private static final Logger log = LogManager.getLogger(MouseEventTest.class);

    MouseEventPage mouseEventPage;

    @BeforeMethod
        public void init (){

        BaseTest.getTest().info("Init Method started running");
        DriverFactory.getDriver().get(ConfigReader.get("MouseEventHoveroverURL"));

        BaseTest.getTest().info("URL launched");
        log.info("URL launched");
        mouseEventPage = new MouseEventPage(DriverFactory.getDriver());
    }

    @Test (retryAnalyzer = com.pravin.automation.retry.RetryAnalyzer.class)
    void verify_mouseMove (){
        BaseTest.getTest().info("Step execution");

        BaseTest.getTest().info("Move to Element");
        log.info("Doing Hover over");
        mouseEventPage.tooltipstatus();
        String actulstatus= mouseEventPage.gettooltipstatus();
        Assert.assertTrue(actulstatus.contains("Tooltip Visible"));
        BaseTest.getTest().info("Tool tip Visible successfully");
        log.info("Tool tip is visible. (This log is changed to  Professional commit)");
    }

}
