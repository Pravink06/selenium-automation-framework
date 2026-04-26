package com.pravin.automation.Zlearning.phase1_Selenium_Concepts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OO4_ElementpresentbutNOTclickable {

   void elementclickable (){

       WebDriver driver = new ChromeDriver();
       WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
       driver.manage().window().maximize();
       //launch URL
       driver.get("https://www.testtrack.org/");
       //Step:2 wait for Module001: Button-Demo gets load

       WebElement Module001=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[contains (text(), 'Button Demo') ]")));
       Module001.click();

    //Step 3: is element exist or not
       try {
           WebElement isexist = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("disabled-button")));
           String btnname = isexist.getText();
           System.out.println("Button is Exist and button name is = " + btnname);
       } catch (Exception e) {
           System.out.println("Button not exists");
       }
    //Step 4: Is element visiable
    try{
        WebElement isbtnvisiable = driver.findElement(By.id("disabled-button"));
        wait.until(ExpectedConditions.visibilityOf(isbtnvisiable));
        String isbtnvisitext = isbtnvisiable.getText();
        System.out.println("Button is visiable and button name is = "+ isbtnvisitext);
    }catch (Exception e){
        System.out.println("Button not Visiable");
    }


    //Step 5: button clicking try and let know user if it is clickable or not
       try {
           WebElement btn = wait.until(
                   ExpectedConditions.elementToBeClickable(By.id("disabled-button"))
           );
           btn.click();
       } catch (Exception e) {
           System.out.println("Button is not clickable");
       }


    driver.quit();


   }

   public static void main (String [] args) {
       //OO4_ElementpresentbutNOTclickable jj = new OO4_ElementpresentbutNOTclickable();
       //jj.elementclickable();

       OO4_ElementpresentbutNOTclickable_Updated_clean uy= new OO4_ElementpresentbutNOTclickable_Updated_clean();
       uy.elementclickable();
   }

}
