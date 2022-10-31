package com.mystore.test;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pages.HomePage;
import com.mystore.pages.IndexPage;
import com.mystore.pages.LoginPage;

public class HomePageTest extends BaseClass{
	IndexPage inde;
	LoginPage LoginPageob;
	HomePage homePageob;
	@Test(groups="Smoke")
	public void WishListTest() throws InterruptedException {
		inde=PageFactory.initElements(driver,IndexPage.class);
		inde.clickOnSign();
		LoginPageob=PageFactory.initElements(driver,LoginPage.class);
		Thread.sleep(3000);
		LoginPageob.login("admin@xyz.com","admin@123");
		homePageob=PageFactory.initElements(driver,HomePage.class);
		boolean result=homePageob.validateWishlist();
		Assert.assertTrue(result);
		
	}
	@Test(groups="Smoke")
	public void OrderHistoryDetailsTest() throws InterruptedException {
		inde=PageFactory.initElements(driver,IndexPage.class);
		inde.clickOnSign();
		LoginPageob=PageFactory.initElements(driver,LoginPage.class);
		Thread.sleep(3000);
		LoginPageob.login("admin@xyz.com","admin@123");
		homePageob=PageFactory.initElements(driver,HomePage.class);
		boolean result=homePageob.validateOrderHistory();
		Assert.assertTrue(result);
		
	}
}
