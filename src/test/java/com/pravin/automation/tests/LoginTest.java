package com.pravin.automation.tests;

import com.pravin.automation.base.BaseTest;
import com.pravin.automation.pages.LoginPage;
import com.pravin.automation.testdata.TestData;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    private static final Logger log = LogManager.getLogger(LoginTest.class);
    LoginPage loginPage;


    @BeforeMethod
        void init (){
        driver.get("https://the-internet.herokuapp.com/login");
        loginPage = new LoginPage(driver);
    }

    //Positive case
    @Test (dataProvider = "ValidloginData" , dataProviderClass = TestData.class)
    void login_shouldSecceed(String user , String pass){
        test.info("Enter Username and password");
        log.info("Enter Username and password");
        loginPage.login(user,pass);
        System.out.println("Username is = "+ user +"  "+ "Password is = "+ pass + " ");

        Assert.assertTrue(loginPage.isloginsuccessful());
        test.pass("login Successfully");
        log.info("Log in successfully");
    }


    //Negative case
    @Test (dataProvider = "InvalidloginData" , dataProviderClass = TestData.class)
    void invalidLogin_shouldError (String user , String pass){
        loginPage.login(user , pass);

        //Assert.assertTrue(loginPage.getmessage().contains("invalid"));
        Assert.assertTrue(loginPage.isloginfailed(), "Login should be fail due to wrong credential");
        test.pass("Login failed due to wrong data");
        log.info("Login failed due to wrong data");
    }


}
