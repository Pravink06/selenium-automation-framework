package com.pravin.automation.tests;

import com.pravin.automation.base.BaseTest;
import com.pravin.automation.pages.LoginPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
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
    @Test
    void validLogin_shouldSucceed(){
        test.info("Enter Username and password");
        log.info("Username and Password will be entered");
        loginPage.login("tomsmith" , "SuperSecretPassword!");

        Assert.assertTrue(loginPage.isloginsuccessful() , "Login should be successful");
        test.pass("login Successfully");
        log.info("Log in successfully");

        // Revert code 001
        //Revert code 002

    }

    //Negative case
    @Test
    void invalidLogin_shouldError (){
        loginPage.login("Wrong", "Wrong");

        //Assert.assertTrue(loginPage.getmessage().contains("invalid"));
        Assert.assertTrue(loginPage.isloginfailed(), "Login should be fail due to wrong credential");
    }


}
