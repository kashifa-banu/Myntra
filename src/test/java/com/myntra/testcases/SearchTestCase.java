package com.myntra.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.myntra.assertion.Assertions;
import com.myntra.pages.SearchPage;
import com.myntra.utility.BaseClass;


public class SearchTestCase extends BaseClass{
	
	
	@Test(groups = {"smoke"})
	public void SearchForProduct(){
		SearchPage searchpage = new SearchPage();
		searchpage.searchForProduct();
		//Assert.assertTrue(Assertions.isSearchSuccessfull(),"Could not search the product");
			
	}
	
	
	

}
