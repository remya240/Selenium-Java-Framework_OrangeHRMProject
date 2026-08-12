package com.orangehrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    // Locators
    private By username =
            By.name("username");

    private By password =
            By.name("password");

    private By loginButton =
            By.xpath("//button[@type='submit']");

    // Constructor
    public LoginPage(WebDriver driver) {

        super(driver);
    }

    // Enter username
    public void enterUsername(String usernameValue) {

        driver.findElement(username)
              .sendKeys(usernameValue);
    }

    // Enter password
    public void enterPassword(String passwordValue) {

        driver.findElement(password)
              .sendKeys(passwordValue);
    }

    // Click login
    public void clickLogin() {

        driver.findElement(loginButton)
              .click();
    }

    // Complete login
    public void login(String usernameValue,
                      String passwordValue) {

        enterUsername(usernameValue);

        enterPassword(passwordValue);

        clickLogin();
    }
}