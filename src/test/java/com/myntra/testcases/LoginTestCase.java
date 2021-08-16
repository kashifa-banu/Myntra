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
		loginpage.enterUserName("kashifabn4@gmail.com");
		loginpage.enterPassword("rafath100");
		loginpage.login();
		SearchPage searchpage = new SearchPage(driver);
		searchpage.clickSearch();
		}

}
