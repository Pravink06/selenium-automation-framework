package com.pravin.automation.base;

import com.pravin.automation.utils.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static void initDriver(){

        String browser = ConfigReader.get("browser");

        if(browser.equalsIgnoreCase("chrome")){
            driver.set(new ChromeDriver());
        } else {
            throw new RuntimeException("Browser not supported");
        }
    }

    public static WebDriver getDriver(){
        return driver.get();
    }

    public static void quitDriver(){
        driver.get().quit();
        driver.remove();
    }
}