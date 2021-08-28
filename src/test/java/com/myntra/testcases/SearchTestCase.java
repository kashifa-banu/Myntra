package com.myntra.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.myntra.assertion.Assertions;
import com.myntra.pages.SearchPage;
import com.myntra.utility.BaseClass;

public class SearchTestCase extends BaseClass {
	
	
	@Test
	public void SearchForProduct(){
		SearchPage searchpage = new SearchPage(driver);
		searchpage.clickSearch();
		Assert.assertTrue(Assertions.isSearchSuccessfull(),"Could not search the product");
	}
	

}
