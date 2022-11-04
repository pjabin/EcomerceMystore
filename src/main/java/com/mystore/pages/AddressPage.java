package com.mystore.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.mystore.base.BaseClass;
import com.mystore.utility.Helper;

public class AddressPage extends BaseClass {

	@FindBy(xpath="//span[text()='Proceed to checkout']")  WebElement proceedToCheck;
	public AddressPage(WebDriver ldriver) {
		
		this.driver=ldriver;
	}
	
	public ShippingPage clickOnCheckOut() {
		Helper.scrollByVisibilityOfElement(driver, proceedToCheck);
		proceedToCheck.click();
		return new ShippingPage(driver);
	}
}
