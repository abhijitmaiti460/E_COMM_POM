package com.ibm.test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ibm.basetest.BaseTest;
import com.ibm.data.DataSupplier;
import com.ibm.element.MyListener;
import com.ibm.page.LoginPage;


@Listeners(MyListener.class)
public class LoginTest extends BaseTest{
	LoginPage login;
	
	@BeforeMethod
	public void init() {
		login = new LoginPage(driver);
	}
	

	@Test(groups="login", dataProvider ="loginData",dataProviderClass = DataSupplier.class)
	public void loginTest(String usernameForLogin,String passwordForLogin) throws InterruptedException {
		login.loginPage(usernameForLogin,passwordForLogin);
		
	}
}
