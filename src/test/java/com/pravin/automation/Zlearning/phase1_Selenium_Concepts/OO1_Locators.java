package com.pravin.automation.Zlearning.phase1_Selenium_Concepts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OO1_Locators {

    public void locatorpractise(){

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.testtrack.org/");
        //Click on Module001
        driver.findElement(By.xpath("//h3[contains (text(), 'Button Demo') ]")).click();
        //Click on Primary Button
        driver.findElement(By.xpath("//button[contains (@id, 'primary-button') ]")).click();

        System.out.println("Executed");

        driver.close();
    }

    //main method to run programs
    public static void main (String [] args){

        //creating object
        OO1_Locators oo1 = new OO1_Locators();
        oo1.locatorpractise();
    }
}
