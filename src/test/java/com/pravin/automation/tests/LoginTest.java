package com.pravin.automation.tests;

import com.pravin.automation.base.BaseTest;
import com.pravin.automation.pages.LoginPage;
import com.pravin.automation.testdata.TestData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    LoginPage loginPage;

    @BeforeMethod
    public void init(){
        driver.get("https://the-internet.herokuapp.com/login");
        loginPage = new LoginPage(driver);
    }

    @Test(dataProvider = "loginData", dataProviderClass = TestData.class)
    public void loginTest(String user, String pass, boolean expected, String message){

        loginPage.login(user, pass);

        boolean actual = loginPage.isLoginSuccessful();

        Assert.assertEquals(actual, expected, message);
    }
}