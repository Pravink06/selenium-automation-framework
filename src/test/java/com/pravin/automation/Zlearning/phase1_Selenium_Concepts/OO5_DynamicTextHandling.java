package com.pravin.automation.Zlearning.phase1_Selenium_Concepts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OO5_DynamicTextHandling {

    String username= "tomsmith";
    String password= "SuperSecretPassword!";
    //String successexpectedtext= "You logged into a secure area!";

    void dynamictexthandling()  {

        WebDriver driver = new ChromeDriver();
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        //launch URL
        driver.get("https://the-internet.herokuapp.com/login");

        //Enter Username
        WebElement typeusername = wait.until(ExpectedConditions.elementToBeClickable(By.id("username")));
        typeusername.sendKeys(username);

        //Enter password
        WebElement typepassword = wait.until(ExpectedConditions.elementToBeClickable(By.id("password")));
        typepassword.sendKeys(password);

        //Hit Login button
        WebElement hitlogin = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));
        hitlogin.click();

        if (username.matches("tomsmith")){
            if(password.matches("SuperSecretPassword!")){
                WebElement actualsuccesstextvalidation = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains (., 'You logged into a secure area!') and @class='flash success']")));
                String actualsuccessMSG = actualsuccesstextvalidation.getText();
                System.out.println("Successfully logged in message: "+ actualsuccessMSG );
            }else if (!password.equals("SuperSecretPassword!")) {
                WebElement invalidpassword = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains (., 'Your password is invalid!') and @class='flash error']")));
                String ivdpwdMSG = invalidpassword.getText();
                System.out.println("password is Invalid message: "+ ivdpwdMSG );
            }
                
        } else if (!username.equals("tomsmith")) {
            WebElement invaliduser = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains (., 'Your username is invalid!') and @class='flash error']")));
            String ivduserMSG = invaliduser.getText();
            System.out.println("Username is Invalid message: "+ ivduserMSG );
            
        }
            
        }

        public static void main (String[] args)  {
            OO5_DynamicTextHandling uu= new OO5_DynamicTextHandling();
            uu.dynamictexthandling();
        }


    }

