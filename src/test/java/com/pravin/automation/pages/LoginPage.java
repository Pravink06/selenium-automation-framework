package com.pravin.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    WebDriver driver;
    WebDriverWait wait;

    //Locators
    // 🔥 Locators (centralized)
    By username = By.id("username");
    By password = By.id("password");
    By loginBtn = By.xpath("//button[@type='submit']");
    By message = By.id("flash");

    //Constructor

    public LoginPage(WebDriver driver){
        this.driver= driver;
        this.wait= new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    //Action 1 - Enter username
    private void enterusername (String user){
        driver.findElement(username).clear();
        driver.findElement(username).sendKeys(user);
    }

    //Action 2- Enter password
    private void enterpassword (String pass){
        driver.findElement(password).clear();
        driver.findElement(password).sendKeys(pass);
    }

    //Action 3- Click on Login Button
    private void clickonLoginbutton (){
        driver.findElement(loginBtn).click();
    }

    //Action 4- get message
    public String getmessage(){

        return wait.until(ExpectedConditions.visibilityOfElementLocated(message)).getText();
    }

    //Boolean condition //Framework building mindset
    public boolean isloginsuccessful(){
        return getmessage().contains("You logged into a secure area!");
    }

    //boolean condition //framework building for negative values
    public boolean isloginfailed (){
        return getmessage().contains("invalid");
    }



    //Business method
    public void login (String user , String pass){
        enterusername(user);
        enterpassword(pass);
        clickonLoginbutton();
    }

}
