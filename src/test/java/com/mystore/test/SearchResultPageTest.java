package com.mystore.test;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.dataprovider.DataProviders;
import com.mystore.pages.IndexPage;
import com.mystore.pages.SearchResultPage;

public class SearchResultPageTest extends BaseClass{
	IndexPage inde;
	SearchResultPage serachResultob;
	@Test(dataProvider="searchProduct" ,dataProviderClass=DataProviders.class,groups="Smoke")
	public void productAvailabilityTest(String prod) {
		inde=PageFactory.initElements(driver,IndexPage.class);
		inde.searchProduct(prod);
		serachResultob=PageFactory.initElements(driver,SearchResultPage.class);
		boolean result=serachResultob.isProductAvailable();
		Assert.assertTrue(result);
	}

}
