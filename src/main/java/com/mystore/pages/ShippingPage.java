package com.mystore.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.BaseClass;

public class ShippingPage extends BaseClass {
	
	@FindBy(how = How.ID, using = "cgv") WebElement term;
	@FindBy(how = How.NAME, using = "processCarrier") WebElement proceedToCheckOutBTN;
	
	public ShippingPage(WebDriver ldriver) {
		this.driver=ldriver;
	}
	
	public void checkTheTerms() {
		term.click();
		
	}
	
	public PaymentPage checkOnProceedToCheckOut() {
		proceedToCheckOutBTN.click();
		return new PaymentPage(driver);
	}
}
