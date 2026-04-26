package com.pravin.automation.tests;

import com.pravin.automation.base.BaseTest;
import com.pravin.automation.pages.ButtonPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ButtonPageTest extends BaseTest {
    ButtonPage buttonPage;

    @BeforeMethod
        public void openURL(){
        driver.get("https://www.qa-practice.com/elements/button/simple");
        buttonPage = new ButtonPage(driver);
    }

    @Test
        public void click_shouldclick (){
        buttonPage.clickbutton();
        buttonPage.getresulttext();
        String actualClickMessage = buttonPage.getresulttext();
        Assert.assertTrue(actualClickMessage.contains("Submitted"));
    }
}
