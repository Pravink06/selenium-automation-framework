package com.pravin.automation.tests;

import com.pravin.automation.base.BaseTest;
import com.pravin.automation.pages.MouseEventPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MouseEventTest extends BaseTest {

    MouseEventPage mouseEventPage;

    @BeforeMethod
        public void init (){
        System.out.println("Driver in init: " + driver);
        driver.get("https://vinothqaacademy.com/mouse-event/");
        mouseEventPage = new MouseEventPage(driver);
    }

    @Test
    void verify_mouseMove (){
        mouseEventPage.tooltipstatus();
        String actulstatus= mouseEventPage.gettooltipstatus();
        Assert.assertTrue(actulstatus.contains("Tooltip Visible"));
    }

}
