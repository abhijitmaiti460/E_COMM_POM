package com.ibm.page;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ibm.element.AlertHandel;

public class SignupPage {
	WebDriver driver;
	Alert alert;
	WebDriverWait wait;
	
	public SignupPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	By xpathofSinupLink = By.xpath("//*[@id=\"signin2\"]");
	By idofUsernameInputField = By.id("sign-username");
	By xpathofPasswordInputField = By.xpath("//*[@id=\"sign-password\"]");
	By xpathofSignupButton = By.xpath("//*[@id=\"signInModal\"]/div/div/div[3]/button[2]");
	By xpathofCloseButton = By.xpath("//*[@id='signInModal']//button[text()='Close']");
	
	public void signup() throws InterruptedException {
		driver.findElement(xpathofSinupLink).click();
		
		WebElement username =wait.until(ExpectedConditions.visibilityOfElementLocated(idofUsernameInputField));
		new Actions(driver).sendKeys(username,"Abhijitmaiti2@gmail")
				.perform();
		
		WebElement password = driver.findElement(xpathofPasswordInputField);
		new Actions(driver).sendKeys(password,"Abhijit@2004")
				.perform();
	
		
		WebElement signupButton= driver.findElement(xpathofSignupButton);
		new Actions(driver).moveToElement(signupButton)
				.click()
				.perform();
		
		AlertHandel alertHandel =new AlertHandel(driver);
		String message = alertHandel.alertHandel();
		System.out.println(message);
		
		if(message.equalsIgnoreCase("This user already exist.")) {
			
			WebElement closeButton = driver.findElement(xpathofCloseButton);
			new Actions(driver).moveToElement(closeButton)	
				.click()
				.perform();
		}
		
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("signInModal")));
	}

}
