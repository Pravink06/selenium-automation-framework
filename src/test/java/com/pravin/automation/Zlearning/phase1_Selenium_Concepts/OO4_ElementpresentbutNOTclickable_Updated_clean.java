package com.pravin.automation.Zlearning.phase1_Selenium_Concepts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OO4_ElementpresentbutNOTclickable_Updated_clean {
    public void elementclickable() {

        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.get("https://www.testtrack.org/");

        // Step 1: Navigate to module
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//h3[contains(text(),'Button Demo')]")
        )).click();

        By disabledBtn = By.id("disabled-button");

        // Step 2: Check presence (optional)
        if (driver.findElements(disabledBtn).size() > 0) {
            System.out.println("Button exists");
        } else {
            System.out.println("Button does not exist");
            driver.quit();
            return;
        }

        // Step 3: Check clickable
        try {
            WebElement btn = wait.until(
                    ExpectedConditions.elementToBeClickable(disabledBtn)
            );
            btn.click();
            System.out.println("Button clicked");
        } catch (Exception e) {
            System.out.println("Button is present but NOT clickable");
        }

        driver.quit();
    }
}
