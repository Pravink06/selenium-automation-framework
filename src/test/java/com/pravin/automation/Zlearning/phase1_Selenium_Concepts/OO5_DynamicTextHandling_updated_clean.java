package com.pravin.automation.Zlearning.phase1_Selenium_Concepts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OO5_DynamicTextHandling_updated_clean {

    String username= "tomsmit";
    String password= "SuperScretPassword!";
    void dynamictexthandling() {

        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/login");

        // Enter Username
        wait.until(ExpectedConditions.elementToBeClickable(By.id("username")))
                .sendKeys(username);

        // Enter Password
        wait.until(ExpectedConditions.elementToBeClickable(By.id("password")))
                .sendKeys(password);

        // Click Login
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")))
                .click();

        // 🔥 SINGLE MESSAGE ELEMENT
        WebElement message = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("flash"))
        );

        String actualMessage = message.getText();
        System.out.println("Application Response: " + actualMessage);

        // ✅ Validate based on UI response
        if (actualMessage.contains("You logged into a secure area!")) {
            System.out.println("Login Success");
        } else if (actualMessage.contains("Your username is invalid!")) {
            System.out.println("Invalid Username");
        } else if (actualMessage.contains("Your password is invalid!")) {
            System.out.println("Invalid Password");
        } else {
            System.out.println("Unexpected response");
        }

        driver.quit();
    }

    public static void main (String[]args){
        OO5_DynamicTextHandling_updated_clean yy= new OO5_DynamicTextHandling_updated_clean();
        yy.dynamictexthandling();
    }
}

//This code demonstrates dynamic text handling by validating the application’s response after login using a single stable locator (flash message). Instead of relying on input conditions, it captures the actual UI message and verifies success or failure using partial text matching. This approach ensures reliable validation even when messages change slightly, making the test more robust and maintainable.
