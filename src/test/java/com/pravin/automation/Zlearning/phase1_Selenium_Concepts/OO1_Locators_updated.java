package com.pravin.automation.Zlearning.phase1_Selenium_Concepts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OO1_Locators_updated {

    public void locator01(){

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        try {

            //open URL
            driver.get("https://www.testtrack.org/");
            Thread.sleep(3000);

            // Click on Module001
            driver.findElement(By.xpath("//h3[contains(text(),'Button Demo')]")).click();
            Thread.sleep(3000);
            //Navigation validation
            if (driver.getCurrentUrl().contains("button-demo")){
                System.out.println("Navigation correct");
            }else {
                System.out.println("Something is wrong");
            }

            // Click on Primary Button
            driver.findElement(By.xpath("//button[contains(@id,'primary-button')]")).click();
            Thread.sleep(3000);



            //Validation on Primary button
            boolean isPrimaryButtonDisplayed = driver.findElement(By.xpath("//button[contains(@id,'primary-button')]")).isDisplayed();
            if (isPrimaryButtonDisplayed) {
                System.out.println("primary button was clicked.");
            } else {
                System.out.println("primary button was NOT clicked.");
            }

        }catch (Exception e){
            System.out.println("Test Failed: " + e.getMessage());
        } finally {
            driver.quit();
        }

    }
    //main method to run programs
    public static void main (String [] args){

        //creating object
        OO1_Locators_updated oo2 = new OO1_Locators_updated();
        oo2.locator01();
    }

}
