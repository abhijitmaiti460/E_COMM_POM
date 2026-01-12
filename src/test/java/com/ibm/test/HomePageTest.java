package com.ibm.test;

import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.ibm.basetest.BaseTest;
import com.ibm.element.MyListener;
import com.ibm.page.HomePage;


@Listeners(MyListener.class)
public class HomePageTest extends BaseTest {
	
	
	@Test(groups = "smoke")
	public void navbarTest() {
		 new HomePage(driver).cornerLogo();
		 new HomePage(driver).HoverOverNavBar();
	}
	
	@Parameters("firstSleepTime")
	@Test(dependsOnMethods = "navbarTest", groups="smoke")
	public void slidingWindowTest(Long firstSleepTime) throws InterruptedException {
		 new HomePage(driver).slideRightButton(firstSleepTime);
		 new HomePage(driver).slideLeftButton(firstSleepTime);
	}
	
	@Parameters({"firstSleepTime","secondSleepTime"})
	@Test(dependsOnMethods = "slidingWindowTest", groups="smoke")
	public void categoriesListTest(Long firstSleepTime, Long secondSleepTime) throws InterruptedException {
		Thread.sleep(1000);
		 new HomePage(driver).categoriesList(firstSleepTime,secondSleepTime);
	}
	
	@Parameters({"firstSleepTime"})
	@Test(dependsOnMethods = "categoriesListTest", groups="smoke")
	public void previousButttonAndNextButtonTest(Long firstSleepTime) throws InterruptedException {
		 new HomePage(driver).previousButton(firstSleepTime);
		 new HomePage(driver).nextButton(firstSleepTime);
	}
	
	
	
	

}
