package com.mystore.test;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pages.AddCartPage;
import com.mystore.pages.AddressPage;
import com.mystore.pages.IndexPage;
import com.mystore.pages.LoginPage;
import com.mystore.pages.OrderConfirmationPage;
import com.mystore.pages.OrderPage;
import com.mystore.pages.OrderSummary;
import com.mystore.pages.PaymentPage;
import com.mystore.pages.SearchResultPage;
import com.mystore.pages.ShippingPage;

public class EndToEndTest extends BaseClass {
	IndexPage inde;
	SearchResultPage serachResultob;
	AddCartPage addCartPageOb;
	OrderPage orderPageOb;
	LoginPage loginPageOb;
	AddressPage addressPageOb;
	ShippingPage shippingPageOb;
	PaymentPage paymentPageOb;
	OrderSummary orderSummaryOb;
	OrderConfirmationPage oderConfirmationPageOb;
	@Test(groups="Regression")
	public void endToEndTest() throws Exception {
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
		orderPageOb.clickOnCheckOut();
		loginPageOb=PageFactory.initElements(driver,LoginPage.class);
		loginPageOb.login1("admin@xyz.com","admin@123");
		addressPageOb=PageFactory.initElements(driver,AddressPage.class);
		addressPageOb.clickOnCheckOut();
		shippingPageOb=PageFactory.initElements(driver,ShippingPage.class);
		shippingPageOb.checkTheTerms();
		shippingPageOb.checkOnProceedToCheckOut();
		paymentPageOb=PageFactory.initElements(driver,PaymentPage.class);
		paymentPageOb.clickOnPaymentMethod();
		orderSummaryOb=PageFactory.initElements(driver,OrderSummary.class);
		orderSummaryOb.clickConfirmOrderBtn();
		oderConfirmationPageOb=PageFactory.initElements(driver,OrderConfirmationPage.class);
		String actualMsg=oderConfirmationPageOb.validateConfirmMessage();
		String expectedMsg="Your order on My Store is complete.";
		Assert.assertEquals(actualMsg, expectedMsg);
		
	}

}
