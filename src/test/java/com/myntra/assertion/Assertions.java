package com.myntra.assertion;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.myntra.pages.LoginPage;
import com.myntra.utility.BaseClass;


public class Assertions extends BaseClass {
	static LoginPage loginPage;
	
	
	public static boolean isLoginSuccessfull(){
			loginPage = new LoginPage(driver);
			return (loginPage.isLoginBtndispayed());
		
	}

}
