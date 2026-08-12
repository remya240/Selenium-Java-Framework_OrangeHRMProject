package com.orangehrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    private By dashboard =
            By.xpath("//h6[text()='Dashboard']");

    public HomePage(WebDriver driver) {

        super(driver);
    }

    public boolean isDashboardDisplayed() {

        return driver.findElement(dashboard).isDisplayed();
    }
}