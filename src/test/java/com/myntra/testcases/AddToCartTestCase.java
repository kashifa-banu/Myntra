package com.myntra.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.myntra.assertion.Assertions;
import com.myntra.pages.ProductPage;
import com.myntra.pages.SearchPage;
import com.myntra.utility.BaseClass;


public class AddToCartTestCase extends BaseClass
{
	
	@Test
	public void addToCart(){
		SearchPage searchPage = new SearchPage();
		ProductPage productPage = new ProductPage();
		searchPage.searchForProduct();
		Assert.assertTrue(Assertions.isProductDispayed(), "could not find the product");
		productPage.SelectTheSize();
		productPage.addToBag();
		productPage.clickOnBag();
		Assert.assertTrue(Assertions.isProductAddedtoCart(), "Could not add product");
		
	}

}
