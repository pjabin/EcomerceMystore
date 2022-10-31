package com.mystore.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.mystore.base.BaseClass;

public class SearchResultPage extends BaseClass {
	
	@FindBy(xpath="//*[@id=\"center_column\"]//img") WebElement productResult;

	public SearchResultPage(WebDriver ldriver){
		this.driver=ldriver;
		
	}
public boolean isProductAvailable() {
	return productResult.isDisplayed();
}
public AddCartPage clickOnProduct() {
	productResult.click();
	return new AddCartPage(driver);
}

}

