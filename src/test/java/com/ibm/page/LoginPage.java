package com.ibm.page;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestListener;

import com.ibm.element.AlertHandel;

public class LoginPage implements ITestListener{
	WebDriver driver;
	WebDriverWait wait;

	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
	}
	
	By xpathofLoginLink = By.xpath("//*[@id=\"login2\"]");
	By xpathofUsername = By.xpath("//*[@id=\"loginusername\"]");
	By xpathofPassword = By.xpath("//*[@id=\"loginpassword\"]");
	By xpathofCloseButton =By.xpath("//*[@id=\"logInModal\"]/div/div/div[3]/button[1]");
	By xpathofCrossButton = By.xpath("//*[@id=\"logInModal\"]/div/div/div[1]/button");
	By xpathofSubmitButton = By.xpath("//*[@id=\"logInModal\"]/div/div/div[3]/button[2]");
	
	public void loginPage(String userId, String passId) throws InterruptedException {
	
		driver.findElement(xpathofLoginLink)
				.click();	
		
		WebElement username =wait.until(ExpectedConditions.visibilityOfElementLocated(xpathofUsername));
		new Actions(driver).sendKeys(username,userId)
				.perform();
		
		
		WebElement password = driver.findElement(xpathofPassword);
		new Actions(driver).sendKeys(password,passId)
				.perform();
	
		
		WebElement signupButton= driver.findElement(xpathofSubmitButton);
		new Actions(driver).moveToElement(signupButton)
				.click()
				.perform();
		
		Thread.sleep(1000);
		
		if(isAlertPresent()) {
			AlertHandel alertHandel = new AlertHandel(driver);
			String alertMessage = alertHandel.alertHandel();
			System.out.println(alertMessage);
			
			if(alertMessage.equalsIgnoreCase("Wrong password.")) {
				
				username.clear();
				password.clear();
				WebElement closeButton = driver.findElement(xpathofCloseButton);
				new Actions(driver).moveToElement(closeButton)	
					.click()
					.perform();
				
				 wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("logInModal")));
				 
			}else if(alertMessage.equals("User does not exist.")) {
				username.clear();
				password.clear();
				
				WebElement closeButton = driver.findElement(xpathofCloseButton);
				new Actions(driver).moveToElement(closeButton)	
					.click()
					.perform();
				
				 wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("logInModal")));
			}
			
		}
		
	}
	
	public boolean isAlertPresent() {
		try {
			wait.until(ExpectedConditions.alertIsPresent());
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
}
