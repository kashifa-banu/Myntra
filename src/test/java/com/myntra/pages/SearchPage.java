package com.myntra.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class SearchPage{
	
	private String SEARCH="//input[@class='desktop-searchBar']";
	private String PRODUCT="Jeans";
	private WebDriver driver;
	
	public SearchPage(WebDriver driver) {
		this.driver = driver;
	}

	public void clickSearch(){		
		
		driver.findElement(By.xpath(SEARCH)).sendKeys(PRODUCT);
		Actions act = new Actions(driver);
		act.sendKeys(Keys.ENTER).build().perform();
		
	}

}
