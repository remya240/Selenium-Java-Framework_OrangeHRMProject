package com.orangehrm.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.orangehrm.base.BaseClass;
import com.orangehrm.pages.HomePage;
import com.orangehrm.pages.LoginPage;
import com.orangehrm.utilities.ConfigReader;

public class LoginTest extends BaseClass {

    @Test
    public void validLoginTest() {

        // Create LoginPage object
        LoginPage loginPage =
                new LoginPage(driver);

        // Login
        loginPage.login(
                ConfigReader.getProperty("username"),
                ConfigReader.getProperty("password")
        );

        // Create HomePage object
        HomePage homePage =
                new HomePage(driver);

        // Verify Dashboard
        Assert.assertTrue(
                homePage.isDashboardDisplayed(),
                "Dashboard is not displayed"
        );

        System.out.println(
                "Login test passed successfully");
    }
}