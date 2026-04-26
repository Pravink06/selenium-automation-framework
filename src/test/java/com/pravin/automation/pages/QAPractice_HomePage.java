package com.pravin.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class QAPractice_HomePage {

    WebDriver driver;
    WebDriverWait wait;

    //locators
    By textinputurl = By.xpath("//a[contains (., 'Text input')]");
    By simplebuttonurl= By.xpath("//a[contains (., 'Simple button')]");
    By singlecheckboxurl= By.xpath("//a[contains (., 'Single checkbox')]");
    By textareaurl= By.xpath("//a[@href='/elements/textarea/single']");
    By selectinput = By.xpath("//a[@href='/elements/select/single_select']");







}

