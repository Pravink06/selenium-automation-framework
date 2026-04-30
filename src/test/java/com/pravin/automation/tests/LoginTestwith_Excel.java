package com.pravin.automation.tests;

import com.pravin.automation.base.BaseTest;
import com.pravin.automation.pages.LoginPage;
import com.pravin.automation.testdata.ExcelTestData;
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
        driver.get("https://the-internet.herokuapp.com/login");
        loginpagetestExcel = new LoginPage(driver);
    }

    @Test (dataProvider = "excelLoginData", dataProviderClass = ExcelTestData.class)
    public void loginTest (Map<String, String>data){
//                         (insted of String user, String pass)

        String user = data.get("username");
        String pass = data.get("password");
        boolean expected = Boolean.parseBoolean(data.get("expected"));
        String message = data.get("message");

        test.info("Scenario : "+ message);

        loginpagetestExcel.login(user , pass);
        boolean actual = loginpagetestExcel.isLoginSuccessful();
        Assert.assertEquals(actual, expected,message);
    }
}
