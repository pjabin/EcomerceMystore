package com.mystore.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.mystore.base.BaseClass;
import com.mystore.utility.Helper;

public class OrderPage extends BaseClass{
	@FindBy(how = How.XPATH, using = "//td[@class='cart_unit']/span/span") WebElement unitPrice;
	@FindBy(how = How.ID, using = "total_price") WebElement TotalPrice;
	@FindBy(how=How.XPATH,using="//span[text()='Proceed to checkout']") WebElement proceedToCheckOut;
	
	public OrderPage(WebDriver ldriver) {
		this.driver=ldriver;
		
	}
	
	public double getUnitPrice() {
		Helper.fluentWait(driver, unitPrice, 20);
		String unitprice1=unitPrice.getText();
		String unit=unitprice1.replaceAll("[^a-zA-Z0-9-]", "");
		double finalunitprice=Double.parseDouble(unit);
		return finalunitprice/100;
	}
	public double getTotalPrice() {
		String totalprice1=TotalPrice.getText();
		String toat=totalprice1.replaceAll("[^a-zA-Z0-9-]", "");
		double finalunitprice=Double.parseDouble(toat);
		return finalunitprice/100;
	}
	public LoginPage clickOnCheckOut() {
		proceedToCheckOut.click();
		return new LoginPage(driver);
	}
}
