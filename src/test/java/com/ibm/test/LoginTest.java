package com.ibm.test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ibm.basetest.BaseTest;
import com.ibm.page.LoginPage;

public class LoginTest extends BaseTest{
	LoginPage login;
	
	@BeforeMethod
	public void init() {
		login = new LoginPage(driver);
	}
	
	@Test(dependsOnGroups = "signup",groups = "login")
	public void loginTest() throws InterruptedException {
		login.loginPage();
		
	}
}
