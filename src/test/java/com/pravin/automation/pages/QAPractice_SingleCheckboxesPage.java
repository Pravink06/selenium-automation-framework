package com.pravin.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class QAPractice_SingleCheckboxesPage {
    WebDriver driver;
    WebDriverWait wait;

    //Locators
    By Singlecheckboxfield = By.xpath("//a[@href='/elements/checkbox/single_checkbox']");
    By checkbox = By.id("id_checkbox_0");
    By CheckBoxLabel = By.xpath("//label[@class='form-check-label']");
    By Submitbutton = By.id("submit-id-submit");
    By resultText= By.xpath("//p[@id='result-text' and contains (., 'select me or not')]");

    //Constructor
    public QAPractice_SingleCheckboxesPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver , Duration.ofSeconds(10));
    }
    //Action 1- Navigation validation
    public boolean navigateTo_SingleCheckBox(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(Singlecheckboxfield)).isDisplayed();
    }

    //Action 2- checkBox label
    public String getCheckBoxLabel(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(CheckBoxLabel)).getText();
    }
    public boolean isCheckboxlabeledas (String expectedcheckboxlabel){
        return getCheckBoxLabel().equals(expectedcheckboxlabel);
    }

    //Action 3- Check the box
    public void ChecktheBox(){
        wait.until(ExpectedConditions.elementToBeClickable(checkbox)).click();
    }

    //Action 4- Click On Submit
    public void ClickOnSubmit(){
        wait.until(ExpectedConditions.elementToBeClickable(Submitbutton)).click();

    }

    //Action 5- get Result text
    public String getSubmitResultText(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(resultText)).getText();
    }
    public boolean issubmitmessagevisiable(String expsubmitemessage){
        return getSubmitResultText().contains("select me or not");
    }



}
