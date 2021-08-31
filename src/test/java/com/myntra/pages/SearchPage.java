package com.myntra.pages;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import com.myntra.utility.BaseClass;

public class SearchPage extends BaseClass {

	private String SEARCH = "//input[@class='desktop-searchBar']";

	public void searchForProduct() {

		driver.findElement(By.xpath(SEARCH)).sendKeys(getProduct());
		Actions act = new Actions(driver);
		act.sendKeys(Keys.ENTER).build().perform();
	}

	public void clickOnProduct() {		
		driver.findElement(By.xpath("//h3[contains(text(),'Roadster')]")).click();
		String Parent = driver.getWindowHandle();
		Set<String> Windows = driver.getWindowHandles();
		for( String win : Windows){
			if(win!=Parent){
				driver.switchTo().window(win);
			}
		}
		

	}

}
