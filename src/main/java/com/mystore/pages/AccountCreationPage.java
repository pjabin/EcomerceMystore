package com.mystore.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.mystore.base.BaseClass;

public class AccountCreationPage extends BaseClass{
	
	@FindBy(xpath="//h1[text()='Create an account']") WebElement formTitle;
	
	public AccountCreationPage(WebDriver ldriver) {
		this.driver=ldriver;
		
	}
	public boolean validateAcountCreatePage() {
		return formTitle.isDisplayed();
	}
	
	
}

