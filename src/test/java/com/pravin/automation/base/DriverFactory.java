package com.pravin.automation.base;

import com.pravin.automation.utils.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {

    public static WebDriver createDriver(){

        String browser = ConfigReader.get("browser");

        if(browser.equalsIgnoreCase("chrome")){
            return new ChromeDriver();
        }

        throw new RuntimeException("Browser not supported");
    }
}