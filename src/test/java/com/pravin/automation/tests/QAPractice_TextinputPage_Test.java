package com.pravin.automation.tests;

import com.fasterxml.jackson.databind.ser.Serializers;
import com.pravin.automation.base.BaseTest;
import com.pravin.automation.base.DriverFactory;
import com.pravin.automation.pages.QAPractice_TextinputPage;
import com.pravin.automation.utils.ConfigReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class QAPractice_TextinputPage_Test extends BaseTest {
    private static final Logger log = LogManager.getLogger(QAPractice_TextinputPage_Test.class);

    QAPractice_TextinputPage qapage;

    @BeforeMethod
    public void init(){
        DriverFactory.getDriver().get(ConfigReader.get("qapractiseBaseurl"));
        qapage = new QAPractice_TextinputPage(DriverFactory.getDriver());
    }

    @Test  (retryAnalyzer = com.pravin.automation.retry.RetryAnalyzer.class)//Test 1 : Only navigation Validation
    public void Valid_clickOnTextInput(){

        qapage.openTextInputPage();
        Assert.assertTrue(qapage.isTextInputPageOpened(), "Text Input page not opened");
    }

    //Test2 : Verify the Submitted Text
    @Test (retryAnalyzer = com.pravin.automation.retry.RetryAnalyzer.class)
    public void verify_TextInputSubmission(){

        qapage.openTextInputPage();
        Assert.assertTrue(qapage.isTextInputPageOpened(), "Text Input page not opened");


        qapage.enterTextAndSubmit("Pravin_Kolkar");


        boolean result = qapage.isenteredTextVisiable("Pravin_Kolkar");

        Assert.assertTrue(result, "Entered text not visible in result");


    }

    //Test 3: Verify 25 char error
    @Test (retryAnalyzer = com.pravin.automation.retry.RetryAnalyzer.class)
    public void verify_max25charerrormessage(){

        qapage.openTextInputPage();
        Assert.assertTrue(qapage.isTextInputPageOpened(), "Text Input page not opened");


        qapage.enterTextAndSubmit("poiuytrewqasdfghjklmnbvcxzasqwed");


        Assert.assertTrue(qapage.iserrormessagevisiable("Please enter no more than 25 characters") , "Max 25 error text failed");

    }

    @Test (retryAnalyzer = com.pravin.automation.retry.RetryAnalyzer.class)
    public void verify_min2charErrorMessage(){

        qapage.openTextInputPage();
        Assert.assertTrue(qapage.isTextInputPageOpened(), "Text Input page not opened");


        qapage.enterTextAndSubmit("q");


        Assert.assertTrue(qapage.iserrormessagevisiable("Please enter 2 or more characters"), "Min 2 error text failed");
    }

    @Test(retryAnalyzer = com.pravin.automation.retry.RetryAnalyzer.class)
    public void verify_invalidcharerrorMessage(){
        log.info("===== TEST STARTED =====");

        log.info("Opening Text Input page");
        qapage.openTextInputPage();
        Assert.assertTrue(qapage.isTextInputPageOpened(), "Text Input page not opened");


        log.info("Entering text");
        qapage.enterTextAndSubmit("@@3");



        Assert.assertTrue(qapage.iserrormessagevisiable("Enter a valid string consisting of letters, numbers, underscores or hyphens."), "invalid char is taking ");

    }


}
