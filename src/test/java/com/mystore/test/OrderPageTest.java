package com.mystore.test;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pages.AddCartPage;
import com.mystore.pages.IndexPage;
import com.mystore.pages.OrderPage;
import com.mystore.pages.SearchResultPage;

public class OrderPageTest extends BaseClass {
	IndexPage inde;
	SearchResultPage serachResultob;
	AddCartPage addCartPageOb;
	OrderPage orderPageOb;
	@Test(groups="Regression")
	public void verifyTotalPrice() throws Exception {
		inde=PageFactory.initElements(driver,IndexPage.class);
		inde.searchProduct("T-shirt");
		serachResultob=PageFactory.initElements(driver,SearchResultPage.class);
		serachResultob.clickOnProduct();
		addCartPageOb=PageFactory.initElements(driver,AddCartPage.class);
		addCartPageOb.enterQuantity("2");
		addCartPageOb.selectSize("M");
		addCartPageOb.cllickOnAddToCart();
		addCartPageOb.clickOnCheckOut();
		orderPageOb=PageFactory.initElements(driver,OrderPage.class);
		Double unitPrice=orderPageOb.getUnitPrice();
		Double totalPrice=orderPageOb.getTotalPrice();
		Double totalExpectedPrice=(unitPrice*2)+2;
		Assert.assertEquals(totalPrice, totalExpectedPrice);
	}
}
