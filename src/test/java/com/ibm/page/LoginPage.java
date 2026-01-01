package com.ibm.page;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ibm.element.AlertHandel;

public class LoginPage {
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
	
	public void loginPage() throws InterruptedException {
		
		driver.findElement(xpathofLoginLink).click();
		
		WebElement username =wait.until(ExpectedConditions.visibilityOfElementLocated(xpathofUsername));
		new Actions(driver).sendKeys(username,"Abhijitmaiti@gmail")
				.perform();
		
		
		WebElement password = driver.findElement(xpathofPassword);
		new Actions(driver).sendKeys(password,"Abhijit@2004")
				.perform();
	
		
		WebElement signupButton= driver.findElement(xpathofSubmitButton);
		new Actions(driver).moveToElement(signupButton)
				.click()
				.perform();
		
		new AlertHandel(driver).alertHandel();
		
	}
	
}
