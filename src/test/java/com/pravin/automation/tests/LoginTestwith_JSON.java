package com.pravin.automation.tests;

import com.pravin.automation.base.BaseTest;
import com.pravin.automation.base.DriverFactory;
import com.pravin.automation.pages.LoginPage;
import com.pravin.automation.testdata.JsonTestData;
import com.pravin.automation.utils.ConfigReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Map;

public class LoginTestwith_JSON extends BaseTest {
    private static final Logger log = LogManager.getLogger(LoginTestwith_JSON.class);
    LoginPage loginpagetestJSON;

    @BeforeMethod
    public void  init (){
        DriverFactory.getDriver().get(ConfigReader.get("baseUrl") + "/login");
        loginpagetestJSON = new LoginPage(DriverFactory.getDriver());
    }

    @Test (dataProvider = "jsonLoginData" , dataProviderClass = JsonTestData.class , retryAnalyzer = com.pravin.automation.retry.RetryAnalyzer.class )
    public void loginTest (Map <String, Object> data){


        Map<String, Object> user = (Map<String, Object>) data.get("user");
        Map<String, Object> expected = (Map<String, Object>) data.get("expected");

        String username = user.get("username").toString();
        String password = user.get("password").toString();

        boolean exp = (boolean) expected.get("success");

        loginpagetestJSON.login(username, password);

        boolean actual = loginpagetestJSON.isLoginSuccessful();

        Assert.assertEquals(actual, exp);



    }

}
