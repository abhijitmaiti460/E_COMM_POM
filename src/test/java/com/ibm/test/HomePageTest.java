package com.ibm.test;

import org.testng.annotations.Test;

import com.ibm.basetest.BaseTest;
import com.ibm.page.HomePage;

public class HomePageTest extends BaseTest {
	
	@Test(groups = "smoke")
	public void navbarTest() {
		 new HomePage(driver).cornerLogo();
		 new HomePage(driver).HoverOverNavBar();
	}
	
	@Test(dependsOnMethods = "navbarTest", groups="smoke")
	public void slidingWindowTest() throws InterruptedException {
		 new HomePage(driver).slideRightButton();
		 new HomePage(driver).slideLeftButton();
	}
	
	@Test(dependsOnMethods = "slidingWindowTest", groups="smoke")
	public void categoriesListTest() throws InterruptedException {
		Thread.sleep(1000);
		 new HomePage(driver).categoriesList();
	}
	

	@Test(dependsOnMethods = "categoriesListTest", groups="smoke")
	public void previousButttonAndNextButtonTest() throws InterruptedException {
		 new HomePage(driver).previousButton();
		 new HomePage(driver).nextButton();
	}
	
	
	
	

}
