package com.pravin.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginPage {

    WebDriver driver;
    WebDriverWait wait;

    // Locators
    By username = By.id("username");
    By password = By.id("password");
    By loginBtn = By.xpath("//button[@type='submit']");
    By message = By.id("flash");

    // Constructor
    public LoginPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Actions
    private void enterUsername(String user){
        driver.findElement(username).clear();
        driver.findElement(username).sendKeys(user);
    }

    private void enterPassword(String pass){
        driver.findElement(password).clear();
        driver.findElement(password).sendKeys(pass);
    }

    private void clickLogin(){
        driver.findElement(loginBtn).click();
    }

    // Business action
    public void login(String user, String pass){
        enterUsername(user);
        enterPassword(pass);
        clickLogin();
    }

    // Result
    public String getMessage(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(message)).getText();
    }

    public boolean isLoginSuccessful(){
        return getMessage().contains("You logged into a secure area!");
    }
}