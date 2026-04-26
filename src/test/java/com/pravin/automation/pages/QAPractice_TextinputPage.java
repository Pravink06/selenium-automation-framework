package com.pravin.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class QAPractice_TextinputPage {
    WebDriver driver;
    WebDriverWait wait;

    //Locators
    By textinputurl = By.xpath("//a[contains (., 'Text input')]");
    By textStringbox = By.id("id_text_string");
    By resulttext = By.id("result-text");
    By errormessage = By.id("error_1_id_text_string");
    //By error2charlocate= By.xpath("//span[@id='error_1_id_text_string' and contains (., 'Please enter 2 or more characters')]");

    // Constructor
    public QAPractice_TextinputPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    //Action 1- Navigate to text Input page
    public void openTextInputPage() {
        wait.until(ExpectedConditions.elementToBeClickable(textinputurl)).click();
    }

    //Action 2 - Validate Page Open (strong validation)
    public boolean isTextInputPageOpened(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(textStringbox)).isDisplayed();
    }

    //Action 3- Enter Text and Submit
    public void enterTextAndSubmit(String text) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(textStringbox)).clear();
        driver.findElement(textStringbox).sendKeys(text + Keys.ENTER  );
    }

    //Action 4 - Get Result Message
    public String getmessage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(resulttext)).getText();
    }
    public boolean isenteredTextVisiable (String expectedText){

        return getmessage().contains(expectedText);
    }

    //Action 5- Get Error Message
    public String getErrorMessage (){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(errormessage)).getText();
    }
    public boolean iserrormessagevisiable (String ExpectedErrorText){
        return getErrorMessage().contains(ExpectedErrorText);
    }

    //Action 6- Get Min 2 error message
    //public String min2errormessage (){
      //  return wait.until(ExpectedConditions.visibilityOfElementLocated(errormessage)).getText();
    //}
    //public boolean ismin2errormessage (String expected2errortext){

      //  return min2errormessage().contains(expected2errortext);
    //}





}
