package com.myntra.testcases;

import org.testng.annotations.Test;
import com.myntra.pages.LoginPage;
import com.myntra.pages.SearchPage;
import com.myntra.utility.BaseClass;

public class LoginTestCase extends BaseClass{
	
	@Test
	void login(){
		LoginPage loginpage= new LoginPage(driver);
		loginpage.clicklogin();
		loginpage.enterUserName("8843222541");
		loginpage.ClickContinue();
		loginpage.clickOnLoginUsingPassword();
		loginpage.enterPassword("Welcome2ibm!");
		loginpage.login();
		SearchPage searchpage = new SearchPage(driver);
		searchpage.clickSearch();
		}

}
