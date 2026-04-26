package com.pravin.automation.Zlearning.phase2_TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class OO2_User_Login_Logout_Test_Clean_Code {
    WebDriver driver;
    WebDriverWait wait;

    // 🔥 Locators (centralized)
    By username = By.id("username");
    By password = By.id("password");
    By loginBtn = By.xpath("//button[@type='submit']");
    By message = By.id("flash");

    // 🔥 Setup
    @BeforeMethod
    void browserSetup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/login");
    }

    // 🔥 Reusable method (important step before POM)
    void login(String user, String pass){
        driver.findElement(username).clear();
        driver.findElement(username).sendKeys(user);

        driver.findElement(password).clear();
        driver.findElement(password).sendKeys(pass);

        driver.findElement(loginBtn).click();
    }

    // ✅ Positive Test
    @Test
    void validLogin_shouldSucceed(){

        login("tomsmith", "SuperSecretPassword!");

        WebElement msg = wait.until(
                ExpectedConditions.visibilityOfElementLocated(message)
        );

        String actualMessage = msg.getText();

        Assert.assertTrue(
                actualMessage.contains("You logged into a secure area!"),
                "Expected success message not displayed"
        );
    }

    // ✅ Negative Test
    @Test
    void invalidLogin_shouldShowError(){

        login("wrongUser", "SuperSecretPassword!");

        WebElement msg = wait.until(
                ExpectedConditions.visibilityOfElementLocated(message)
        );

        String actualMessage = msg.getText();

        Assert.assertTrue(
                actualMessage.contains("Your username is invalid!"),
                "Expected error message not displayed"
        );
    }

    // 🔥 Teardown
    @AfterMethod
    void closeBrowser(){
        driver.quit();
    }


}
