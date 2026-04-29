package com.pravin.automation.testdata;

import org.testng.annotations.DataProvider;

public class TestData {
    //Test Data setup - Beginner level
    @DataProvider(name = "ValidloginData")
    public Object [][] getLoginData(){
        return new Object[][]{
                {"tomsmith" , "SuperSecretPassword!"},
        };
    }
    @DataProvider (name = "InvalidloginData")
    public Object [][] getinvalidLoginData(){
        return new Object[][]{
                {"tomsmith1" , "SuperSecretPassword!"},
                {"ABC","xyz"}
        };
    }
}
