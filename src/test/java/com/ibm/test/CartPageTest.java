package com.ibm.test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ibm.basetest.BaseTest;
import com.ibm.page.CartPage;

public class CartPageTest extends BaseTest{
	CartPage cartPage;
	
	@BeforeMethod
	public void init() {
		cartPage = new CartPage(driver);
	}
	
	@Test(dependsOnGroups = "login")
	public void cartTest() throws InterruptedException {
		cartPage.productToBeOrder();
	}

}
