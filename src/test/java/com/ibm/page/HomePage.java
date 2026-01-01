package com.ibm.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.ibm.element.HoverOver;

public class HomePage {
	WebDriver driver;
	HoverOver hoverover;
	JavascriptExecutor js ;
	
	
	public HomePage(WebDriver driver){
		this.driver = driver;
		js = (JavascriptExecutor) driver;

		hoverover = new HoverOver();
	}
	
	By xpathofCornerLogo = By.xpath("//*[@id=\"nava\"]/img");
	By xpathofNavBarLink = By.xpath("//*[@id=\"navbarExample\"]/ul/li");
	By xpathofRightSlideButton = By.xpath("//*[@id=\"carouselExampleIndicators\"]/a[2]/span[1]");
	By xpathofLeftSlideButton = By.xpath("//*[@id=\"carouselExampleIndicators\"]/a[1]/span[1]");
	By xpathofInventoryItem = By.xpath("//h4[@class='card-title']/a");
	By xpathofCategories = By.xpath("//*[@id=\"itemc\"]");
	By xpathofPreviousButton = By.xpath("//*[@id=\"prev2\"]");
	By xpathofNextButton = By.xpath("//*[@id=\"next2\"]");
	By xpathofSinupLink = By.xpath("//*[@id=\"signin2\"]");
	
	
	public void cornerLogo() {
		WebElement cornerLogo = driver.findElement(xpathofCornerLogo);
		boolean logo = cornerLogo.isDisplayed();
		Assert.assertTrue(logo);
	}
	
	public void HoverOverNavBar() {
		List<WebElement> list = driver.findElements(xpathofNavBarLink);
		hoverover.hoverOver(list, driver);
	}
	
	public void slideRightButton() throws InterruptedException {
		int count =0;
		while(count<2) {
			WebElement rightButton = driver.findElement(xpathofRightSlideButton);
			new Actions(driver).moveToElement(rightButton)
			.click()
			.perform();
			Thread.sleep(1000);
			count++;
		}
	}
	
	public void slideLeftButton() throws InterruptedException {
		int count=0;
		while(count<2) {
			WebElement leftButton = driver.findElement(xpathofLeftSlideButton);
			new Actions(driver).moveToElement(leftButton)
			.click()
			.perform();
			Thread.sleep(1000);
			count++;
		}
	}
	public void categoriesList() throws InterruptedException {
		List<WebElement> list = driver.findElements(xpathofCategories);
		for(WebElement e : list) {
			new Actions(driver).moveToElement(e).click()
				.perform();
			System.out.println(e.getText());
			Thread.sleep(1000);		
		}
		new Actions(driver).moveToElement(list.get(0)).click()
		.perform();
		Thread.sleep(1000);	
		inventoryList();
		
	}
	
	public void inventoryList() throws InterruptedException {
		int count =0;
		List<WebElement> list = driver.findElements(xpathofInventoryItem);
		for(WebElement e : list) {
			new Actions(driver).moveToElement(e)
				.perform();
			if(count==2) {
				js.executeScript("arguments[0].scrollIntoView(true);",e);
			}
			else if(count==5) {
				js.executeScript("window.scrollBy(0,500)");
			}
			count++;
			Thread.sleep(500);		
		}
	}
	
	public void previousButton() throws InterruptedException {
		js.executeScript("window.scrollBy(0,500)");
		WebElement previousButton = driver.findElement(xpathofPreviousButton);
		new Actions(driver).moveToElement(previousButton)
				.click()
				.perform();
		Thread.sleep(1000);
	}
	public void nextButton() throws InterruptedException {
		WebElement previousButton = driver.findElement(xpathofNextButton);
		new Actions(driver).moveToElement(previousButton)
				.click()
				.perform();
		Thread.sleep(1000);
	}

}
