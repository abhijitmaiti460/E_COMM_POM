package com.ibm.page;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class CartPage {
	WebDriver driver;
	
	
	public CartPage(WebDriver driver) {
		this.driver = driver;
	}
	
	By xpathofCartLink = By.xpath("//*[@id=\"cartur\"]");
	By xpathofPlaceOrderButton = By.xpath("//button[normalize-space()='Place Order']");
	By xpathofProductListed = By.xpath("//*[@id=\"page-wrapper\"]/div/div[1]/div/table/tbody/tr");
	By xpathofProductList = By.xpath("//*[@id=\"page-wrapper\"]/div/div[1]/div/table/tbody/tr");
	
	
	public void productToBeOrder( ) throws InterruptedException {
		
		new Actions(driver)
			.moveToElement(driver.findElement(xpathofCartLink))
				.click()
				.perform();
		System.out.println("Open cart");
		totalPrice();
		
	}
	
	public void totalPrice() throws InterruptedException {
		int totalPrice =0;
		List<WebElement> listofCartProduct =driver.findElements(xpathofProductListed);
		System.out.println("Total Number of Item in the Shoppint Cart :"+listofCartProduct.size());
		List<String> priceList= new ArrayList<String>();
		
		if(listofCartProduct.size()==0) {
			driver.navigate().back();
		}
		else {
			for(WebElement ele : listofCartProduct) {
				String e= ele.findElement(By.xpath("./td[3]")).getText();
				priceList.add(e);
			}
			
			for(String e :priceList) {
				totalPrice += Integer.parseInt(e);
			}
			System.out.println("Total Price : "+totalPrice);
			
			new Actions(driver)
			.moveToElement(driver.findElement(xpathofPlaceOrderButton))
				.click()
				.perform();
			
		}
		
		
				
	}
	
	
	
	

}
