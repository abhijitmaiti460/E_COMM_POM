package com.ibm.basetest;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

public class BaseTest {
	 public static WebDriver driver;
	 public static String screenshotSubFolderName;
	
	 @BeforeSuite
	 @Parameters({"browserName","url"})
	public void setup(String browserName,String url) {
		switch (browserName.toLowerCase()) {
		case "chrome":
			driver = new ChromeDriver();
			break;
			
		case "firefox":
			driver = new FirefoxDriver();
			break;
		
		case "edge":
			driver = new EdgeDriver();
			break;
		default:
			break;
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(45));
		driver.get(url);
		
	}
	
	 @AfterSuite
	    public void tearDown() {
	       driver.quit();
	    }
	 
	

}
