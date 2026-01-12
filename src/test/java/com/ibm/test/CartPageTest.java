package com.ibm.test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ibm.basetest.BaseTest;
import com.ibm.element.MyListener;
import com.ibm.page.CartPage;


@Listeners(MyListener.class)
public class CartPageTest extends BaseTest{
	CartPage cartPage;
	
	@BeforeMethod
	public void init() {
		cartPage = new CartPage(driver);
	}
	
	
	@Test(groups ="cart")
	public void cartTest() throws InterruptedException {
		cartPage.productToBeOrder();
	}

}
