package com.pravin.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ButtonPage {

    WebDriver driver;
    WebDriverWait wait;

    //Locator
    By simplebutton = By.id("submit-id-submit");
    By resultText = By.id("result-text");

    // Constructor
    public ButtonPage (WebDriver driver){
        this.driver= driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    //Action1: to be perform a click on button
    public void clickbutton (){
        wait.until(ExpectedConditions.elementToBeClickable(simplebutton)).click();
    }
    // Action 2 : To be perform the results text validation
    public String getresulttext (){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(resultText)).getText();
    }


}
