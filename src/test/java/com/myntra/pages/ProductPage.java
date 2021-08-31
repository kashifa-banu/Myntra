package com.myntra.pages;

import org.openqa.selenium.By;

import com.myntra.utility.BaseClass;

public class ProductPage extends BaseClass {
	
	private String sizeXpath = "//p[text()='S']";
	private String addToBag = "//div[contains(text(),'ADD')]";
	private String bag = "//span[contains(text(),'Bag')]";
	
	public void SelectTheSize(){
		driver.findElement(By.xpath(sizeXpath)).click();
	}
	
	public void addToBag(){
		driver.findElement(By.xpath(addToBag)).click();
	}

	public void clickOnBag() {
		
		driver.findElement(By.xpath(bag)).click();
		
	}

}
