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

    @Test //Test 1 : Only navigation Validation
    public void Valid_clickOnTextInput(){
        BaseTest.getTest().info("Opening Text Input page");
        qapage.openTextInputPage();
        Assert.assertTrue(qapage.isTextInputPageOpened(), "Text Input page not opened");
    }

    //Test2 : Verify the Submitted Text
    @Test
    public void verify_TextInputSubmission(){
        BaseTest.getTest().info("Opening Text Input page");
        qapage.openTextInputPage();
        Assert.assertTrue(qapage.isTextInputPageOpened(), "Text Input page not opened");

        BaseTest.getTest().info("Entering text: Pravin_Kolkar");
        qapage.enterTextAndSubmit("Pravin_Kolkar");
        BaseTest.getTest().info("Validating entered text is displayed");

        boolean result = qapage.isenteredTextVisiable("Pravin_Kolkar");

        Assert.assertTrue(result, "Entered text not visible in result");
        BaseTest.getTest().info("Text input submission verified successfully");

    }

    //Test 3: Verify 25 char error
    @Test
    public void verify_max25charerrormessage(){
        BaseTest.getTest().info("Opening Text Input page");
        qapage.openTextInputPage();
        Assert.assertTrue(qapage.isTextInputPageOpened(), "Text Input page not opened");

        BaseTest.getTest().info("Entering text");
        qapage.enterTextAndSubmit("poiuytrewqasdfghjklmnbvcxzasqwed");
        BaseTest.getTest().info("Text entered successfully");

        Assert.assertTrue(qapage.iserrormessagevisiable("Please enter no more than 25 characters") , "Max 25 error text failed");

    }

    @Test
    public void verify_min2charErrorMessage(){
        BaseTest.getTest().info("Opening Text Input page");
        qapage.openTextInputPage();
        Assert.assertTrue(qapage.isTextInputPageOpened(), "Text Input page not opened");

        BaseTest.getTest().info("Entering text");
        qapage.enterTextAndSubmit("q");
        BaseTest.getTest().info("Text entered successfully");

        Assert.assertTrue(qapage.iserrormessagevisiable("Please enter 2 or more characters"), "Min 2 error text failed");
    }

    @Test
    public void verify_invalidcharerrorMessage(){
        log.info("===== TEST STARTED =====");

        log.info("Opening Text Input page");
        qapage.openTextInputPage();
        Assert.assertTrue(qapage.isTextInputPageOpened(), "Text Input page not opened");


        log.info("Entering text");
        qapage.enterTextAndSubmit("@@1");



        Assert.assertTrue(qapage.iserrormessagevisiable("Enter a valid string consisting of letters, numbers, underscores or hyphens."), "invalid char is taking ");

    }


}
