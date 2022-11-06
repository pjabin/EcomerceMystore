package com.mystore.test;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.dataprovider.DataProviders;
import com.mystore.pages.AccountCreationPage;
import com.mystore.pages.IndexPage;
import com.mystore.pages.LoginPage;

public class AccountCreationPageTest extends BaseClass{
	IndexPage inde;
	LoginPage LoginPageob;
	AccountCreationPage accountPageob;
	@Test(dataProvider="email" ,dataProviderClass=DataProviders.class,groups="Sanity")
	public void verifyCreateAccountPageTest(String newEmail) {
		inde=PageFactory.initElements(driver,IndexPage.class);
		inde.clickOnSign();
		LoginPageob=PageFactory.initElements(driver,LoginPage.class);
		LoginPageob.createNewAccount(newEmail);
		accountPageob=PageFactory.initElements(driver,AccountCreationPage.class);
		boolean result=accountPageob.validateAcountCreatePage();
		Assert.assertTrue(result);
		
	}

}
