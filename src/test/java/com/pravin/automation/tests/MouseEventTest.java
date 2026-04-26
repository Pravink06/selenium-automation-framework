package com.pravin.automation.tests;

import com.pravin.automation.base.BaseTest;
import com.pravin.automation.pages.MouseEventPage;
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
        System.out.println("Driver in init: " + driver);
        test.info("Init Method started running");
        driver.get("https://vinothqaacademy.com/mouse-event/");

        test.info("URL launched");
        log.info("URL launched");
        mouseEventPage = new MouseEventPage(driver);
    }

    @Test
    void verify_mouseMove (){

        test.info("Move to Element");
        log.info("Doing Hover over");
        mouseEventPage.tooltipstatus();
        String actulstatus= mouseEventPage.gettooltipstatus();
        Assert.assertTrue(actulstatus.contains("Tooltip Visible"));
        test.pass("Tool tip Visible successfully");
        log.info("Tool tip Visible successfully");
    }

}
