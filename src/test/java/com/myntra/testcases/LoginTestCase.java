package com.myntra.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.myntra.assertion.Assertions;
import com.myntra.pages.LoginPage;
import com.myntra.pages.SearchPage;
import com.myntra.utility.BaseClass;

public class LoginTestCase extends BaseClass{
	
	@Test(groups = {"regression"})
	void login() throws InterruptedException{
		LoginPage loginpage= new LoginPage(driver);
		loginpage.clicklogin();
		loginpage.enterUserName(getUserName());
		loginpage.ClickContinue();
		loginpage.clickOnLoginUsingPassword();
		loginpage.enterPassword(getPassword());
		loginpage.login();
		Assert.assertTrue(Assertions.isLoginSuccessfull(), "LoginFailure");
		}

}
