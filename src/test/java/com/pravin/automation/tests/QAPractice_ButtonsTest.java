package com.pravin.automation.tests;

import com.pravin.automation.base.BaseTest;
import com.pravin.automation.base.DriverFactory;
import com.pravin.automation.pages.QAPractice_ButtonsPage;
import com.pravin.automation.utils.ConfigReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class QAPractice_ButtonsTest extends BaseTest {
    private static final Logger log = LogManager.getLogger(QAPractice_ButtonsTest.class);

    QAPractice_ButtonsPage qabuttonspage;

    @BeforeMethod
    public void init(){

        log.info("Init Method started running");

        DriverFactory.getDriver().get(ConfigReader.get("qapractiseBaseurl_buttonSimple"));


        log.info("URL launched");
        qabuttonspage = new QAPractice_ButtonsPage(DriverFactory.getDriver());
    }

    @Test (retryAnalyzer = com.pravin.automation.retry.RetryAnalyzer.class)
    //navigation validation , Click Button label text and Button submission text
    public void E2EbuttonClick (){

        log.info("TC: E2EbuttonClick Running");

        qabuttonspage.isSimplebuttonNavigated("Constructor");

        boolean isdisplayedresult = qabuttonspage.isSimplebuttonNavigated("Displayed");

        Assert.assertTrue(isdisplayedresult,"Simple Button Not navigated");

        log.info("Simple Button Navigated");



        log.info("Checking Click should labeled on Button");
        qabuttonspage.getClickButton_label();
        System.out.println("Actual Button Text: " + qabuttonspage.getClickButton_label());
        boolean isclicklabeldisplayed = qabuttonspage.isClickButtonlabeled("Click");
        Assert.assertTrue(isclicklabeldisplayed,"Click Button is not labeled as Click");




        log.info("Clicking on Click_button");
        qabuttonspage.ClickonButton();
        Assert.assertTrue(qabuttonspage.isResultTextVisiable("Submitted"),"Submitted text is not visible");

        log.info("Submitted text is visible this is log info");
    }

}
