package com.pravin.automation.Zlearning.phase2_TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class OO3_ToolTip_Test {

    WebDriver driver;
    WebDriverWait wait;


    @BeforeMethod
    void Setup (){
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://vinothqaacademy.com/mouse-event/");
    }

    @Test
    void verify_tooltip(){

        WebElement hoveronMe = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tooltipTarget")));
        //Creating Action class
        Actions action = new Actions(driver);
        action.moveToElement(hoveronMe).perform();
        //validation of tool tip status change
       // WebElement tooltipstatus = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tooltipStatus")));
        //String actualtooltipstatus = tooltipstatus.getText();

       wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("tooltipStatus"), "Tooltip Visible"));
       String actulstatusmessage= driver.findElement(By.id("tooltipStatus")).getText();

        Assert.assertTrue(actulstatusmessage.contains("Tooltip Visible"));
    }

    @AfterMethod
        void quitechrome(){
        driver.quit();
    }

}
