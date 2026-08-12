package com.orangehrm.actiondriver;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.orangehrm.utilities.ConfigReader;

public class DriverManager {

    // Encapsulation
    private static WebDriver driver;

    // Private constructor
    private DriverManager() {
    }

    // Abstraction + Polymorphism
    public static void initializeDriver() {

        String browser = ConfigReader.getProperty("browser");

        int wait = ConfigReader.getIntProperty("implicitwait");

        if (browser.equalsIgnoreCase("chrome")) {

            driver = new ChromeDriver();

        } else if (browser.equalsIgnoreCase("firefox")) {

            driver = new FirefoxDriver();

        } else if (browser.equalsIgnoreCase("edge")) {

            driver = new EdgeDriver();

        } else {

            throw new IllegalArgumentException(
                    "Invalid browser: " + browser);
        }

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(
                Duration.ofSeconds(wait));
    }

    // Encapsulation
    public static WebDriver getDriver() {
        return driver;
    }

    // Close browser
    public static void quitDriver() {

        if (driver != null) {

            driver.quit();

            driver = null;
        }
    }
}