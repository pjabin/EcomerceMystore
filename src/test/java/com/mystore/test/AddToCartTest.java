package com.mystore.test;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.dataprovider.DataProviders;
import com.mystore.pages.AddCartPage;
import com.mystore.pages.IndexPage;
import com.mystore.pages.SearchResultPage;

public class AddToCartTest extends BaseClass {
	IndexPage inde;
	SearchResultPage serachResultob;
	AddCartPage addCartPageOb;
	@Test(dataProvider="productDetails" ,dataProviderClass=DataProviders.class,groups= {"Regression","Sanity"})
	public void addToCartTest(String product,String qty ,String s) throws InterruptedException {
		inde=PageFactory.initElements(driver,IndexPage.class);
		inde.searchProduct(product);
		serachResultob=PageFactory.initElements(driver,SearchResultPage.class);
		serachResultob.clickOnProduct();
		addCartPageOb=PageFactory.initElements(driver,AddCartPage.class);
		addCartPageOb.enterQuantity(qty);
		addCartPageOb.selectSize(s);
		addCartPageOb.cllickOnAddToCart();
		boolean result=addCartPageOb.validateAddtocart();
		Assert.assertTrue(result);
		
		
	}

}
