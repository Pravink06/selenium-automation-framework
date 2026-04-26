package com.pravin.automation.Zlearning.phase1_Selenium_Concepts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OO6_D3_LoginANDValidate {

    String username1= "testuser";
    String password1= "password123";

    void loginpage(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //launch URL
        driver.get("https://www.testtrack.org/");
        // Launch Module003 Login form Demo
        WebElement clickonModule003Login = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h3[contains(text(),'Login Form Demo')]")));
        clickonModule003Login.click();

        //Login page URL validation
        String actualurl = driver.getCurrentUrl();
        if (actualurl.equals("https://www.testtrack.org/login-demo")){
            System.out.println("Login page is opened");
        }

        //Type username
        WebElement typeusername = wait.until(ExpectedConditions.elementToBeClickable(By.id("username")));
        typeusername.clear();
        typeusername.sendKeys(username1);
        String usernameentered = typeusername.getAttribute("value");
        if (usernameentered.equals(username1)){
            System.out.println("Username Entered Correctly");
        }

        //Type password
        WebElement typepassword = wait.until(ExpectedConditions.elementToBeClickable(By.id("password")));
        typepassword.clear();
        typepassword.sendKeys(password1);
        String pwdentered = typepassword.getAttribute("value");
        if (pwdentered.equals(password1)){
            System.out.println("password Entered Correctly");
        }

        //check the checkbox - Also think about what if click does not happen
        WebElement checkbox=driver.findElement(By.id("remember-me"));
        checkbox.click();
        //Validate if checkbox is checked
        if (checkbox.isSelected() || checkbox.getAttribute("aria-checked").equals("true")) {
            System.out.println("Checkbox is checked");
        } else {
            System.out.println("Checkbox NOT checked");
        }

        //click on submit.
        WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("login-submit")));
        submitButton.click();

        //  validation 1: SINGLE MESSAGE validation with 1 locator
        WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='text-sm font-futura']")));
        //Get auth message
        String actualMSG= message.getText();

        // print auth message
        System.out.println("Application Response : "+ actualMSG);
        //Now validate
        if (actualMSG.contains("AUTHENTICATION SUCCESSFUL")){
            System.out.println("validation passed");
        }else {
            System.out.println("validation failed");
        }

    driver.quit();
    }

    public static void main (String[] args){
        OO6_D3_LoginANDValidate hh = new OO6_D3_LoginANDValidate();
        hh.loginpage();
    }
}
