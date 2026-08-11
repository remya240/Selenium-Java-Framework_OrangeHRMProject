package com.orangehrm.pages;

import org.openqa.selenium.WebDriver;
//Encapsulation, Abstraction, and Inheritance when other page classes extend it.
public class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }
}