package com.mystore.test;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.dataprovider.DataProviders;
import com.mystore.pages.HomePage;
import com.mystore.pages.IndexPage;
import com.mystore.pages.LoginPage;

public class LoginPageTest extends BaseClass{
	
	IndexPage inde;
	LoginPage LoginPageob;
	HomePage homePageob;
	@Test(dataProvider="credentials" ,dataProviderClass=DataProviders.class,groups={"Smoke","Sanity"})
	public void loginTest(String uname,String passw) throws InterruptedException {
		inde=PageFactory.initElements(driver,IndexPage.class);
		inde.clickOnSign();
		LoginPageob=PageFactory.initElements(driver,LoginPage.class);
		Thread.sleep(3000);
		LoginPageob.login(uname,passw);
		homePageob=PageFactory.initElements(driver,HomePage.class);
		String actURL=homePageob.getCurrentURL();
		String expectedURL="http://automationpractice.com/index.php?controller=my-account";
		Assert.assertEquals(actURL,expectedURL );
	}

}
