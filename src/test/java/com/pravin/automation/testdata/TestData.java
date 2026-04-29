package com.pravin.automation.testdata;

import org.testng.annotations.DataProvider;

public class TestData {

    @DataProvider(name = "loginData")
    public Object[][] loginData(){
        return new Object[][]{
                {"tomsmith", "SuperSecretPassword!", true,  "Valid login"},
                {"wrongUser", "SuperSecretPassword!", false, "Invalid username"},
                {"tomsmith", "WrongPassword!", false, "Invalid password"}
        };
    }
}