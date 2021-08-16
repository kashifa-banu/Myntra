package com.myntra.testcases;

import org.testng.annotations.Test;

import com.myntra.pages.SearchPage;
import com.myntra.utility.BaseClass;

public class SearchTestCase extends BaseClass {
	
	
	@Test
	public void SearchForProduct(){
		SearchPage searchpage = new SearchPage(driver);
		searchpage.clickSearch();
	}
	

}
