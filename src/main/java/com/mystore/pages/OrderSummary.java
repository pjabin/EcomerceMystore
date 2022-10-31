package com.mystore.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.BaseClass;
import com.mystore.utility.Helper;

public class OrderSummary extends BaseClass{
	
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'I confirm my order')]") WebElement confirmOrderButton;
	
	public OrderSummary(WebDriver ldriver) {
		this.driver=ldriver;
		
	}
	public OrderConfirmationPage clickConfirmOrderBtn() {
		Helper.fluentWait(driver, confirmOrderButton, 10);
		confirmOrderButton.click();
		return new OrderConfirmationPage(driver);
	}
}
