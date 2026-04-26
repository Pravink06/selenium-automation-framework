package com.pravin.automation.Zlearning.phase1_Selenium_Concepts;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class FirstTest {


        @Test
        public void launchBrowser() {

            WebDriver driver = new ChromeDriver();

            driver.get("https://www.google.com");

            System.out.println("Title: " + driver.getTitle());

            driver.quit();
        }
    }

