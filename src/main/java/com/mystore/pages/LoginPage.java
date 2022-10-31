package com.mystore.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.mystore.base.BaseClass;

public class LoginPage extends BaseClass {
	


	@FindBy(how = How.NAME, using = "email") WebElement userName;
	@FindBy(how = How.NAME, using = "passwd") WebElement password;
	@FindBy(how = How.ID, using = "SubmitLogin") WebElement Siginbtn;
	
	@FindBy(how = How.ID, using = "email_create") WebElement emailfornewaccount;
	@FindBy(how = How.ID, using = "SubmitCreate") WebElement createNewaccountBtn;
	
	public LoginPage(WebDriver ldriver)
	{
		this.driver=ldriver;
	}
	
	public HomePage login(String uname,String pswd) throws InterruptedException {
		Thread.sleep(3000);
		userName.sendKeys(uname);
		password.sendKeys(pswd);
		Siginbtn.click();
		return new HomePage(driver);
	}
	public AddressPage login1(String uname,String pswd) {
		userName.sendKeys(uname);
		password.sendKeys(pswd);
		Siginbtn.click();
		return new AddressPage(driver);
	}
	public AccountCreationPage createNewAccount(String newEmail) {
		emailfornewaccount.sendKeys(newEmail);
		createNewaccountBtn.click();
		return new AccountCreationPage(driver);
	}
}
