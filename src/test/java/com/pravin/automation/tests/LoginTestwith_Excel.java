package com.pravin.automation.tests;

import com.pravin.automation.base.BaseTest;
import com.pravin.automation.base.DriverFactory;
import com.pravin.automation.pages.LoginPage;
import com.pravin.automation.testdata.ExcelTestData;
import com.pravin.automation.utils.ConfigReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Map;

public class LoginTestwith_Excel extends BaseTest {
    private static final Logger log = LogManager.getLogger(LoginTestwith_Excel.class);
    LoginPage loginpagetestExcel;

    @BeforeMethod
    public void init (){
        DriverFactory.getDriver().get(ConfigReader.get("baseUrl_Login"));
        loginpagetestExcel = new LoginPage(DriverFactory.getDriver());
    }

    @Test (dataProvider = "excelLoginData", dataProviderClass = ExcelTestData.class, retryAnalyzer = com.pravin.automation.retry.RetryAnalyzer.class)
    public void loginTest (Map<String, String>data){
//                         (insted of String user, String pass)

        BaseTest.getTest().info("Step execution");

        String user = data.get("username");
        String pass = data.get("password");
        boolean expected = Boolean.parseBoolean(data.get("expected"));
        String message = data.get("message");

        BaseTest.getTest().info("Scenario : "+ message);

        loginpagetestExcel.login(user , pass);
        boolean actual = loginpagetestExcel.isLoginSuccessful();
        Assert.assertEquals(actual, expected,message);
    }
}
