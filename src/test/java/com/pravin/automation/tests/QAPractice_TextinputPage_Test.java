package com.pravin.automation.tests;

import com.pravin.automation.base.BaseTest;
import com.pravin.automation.pages.QAPractice_TextinputPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class QAPractice_TextinputPage_Test extends BaseTest {
    private static final Logger log = LogManager.getLogger(LoginTest.class);

    QAPractice_TextinputPage qapage;

    @BeforeMethod
    public void init(){
        driver.get("https://www.qa-practice.com/");
        qapage = new QAPractice_TextinputPage(driver);
    }

    @Test //Test 1 : Only navigation Validation
    public void Valid_clickOnTextInput(){
        test.info("Opening Text Input page");
        qapage.openTextInputPage();
        Assert.assertTrue(qapage.isTextInputPageOpened(), "Text Input page not opened");
    }

    //Test2 : Verify the Submitted Text
    @Test
    public void verify_TextInputSubmission(){
        test.info("Opening Text Input page");
        qapage.openTextInputPage();
        Assert.assertTrue(qapage.isTextInputPageOpened(), "Text Input page not opened");

        test.info("Entering text: Pravin_Kolkar");
        qapage.enterTextAndSubmit("Pravin_Kolkar");
        test.info("Validating entered text is displayed");

        boolean result = qapage.isenteredTextVisiable("Pravin_Kolkar");

        Assert.assertTrue(result, "Entered text not visible in result");
        test.pass("Text input submission verified successfully");

    }

    //Test 3: Verify 25 char error
    @Test
    public void verify_max25charerrormessage(){
        test.info("Opening Text Input page");
        qapage.openTextInputPage();
        Assert.assertTrue(qapage.isTextInputPageOpened(), "Text Input page not opened");

        test.info("Entering text");
        qapage.enterTextAndSubmit("poiuytrewqasdfghjklmnbvcxzasqwed");
        test.pass("Text entered successfully");

        Assert.assertTrue(qapage.iserrormessagevisiable("Please enter no more than 25 characters") , "Max 25 error text failed");

    }

    @Test
    public void verify_min2charErrorMessage(){
        test.info("Opening Text Input page");
        qapage.openTextInputPage();
        Assert.assertTrue(qapage.isTextInputPageOpened(), "Text Input page not opened");

        test.info("Entering text");
        qapage.enterTextAndSubmit("q");
        test.pass("Text entered successfully");

        Assert.assertTrue(qapage.iserrormessagevisiable("Please enter 2 or more characters"), "Min 2 error text failed");
    }

    @Test
    public void verify_invalidcharerrorMessage(){
        log.info("===== TEST STARTED =====");
        test.info("Opening Text Input page");
        log.info("Opening Text Input page");
        qapage.openTextInputPage();
        Assert.assertTrue(qapage.isTextInputPageOpened(), "Text Input page not opened");

        test.info("Entering text");
        log.info("Entering text");
        qapage.enterTextAndSubmit("@@1");
        test.pass("Text entered successfully");


        Assert.assertTrue(qapage.iserrormessagevisiable("Enter a valid string consisting of letters, numbers, underscores or hyphens."), "invalid char is taking ");

    }


}
