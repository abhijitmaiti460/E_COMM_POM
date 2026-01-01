package com.ibm.basetest;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTest {
	 public static WebDriver driver;
	
	 @BeforeSuite
	public void setup() {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(45));
		driver.get("https://www.demoblaze.com/index.html");
		
	}
	
	 @AfterSuite
	    public void tearDown() {
	       driver.quit();
	    }

}
