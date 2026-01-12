package com.ibm.test;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ibm.basetest.BaseTest;
import com.ibm.data.DataSupplier;
import com.ibm.element.MyListener;
import com.ibm.page.SignupPage;


@Listeners(MyListener.class)
public class SignupPageTest extends BaseTest{
	
	SignupPage signupPage;

    @BeforeMethod
    public void init() {
        signupPage = new SignupPage(driver);
    }
    
	@Test(groups ="signup",dataProvider = "signupData",dataProviderClass = DataSupplier.class)
	public void signupPageTest(String usernameForSignup, String passwordForsignup) throws InterruptedException {
		System.out.println("SIGNUP 1");
		signupPage.signup(usernameForSignup,passwordForsignup);
	}

}
