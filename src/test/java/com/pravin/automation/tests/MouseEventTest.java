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


        DriverFactory.getDriver().get(ConfigReader.get("MouseEventHoveroverURL"));


        log.info("URL launched");
        mouseEventPage = new MouseEventPage(DriverFactory.getDriver());
    }

    @Test (retryAnalyzer = com.pravin.automation.retry.RetryAnalyzer.class)
    void verify_mouseMove (){



        log.info("Doing Hover over");
        mouseEventPage.tooltipstatus();
        String actulstatus= mouseEventPage.gettooltipstatus();
        Assert.assertTrue(actulstatus.contains("Tooltip Visible"));

        log.info("Tool tip is visible. (This log is changed to  Professional commit)");
    }

}
