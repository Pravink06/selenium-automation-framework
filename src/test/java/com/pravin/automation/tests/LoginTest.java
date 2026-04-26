package com.pravin.automation.tests;

import com.pravin.automation.base.BaseTest;
import com.pravin.automation.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    LoginPage loginPage;

    @BeforeMethod
        void init (){
        driver.get("https://the-internet.herokuapp.com/login");
        loginPage = new LoginPage(driver);
    }

    //Positive case
    @Test
    void validLogin_shouldSucceed(){
        loginPage.login("tomsmith" , "SuperSecretPassword!");

        Assert.assertTrue(loginPage.isloginsuccessful() , "Login should be successful");

    }

    //Negative case
    @Test
    void invalidLogin_shouldError (){
        loginPage.login("Wrong", "Wrong");

        //Assert.assertTrue(loginPage.getmessage().contains("invalid"));
        Assert.assertTrue(loginPage.isloginfailed(), "Login should be fail due to wrong credential");
    }


}
