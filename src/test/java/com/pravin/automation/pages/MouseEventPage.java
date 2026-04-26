package com.pravin.automation.pages;

import com.pravin.automation.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MouseEventPage  {

    //WebDriver initialization
    WebDriver driver;
    WebDriverWait wait;

    //Locator
    By hoveronme = By.id("tooltipTarget");
    By tooltipStatus = By.id("tooltipStatus");

    //Constructor
    public MouseEventPage (WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    //Action preparation 1 : move mouse on element
    void movemousetoelement (){
        Actions action = new Actions(driver);
        WebElement element = driver.findElement(hoveronme);
        action.moveToElement(element).perform();
    }

    //Action preparation 2: Get the text upon hover over on element

    public String gettooltipstatus (){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(tooltipStatus)).getText();
    }

    //Business method
    public void tooltipstatus(){
        movemousetoelement();
    }






}
