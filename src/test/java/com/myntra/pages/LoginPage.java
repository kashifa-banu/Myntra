package com.myntra.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginPage {
	
	private String MYPROFILE="//span[contains(text(),'Profile')]";
	private String LOGIN="//a[contains(text(),'log in')]";
	private String USERNAME="//input[@name='email']";
	private String PASSWORD="//input[@name='password']";
	private String SIGNIN="//button[contains(text(),'Log in')]";
	private WebDriver driver;
	private WebDriverWait wait;
	
	
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		wait=new WebDriverWait(this.driver,2000);
	}


	public void clicklogin(){
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(MYPROFILE))));
		driver.findElement(By.xpath(MYPROFILE)).click();
		driver.findElement(By.xpath(LOGIN)).click();		
	}


	public void enterUserName(String uname) {
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(USERNAME))));
		driver.findElement(By.xpath(USERNAME)).sendKeys(uname);		
	}


	public void enterPassword(String password) {
		driver.findElement(By.xpath(PASSWORD)).sendKeys(password);
	}


	public void login() {
		driver.findElement(By.xpath(SIGNIN)).click();
		
	}
	
	
	
	


}
