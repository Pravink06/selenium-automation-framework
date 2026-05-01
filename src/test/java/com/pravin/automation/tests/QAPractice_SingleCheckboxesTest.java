package com.pravin.automation.tests;

import com.pravin.automation.base.BaseTest;
import com.pravin.automation.base.DriverFactory;
import com.pravin.automation.pages.QAPractice_SingleCheckboxesPage;
import com.pravin.automation.utils.ConfigReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class QAPractice_SingleCheckboxesTest extends BaseTest {
    private static final Logger log = LogManager.getLogger(QAPractice_SingleCheckboxesTest.class);
    QAPractice_SingleCheckboxesPage qasinglecheckboxpage;

    @BeforeMethod
    public void init(){
        BaseTest.getTest().info("Init Method running...");
        log.info("Url is launching...");

        DriverFactory.getDriver().get(ConfigReader.get("qapractiseBaseurl" + "/elements/checkbox/single_checkbox"));
        qasinglecheckboxpage = new QAPractice_SingleCheckboxesPage(DriverFactory.getDriver()) ;

        log.info("URL launched");
    }

    @Test
    public void verify_SubmitText (){
        //Verify navigation

        BaseTest.getTest().info("Validating page navigation");
        log.info("page Navigation");

        boolean navigateVerify  =qasinglecheckboxpage.navigateTo_SingleCheckBox();
        Assert.assertTrue(navigateVerify, "Invalid page");

        BaseTest.getTest().info("Page Navigated ");
        log.info("Single CheckBox Field is visible");

    }
    @Test
    public void verify_CheckboxLabel(){

        BaseTest.getTest().info("Validation of CheckBox label");
        log.info("Validating checkbox label");

        boolean checkboxlabel1= qasinglecheckboxpage.isCheckboxlabeledas("Select me or not");
        Assert.assertTrue(checkboxlabel1, "Label is invalid");

        BaseTest.getTest().info("Label is validated successfully");
        log.info("Select me or not is visible as CheckBox label");
    }

    @Test
    public void checkTheBoxAndSubmit(){
        //Check the CheckBox
        BaseTest.getTest().info("Validation Checkbox selection");
        log.info("Checking the checkbox...");

        qasinglecheckboxpage.ChecktheBox();
        qasinglecheckboxpage.ClickOnSubmit();

        boolean submiteverify= qasinglecheckboxpage.issubmitmessagevisiable("select me or not");
        Assert.assertTrue(submiteverify,"Invalid Result text");

        BaseTest.getTest().info("Submitted Successfully");

        log.info("Submit test is visible and verified successfully- Feature branch change");

        log.info("Closing Checkbox validation");



    }


}
