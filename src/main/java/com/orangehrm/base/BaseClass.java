package com.orangehrm.base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.orangehrm.actiondriver.DriverManager;
import com.orangehrm.utilities.ConfigReader;

public class BaseClass {

    // Encapsulation
    protected WebDriver driver;

    @BeforeMethod
    public void setup() {

        System.out.println(
                "Setting up WebDriver for: "
                        + this.getClass().getSimpleName());

        // Start browser
        DriverManager.initializeDriver();

        // Get driver
        driver = DriverManager.getDriver();

        // Open application
        driver.get(ConfigReader.getProperty("url"));
    }

    @AfterMethod
    public void tearDown() {

        DriverManager.quitDriver();
    }
}