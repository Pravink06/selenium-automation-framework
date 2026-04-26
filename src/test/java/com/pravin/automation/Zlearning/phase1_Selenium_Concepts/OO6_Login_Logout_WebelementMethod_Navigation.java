package com.pravin.automation.Zlearning.phase1_Selenium_Concepts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class OO6_Login_Logout_WebelementMethod_Navigation {

    void endtoendloginandlogout() throws InterruptedException {
        String username = "tomsmith";
        String password = "SuperSecretPassword!";

        //handleing alerts - An alert is blocking the browser , so nothing can validate.
        //<Unwanted Code>
        ChromeOptions options = new ChromeOptions();

        Map<String, Object> prefs = new HashMap<>();

// Disable password manager
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);

// Disable password leak detection (THIS is what you're missing)
        prefs.put("profile.password_manager_leak_detection", false);

        options.setExperimentalOption("prefs", prefs);

// Optional but strong prevention
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-save-password-bubble");
        //</Unwanted code>

        //main implementation starts from here.

        WebDriver driver = new ChromeDriver(options);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/login");

        // Enter Username
        WebElement typeusername=wait.until(ExpectedConditions.elementToBeClickable(By.id("username")));
        typeusername.clear();
        typeusername.sendKeys(username);
        String usernameEnterED = typeusername.getAttribute("value");
        if (usernameEnterED.equals(username)){
            System.out.println("Correct Username is Entered : "+ usernameEnterED);
        }else {
            System.out.println("Wrong username is entered or Value as Attribute is not available ");
        }

        // Enter Password
        WebElement typepwd=wait.until(ExpectedConditions.elementToBeClickable(By.id("password")));
        typepwd.clear();
        typepwd.sendKeys(password);
        String pwdEnterED = typepwd.getAttribute("value");
        if (password.equals(pwdEnterED)){
            System.out.println("Correct passsword is Entered : "+ pwdEnterED);
        }

        // Click Login
        WebElement loginbutton=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@type='submit']")));
        if (loginbutton.isEnabled()){
            System.out.println("Login button is Enabled");
            loginbutton.click();
        }else {
            System.out.println("Login Button is disabled");
        }

        //Validation after Login - Single locator handles both success and failure
        WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("flash")));
        String actualmessage= message.getText();
        if (actualmessage.contains("You logged into a secure area!")){
            System.out.println("User logged in correctly and Message is : "+ actualmessage);
        } else if (actualmessage.contains("Your password is invalid!")) {
            System.out.println("Password is Wrong :"+ actualmessage);
        } else if (actualmessage.contains("Your username is invalid!")) {
            System.out.println("Username is Wrong :"+ actualmessage);
        }

        //Navigate to back -----Task
        driver.navigate().back(); Thread.sleep(3000);
        String acturl= driver.getCurrentUrl();
        String expurl= "https://the-internet.herokuapp.com/login";
        //Validation 1: at back page
        if(acturl.equals(expurl)){
            System.out.println("Back click navigate to :"+acturl);
            System.out.println("Validation 1:Navigation to back is Successfully");
        }else {
            System.out.println("After navigating to back the page is not navigating to Expected URL");
        }



        //validation 2: is Username exist when clicked on back
        WebElement isusernameexist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
        String whatusername= isusernameexist.getText();
        System.out.println("username after hitting back : "+whatusername);
        if (whatusername.equals(username)){
            System.out.println("Validation 2:Username is Still same as What we have entered initially");
        }else {
            System.out.println("Username is changed from What we have entered initially" + whatusername);
        }

        //Validation 3: is password exist when clicked on back
        WebElement ispwdexist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
        String whatpwd= isusernameexist.getText();
        System.out.println("Password name after hitting back : "+whatpwd);
        if (whatpwd.equals(password)){
            System.out.println("Validation 3:Password is Still same as What we have entered initially");
        }else {
            System.out.println("Password is changed from What we have entered initially"+whatpwd);
        }


        driver.quit();
    }

    public static void main (String[] args) throws InterruptedException {
        OO6_Login_Logout_WebelementMethod_Navigation uu= new OO6_Login_Logout_WebelementMethod_Navigation();
        uu.endtoendloginandlogout();
    }








}
