package com.mystore.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.BaseClass;

public class OrderConfirmationPage extends BaseClass {
	
	@FindBy(how = How.XPATH, using = "//p/strong[contains(text(),'Your order on My Store is complete.')]") WebElement ConfrimMessage;
	public OrderConfirmationPage(WebDriver ldriver) {
		this.driver=ldriver;
	}
	public String validateConfirmMessage() {
		String confirmMsg=ConfrimMessage.getText();
		return confirmMsg;
	}

}
