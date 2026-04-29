package com.pravin.automation.tests;

import com.pravin.automation.base.BaseTest;
import com.pravin.automation.pages.LoginPage;
import com.pravin.automation.testdata.TestData_Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Map;

public class LoginTestWithMap extends BaseTest {
    private static final Logger log = LogManager.getLogger(LoginTestWithMap.class);
    LoginPage loginpagewithMap;

    @BeforeMethod
    public void init(){
        test.info("Launching the URL");
        log.info("URL launching ");

        driver.get("https://the-internet.herokuapp.com/login");
        loginpagewithMap =  new LoginPage(driver);
    }

    @Test (dataProvider = "loginDataMap" , dataProviderClass = TestData_Map.class)
    public void loginTest (Map<String , Object> data){

        String user = data.get("username").toString();
        String pass = data.get("password").toString();
        boolean expected = (boolean) data.get("expected");
        String message = data.get("message").toString();

        test.info("Scenario : "+message);
        log.info("Scenario : "+ message);

        loginpagewithMap.login(user,pass);
        boolean actual = loginpagewithMap.isLoginSuccessful();

        Assert.assertEquals(actual,expected,message);
    }


}
