package com.ibm.element;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlertHandel {
	WebDriver driver;
	Alert alert;
	WebDriverWait wait;
	
	public AlertHandel(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	public String alertHandel() {
		
		try {
			alert = wait.until(ExpectedConditions.alertIsPresent());
			alert = driver.switchTo().alert();
			String result = alert.getText();
			System.out.println(result);
			alert.accept();
			return result;
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return " ";
		
	}

}
