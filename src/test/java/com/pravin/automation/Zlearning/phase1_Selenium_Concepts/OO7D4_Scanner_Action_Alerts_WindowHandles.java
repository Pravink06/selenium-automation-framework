package com.pravin.automation.Zlearning.phase1_Selenium_Concepts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.Set;

import java.time.Duration;

public class OO7D4_Scanner_Action_Alerts_WindowHandles {

    void dropdownAndSelectClass(){

        //task1- dropdown
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.navigate().to("https://www.testtrack.org/dropdown-demo");

        //task1- dropdown-select by Visibility text
        WebElement HTMLdropdown = wait.until(ExpectedConditions.elementToBeClickable(By.id("native-select")));
        Select dropdownvalue = new Select(HTMLdropdown);
        dropdownvalue.selectByVisibleText("Automated Operation");
        //Validate 01 :
        WebElement selection1= driver.findElement(By.xpath("//span[contains (text(),('Operation'))]"));
        String selection01Text= selection1.getText();
        WebElement actualtext = driver.findElement(By.xpath("//span[contains (text(),('Operation'))]/following::span"));
        String actualtextvalue= actualtext.getText();
        String expselectiontextauto= "auto";
        if (actualtextvalue.equals(expselectiontextauto)){
            System.out.println(selection01Text + ": "+actualtextvalue);
        }
        //Additional validation
        try {
            WebElement dropdownvalueafterselec= wait.until(ExpectedConditions.presenceOfElementLocated(By.id("native-select")));
            String actslctvle= dropdownvalueafterselec.getText();
            if (actslctvle.equals("Automated Operation")){
                System.out.println("DropDown Selection is  : "+ actslctvle);
            }else {
                System.out.println("Get Text wont happens after dropdown is selected");
            }
        } catch (Exception e) {
            System.out.println("catch block ran");
        }
    driver.quit();
    }

    void dropdownbyselectvalue(){
        //task1- dropdown by select value
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.navigate().to("https://www.testtrack.org/dropdown-demo");

        //task1- dropdown-select by Visibility text
        WebElement HTMLdropdown = wait.until(ExpectedConditions.elementToBeClickable(By.id("native-select")));
        Select dropdownvalue1 = new Select(HTMLdropdown);
        dropdownvalue1.selectByValue("override");

        //Validate 01 :
        WebElement selection1= driver.findElement(By.xpath("//span[contains (text(),('Operation'))]"));
        String selection01Text= selection1.getText();
        WebElement actualtext = driver.findElement(By.xpath("//span[contains (text(),('Operation'))]/following::span"));
        String actualtextvalue= actualtext.getText();
        String expselectiontextauto= "override";
        if (actualtextvalue.equals(expselectiontextauto)){
            System.out.println(selection01Text + ": "+actualtextvalue);
        }
    driver.quit();
    }

    void actionclassusage(){
        //task2- Action class
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.navigate().to("https://vinothqaacademy.com/mouse-event/");

        WebElement dblbtn= wait.until(ExpectedConditions.elementToBeClickable(By.id("doubleBtn")));
        WebElement statustext= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("doubleStatus")));
        String beforeclickstatus= statustext.getText();
        System.out.println("Before click status is : "+beforeclickstatus);
        //double click perform
        Actions action = new Actions(driver);
        action.doubleClick(dblbtn).perform();
        System.out.println("Double click action is performed");

        //validation after double click perform
        String expstatus = "Double Click Detected ";
        String afterclickstatus = statustext.getText();
        System.out.println(afterclickstatus);
        if (afterclickstatus.contains("Double Click Detected")){
            System.out.println("Status is changed to : "+ afterclickstatus);
        }else {
            System.out.println("Click fails");
        }
    driver.quit();
    }

    void rightclickmethod() {

        //task2- Action class
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.navigate().to("https://vinothqaacademy.com/mouse-event/");

        WebElement rightbtn= wait.until(ExpectedConditions.elementToBeClickable(By.id("rightBtn")));
        WebElement statustext= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("rightStatus")));
        String beforerightclickstatus= statustext.getText();
        System.out.println("Before click status is : "+beforerightclickstatus);

        Actions rightclickaction = new Actions(driver);
        rightclickaction.contextClick(rightbtn).perform();
        //after right click check whether Menu is getting opened
        WebElement checkmenuopened = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("contextMenu")));
        if (checkmenuopened.isDisplayed()){
            System.out.println("Context Menu is opened");
        }else {
            System.out.println("Context Menu is Not opened");
        }

        //selecting context as : COPY

        WebElement selectCopy= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-action='Copy']")));
        selectCopy.click();

        //after status check
        System.out.println("After click status checking...");
        String afterstatus= statustext.getText();
        System.out.println("After status is : "+ afterstatus);
        if (afterstatus.contains("Selected: Copy")){
            System.out.println("Copy Selected successfully");
        }else {
            System.out.println("Copy Selection is failed");
        }
    driver.quit();
    }

    void alertmethod(){
        //Task 3: Alerts handle
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.navigate().to("https://the-internet.herokuapp.com/javascript_alerts");

        WebElement jsalertbtn=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@onclick='jsAlert()']")));
        jsalertbtn.click();
        System.out.println("JS alert button is clicked successsfully");

        //Validating if alerts is prompted
        String actualjsAlertMessage= driver.switchTo().alert().getText();
        String expectedjsAlertMessage = "I am a JS Alert";
        if (actualjsAlertMessage.contains(expectedjsAlertMessage)){
            System.out.println("JS alert is prompt");
        }else {
            System.out.println("JS alert is NOT prompted");
        }
        //Accepting the alert
        driver.switchTo().alert().accept();

        //Validating success message after Alert clicked
        WebElement succussclicked = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("result")));
        String actulsuccessmessage= succussclicked.getText();
        if (actulsuccessmessage.contains("You successfully clicked an alert")){
            System.out.println("You successfully clicked an alert");
        }else {
            System.out.println("Alert success message is not displyed");
        }
        driver.quit();
    }

    void switchwindowmethod (){
        //Task 4: Window handles
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.navigate().to("https://the-internet.herokuapp.com/windows");

        //click here
        WebElement clickherelink= wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Click Here")));
        clickherelink.click();
        //get Window handles

        Set <String> handles = driver.getWindowHandles();
        for(String handle : handles){
            driver.switchTo().window(handle);
        }
        //Validation on New Window
        //validation 1 : URL validation
        String actualnewwindowURL = driver.getCurrentUrl();
        String expectednewwindowURL = "https://the-internet.herokuapp.com/windows/new";
        String actualpagetitle= driver.getTitle();
        if (actualnewwindowURL.equals(expectednewwindowURL)){
            System.out.println("Click here is navigating to "+ actualpagetitle );
        }else {
            System.out.println("Something Wrong buddy you need to fix that something");
        }
        //validation 2: Actual UI content
        WebElement uitext= wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h3")));
        String actualnewwindowtest=uitext.getText();
        String expectednewwindowtest = "New Window";
        if (actualnewwindowtest.contains(expectednewwindowtest)){
            System.out.println(actualnewwindowtest + "  Is validated successfully");
        }else {
            System.out.println("Something Wrong buddy you need to fix that something");
        }
        driver.quit();
    }


    public static void main (String [] args){
        OO7D4_Scanner_Action_Alerts_WindowHandles we= new OO7D4_Scanner_Action_Alerts_WindowHandles();
        we.dropdownAndSelectClass();
        we.dropdownbyselectvalue();
        we.actionclassusage();
        we.rightclickmethod();
        we.alertmethod();
        we.switchwindowmethod();
    }


}
