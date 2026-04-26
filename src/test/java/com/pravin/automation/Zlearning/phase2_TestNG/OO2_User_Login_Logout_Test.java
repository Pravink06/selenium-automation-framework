package com.pravin.automation.Zlearning.phase2_TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class OO2_User_Login_Logout_Test {
    //Always initilize the WebDriver and wait for synnc

    WebDriver driver;
    WebDriverWait wait;

    By username = By.id("username");
    By password = By.id("password");
    By clickLogin= By.xpath("//button[@type='submit']");

    //Then add annotation as @BeforeMethod

    @BeforeMethod
        void browserSetup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.navigate().to("https://the-internet.herokuapp.com/login");
    }

    @Test
        void validLogin_shouldSucceed (){
        driver.findElement(username).sendKeys("tomsmith");
        driver.findElement(password).sendKeys("SuperSecretPassword!");
        driver.findElement(clickLogin).click();
        //validation of AfterLogin message
        WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("flash")));
        String ActualMessage = message.getText();
        Assert.assertTrue(ActualMessage.contains("You logged into a secure area!"));
    }
    //Negative Login test


    @Test
    void invalidLogin_shouldShowError (){
        driver.findElement(username).sendKeys("tomsmth");
        driver.findElement(password).sendKeys("SuperSecretPassword!");
        driver.findElement(clickLogin).click();
        //validation of AfterLogin message
        WebElement message1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("flash")));
        String ActualMessage1 = message1.getText();
        //Using Assertion
        Assert.assertTrue(ActualMessage1.contains("Your username is invalid!"));
    }
    @AfterMethod
    void quitechrome(){
        driver.quit();
    }



}
