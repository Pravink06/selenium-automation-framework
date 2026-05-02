package com.pravin.automation.tests;

import com.pravin.automation.base.BaseTest;
import com.pravin.automation.base.DriverFactory;
import com.pravin.automation.pages.ButtonPage;
import com.pravin.automation.utils.ConfigReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ButtonPageTest extends BaseTest {
    private static final Logger log = LogManager.getLogger(ButtonPageTest.class);
    ButtonPage buttonPage;

    @BeforeMethod
        public void openURL(){
        log.info("Launching URL");
        DriverFactory.getDriver().get(ConfigReader.get("qapractiseBaseurl_buttonSimple"));
        buttonPage = new ButtonPage(DriverFactory.getDriver());
    }

    @Test (retryAnalyzer = com.pravin.automation.retry.RetryAnalyzer.class)
        public void click_shouldclick (){
        BaseTest.getTest().info("Step execution");
        log.info("Clicking on button");
        buttonPage.clickbutton();
        log.info("Clicked on button and getting text -Dummy change : Wrong Commit to revert feature ");
        log.info("hard reset Test on GitHub");
        buttonPage.getresulttext();
        String actualClickMessage = buttonPage.getresulttext();
        Assert.assertTrue(actualClickMessage.contains("Submitted"));
    }
}
