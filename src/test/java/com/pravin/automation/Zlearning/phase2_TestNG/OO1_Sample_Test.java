package com.pravin.automation.Zlearning.phase2_TestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;

public class OO1_Sample_Test {

    WebDriver driver;
    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    void test1(){
        System.out.println("Basic TestNG Structure: @Test Block executed");
    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }

}



