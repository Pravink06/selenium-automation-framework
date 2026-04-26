package com.pravin.automation.Zlearning.phase1_Selenium_Concepts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OO2_Locators_Dynamic {

    public void dynamiclocator() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //launch URL
        driver.get("https://the-internet.herokuapp.com/dynamic_controls"); Thread.sleep(3000);
        //clear cookies and cashes
        driver.manage().deleteAllCookies();

        //Clicking on Checkbox
        driver.findElement(By.xpath("//div[@id='checkbox']//input[@type='checkbox']")).click();
        driver.findElement(By.xpath("//button[text()='Remove']")).click();Thread.sleep(5000);

        //validation message
        String expectedtext = "It's gone!";   //Expected message
        String actualtext = driver.findElement(By.xpath("//form[@id='checkbox-example']//p[@id='message']")).getText();

        if (actualtext.equals(expectedtext)){
            System.out.println("Actual Text is = "+ actualtext + " and hence Remove button is successfull");
        }else {
            System.out.println("Something wrong");
        }


    }

    //task 2 Type Text

    public void dynamictextbox() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //launch URL
        driver.get("https://the-internet.herokuapp.com/dynamic_controls"); Thread.sleep(3000);
        //clear cookies and cashes
        driver.manage().deleteAllCookies();

        //Click On Enable
        driver.findElement(By.xpath("//form[@id='input-example']//button[text()='Enable']")).click();

        //wait for message -
        WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));

        String actualtext02 = message.getText();

        String expectedtext02 = "It's enabled!"; //Expected message


        if (actualtext02.equals(expectedtext02)){
            System.out.println("Actual Text is = "+ actualtext02 + " and TextBox is visible now ! ");

        }else {
            System.out.println("Something wrong");
        }

        // Wait for textbox to be clickable
        WebElement typetext = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//form[@id='input-example']//input")));
        typetext.sendKeys("Pravin kolkar");
        driver.quit();

    }

    public static void main (String [] args) throws InterruptedException {
        OO2_Locators_Dynamic mm = new OO2_Locators_Dynamic();
        //mm.dynamiclocator();
        mm.dynamictextbox();
    }
}
