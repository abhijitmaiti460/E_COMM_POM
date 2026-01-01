package com.ibm.test;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ibm.basetest.BaseTest;
import com.ibm.page.SignupPage;

public class SignupPageTest extends BaseTest{
	
	SignupPage signupPage;

    @BeforeMethod
    public void init() {
        signupPage = new SignupPage(driver);
    }
    
	@Test(dependsOnGroups ="smoke",groups="signup")
	public void signupPageTest() throws InterruptedException {
		signupPage.signup();
	}

}
