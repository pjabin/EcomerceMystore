package com.mystore.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.BaseClass;
import com.mystore.utility.Helper;

public class PaymentPage extends BaseClass{
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Pay by bank wire')]") WebElement bankWireMethod;
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Pay by check')]") WebElement payByCheck;
	public PaymentPage(WebDriver ldriver) {
		this.driver=ldriver;
		
	}
	public OrderSummary clickOnPaymentMethod() {
		Helper.scrollByVisibilityOfElement(driver, bankWireMethod);
		bankWireMethod.click();
		return new  OrderSummary(driver);
	}
	
}
