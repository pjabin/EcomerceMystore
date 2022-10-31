package com.mystore.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.mystore.base.BaseClass;
import com.mystore.utility.Helper;

public class AddressPage extends BaseClass {

	@FindBy(how = How.ID, using = "processAddress") WebElement proceedToCheckOut;
	public AddressPage(WebDriver ldriver) {
		
		this.driver=ldriver;
	}
	
	public ShippingPage clickOnCheckOut() {
		Helper.fluentWait(driver, proceedToCheckOut, 10);
		proceedToCheckOut.click();
		return new ShippingPage(driver);
	}
}
