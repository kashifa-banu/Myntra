package com.myntra.assertion;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.myntra.pages.LoginPage;
import com.myntra.utility.BaseClass;


public class Assertions extends BaseClass {
	static LoginPage loginPage;
	
	
	public static boolean isLoginSuccessfull(){
			loginPage = new LoginPage(driver);
			return (loginPage.isLoginBtndispayed());
		
	}


	public static boolean isSearchSuccessfull() {
		if(driver.getCurrentUrl().contains("jeans"))
		return true;
		else
			return false;
	}


	public static boolean isProductAddedtoCart() {
		Actions act = new Actions(driver);
		act.sendKeys(Keys.PAGE_DOWN).build().perform();
		if(driver.findElement(By.xpath("//div[contains(text(),'Place Order')]")).isDisplayed())
		return true;
		else
			return false;
	}

	public static boolean isProductDispayed() {
		boolean isExist=true;
		
		try{
			if(driver.findElement(By.xpath("//p[text()='S']")).isDisplayed())
				isExist= true;
		}
		catch(Exception e){
			isExist= false;
		}
		return isExist;	
	}
}
