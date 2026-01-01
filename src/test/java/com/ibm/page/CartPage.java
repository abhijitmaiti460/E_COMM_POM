package com.ibm.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class CartPage {
	WebDriver driver;
	
	
	public CartPage(WebDriver driver) {
		this.driver = driver;
	}
	
	By xpathofCartLink = By.xpath("//*[@id=\"cartur\"]");
	By xpathofPlaceOrderButton = By.xpath("//*[@id=\"page-wrapper\"]/div/div[2]/button");
	
	public void productToBeOrder() throws InterruptedException {
		
		new Actions(driver)
			.moveToElement(driver.findElement(xpathofCartLink))
				.click()
				.perform();
		System.out.println("Open cart");
		Thread.sleep(5000);
		
		
		
//		new Actions(driver)
//			.moveToElement(driver.findElement(xpathofPlaceOrderButton))
//				.click()
//				.perform();
				
		
	}

}
