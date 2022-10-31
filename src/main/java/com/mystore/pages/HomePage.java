package com.mystore.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import com.mystore.base.BaseClass;
import com.mystore.utility.Helper;

public class HomePage extends BaseClass {
	@FindBy(how = How.XPATH, using = "//span[text()='My wishlists']") WebElement myWishlist;
	@FindBy(how = How.XPATH, using = "//span[text()='Order history and details']") WebElement orderHistory;
	
	public HomePage(WebDriver ldriver)
	{
		this.driver=ldriver;
	}
	public boolean validateWishlist() {
		return myWishlist.isDisplayed();
		
	}
	
	public boolean validateOrderHistory() {
		return orderHistory.isDisplayed();
	}
	public String getCurrentURL() {
		String homePageURL=	driver.getCurrentUrl();
		return homePageURL;
	}
}

