package com.pravin.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class QAPractice_ButtonsPage {

    WebDriver driver;
    WebDriverWait wait;

    // Locators
    By SimpleButton = By.xpath("//a[@href='/elements/button/simple']");
    By Clickbutton = By.id("submit-id-submit");
    By resulttext = By.id("result-text");

    //Constructor
    public QAPractice_ButtonsPage (WebDriver driver){
        this.driver= driver;
        this.wait= new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // validate navigation
    public boolean isSimplebuttonNavigated (String isdisplayed){
       return wait.until(ExpectedConditions.visibilityOfElementLocated(SimpleButton)).isDisplayed();
    }

    //Validate Click Button Label Text
    public String getClickButton_label(){
       return wait.until(ExpectedConditions.visibilityOfElementLocated(Clickbutton)).getAttribute("value");
    }
    public boolean isClickButtonlabeled (String expectedbuttonText){
        return getClickButton_label().equals(expectedbuttonText);
    }

    //Click on Button
    public void ClickonButton(){
        wait.until(ExpectedConditions.elementToBeClickable(Clickbutton)).click();
    }

    //Get Submitted Message
    public String getResultText(){
       return  wait.until(ExpectedConditions.visibilityOfElementLocated(resulttext)).getText();
    }
    public boolean isResultTextVisiable (String expectedResulttext){
        return  getResultText().contains(expectedResulttext);
    }





}
