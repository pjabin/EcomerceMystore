package com.mystore.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.mystore.base.BaseClass;
import com.mystore.utility.Helper;

public class IndexPage extends BaseClass {

	@FindBy(xpath="//a[@class='login']") WebElement signInBtn;
	@FindBy(xpath = "//img[@class='logo img-responsive']") WebElement myStoreLogo;
	@FindBy(how = How.ID, using = "search_query_top") WebElement searchProductBox;
	@FindBy(how = How.NAME, using = "submit_search") WebElement searchButton;
	public IndexPage(WebDriver ldriver)
	{
		this.driver=ldriver;
	}
	
	
	public LoginPage clickOnSign() {
		Helper.fluentWait(driver, signInBtn, 10);
		signInBtn.click();
		return new LoginPage(driver);
		
	}
	
	public boolean validateLogo() {
		Helper.fluentWait(driver, myStoreLogo, 20);
	return	myStoreLogo.isDisplayed();
	}
	public String getMyStoreTitle() {
		String mystoretitel=driver.getTitle();
		System.out.println(mystoretitel);
		return mystoretitel;
	}
	public SearchResultPage searchProduct(String productname) {
		searchProductBox.clear();
		searchProductBox.sendKeys(productname);
		searchButton.click();
		return new SearchResultPage(driver);
		
	}
}
