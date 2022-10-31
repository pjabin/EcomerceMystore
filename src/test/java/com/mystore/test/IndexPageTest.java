package com.mystore.test;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.mystore.base.BaseClass;
import com.mystore.pages.IndexPage;

public class IndexPageTest extends BaseClass{
	IndexPage inde;
	@Test(groups="Smoke")
	public void verifyLogo() {
		inde=PageFactory.initElements(driver,IndexPage.class);
		boolean result=inde.validateLogo();
		Assert.assertTrue(result);
	}
	@Test(groups="Smoke")
	public void verifyTitle() {
		String actTitle=inde.getMyStoreTitle();
		Assert.assertEquals(actTitle,"My Store");		
	}
}
