package com.pravin.automation.Zlearning.phase1_Selenium_Concepts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class OO3_StaleElement {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://the-internet.herokuapp.com/dynamic_content");

        try {
            // Step 1: Capture element
            WebElement textElement = driver.findElement(
                    By.xpath("(//div[@class='large-10 columns'])[1]")
            );

            System.out.println("Before Refresh:");
            System.out.println(textElement.getText());

            // Step 2: Click refresh
            driver.findElement(By.linkText("click here")).click();

            // Step 3: Try using OLD reference (this will FAIL)
            System.out.println("\nTrying OLD element after refresh:");
            System.out.println(textElement.getText()); // 💥 StaleElementReferenceException

        } catch (Exception e) {
            System.out.println("\nExpected Exception Occurred:");
            System.out.println(e.getClass().getSimpleName());
        }

        try {
            // Step 4: Correct approach (re-locate element)
            WebElement newElement = driver.findElement(
                    By.xpath("(//div[@class='large-10 columns'])[1]")
            );

            System.out.println("\nAfter Refresh (Re-located element):");
            System.out.println(newElement.getText());

        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        }

        driver.quit();
    }


}
