package com.orangehrm.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class BaseClass {

	protected Properties prop;
	protected WebDriver driver;

	public void loadConfig() throws IOException {
		prop = new Properties();
		FileInputStream fis = new FileInputStream("src/main/resources/config.properties");
		prop.load(fis);

	}

	@BeforeMethod
	public void setup() throws IOException {
		System.out.println("Setting up WebDriver for:" + this.getClass().getSimpleName());
		launchBrowser();
		configureBrowser();
		
	
	}
	/*
	 * Initialize the WebDriver based on browser defined in config.properties file
	 */

	private void launchBrowser() {
		String browser = prop.getProperty("browser");
		if (browser.contentEquals("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();

		} else if (browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();

		} else {
			throw new IllegalArgumentException("Browser not Supported:" + browser);
		}

	}
	/*
	 * Configure browser settings such as implicit wait, maximize the browser and
	 * navigate to the URL
	 */
	private void configureBrowser() {
		int implicitwait = Integer.parseInt(prop.getProperty("implicitwait"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitwait));
		// maximize the browser
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));

	}


	@AfterMethod
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}

	}
}
