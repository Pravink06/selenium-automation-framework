package com.pravin.automation.testdata;

import org.testng.annotations.DataProvider;

import java.util.HashMap;
import java.util.Map;

public class TestData_Map {
    // Test data Map based

    @DataProvider (name = "loginDataMap")
    public Object [][] loginDataMap() {
        Map<String, Object> validUser = new HashMap<>();
        validUser.put("username", "tomsmith");
        validUser.put("password", "SuperSecretPassword!");
        validUser.put("expected", true);
        validUser.put("message", "valid Login");

        Map<String, Object> invalidUsername = new HashMap<>();
        invalidUsername.put("username", "tomboy");
        invalidUsername.put("password", "SuperSecretPassword!");
        invalidUsername.put("expected", false);
        invalidUsername.put("message", "Invalid user");

        Map<String, Object> invalidpassword = new HashMap<>();
        invalidpassword.put("username", "tomsmith");
        invalidpassword.put("password", "wrongpassword!");
        invalidpassword.put("expected", false);
        invalidpassword.put("message", "invalid password");

        return new Object[][]{
                {validUser},
                {invalidUsername},
                {invalidpassword}

    };


    }
}
