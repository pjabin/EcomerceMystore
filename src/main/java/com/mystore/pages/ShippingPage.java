package com.mystore.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.BaseClass;
import com.mystore.utility.Helper;

public class ShippingPage extends BaseClass {
	
	@FindBy(id="cgv")  WebElement term;
	@FindBy(xpath="//button/span[contains(text(),'Proceed to checkout')]")  WebElement proceedToCheckOutBTN;
	
	public ShippingPage(WebDriver ldriver) {
		this.driver=ldriver;
	}
	
	public void checkTheTerms() {
		Helper.scrollByVisibilityOfElement(driver, term);
		term.click();
		
	}
	
	public PaymentPage checkOnProceedToCheckOut() {
		Helper.scrollByVisibilityOfElement(driver, proceedToCheckOutBTN);
		proceedToCheckOutBTN.click();
		return new PaymentPage(driver);
	}
}
