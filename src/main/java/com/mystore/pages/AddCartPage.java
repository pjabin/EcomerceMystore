package com.mystore.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import com.mystore.base.BaseClass;
import com.mystore.utility.Helper;

public class AddCartPage extends BaseClass {
	
	@FindBy(how = How.ID, using = "quantity_wanted") WebElement quantity;
	@FindBy(how = How.ID, using = "group_1") WebElement size;
	@FindBy(how = How.XPATH, using = "//span[text()='Add to cart']") WebElement addToCartButton;
	@FindBy(how = How.XPATH, using = "//*[@id=\"layer_cart\"]//h2/i") WebElement addToCartMessage;
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Proceed to checkout')]") WebElement proceedTocheckbtn;
	
	public AddCartPage(WebDriver ldriver) {
		this.driver=ldriver;
	}
	public void enterQuantity(String qnty) {
		quantity.clear();
		quantity.sendKeys(qnty);
	}
	public void selectSize(String s) {
		Select dropsizelist=new Select(size);
		dropsizelist.selectByVisibleText(s);
	}
	public void cllickOnAddToCart() {
		addToCartButton.click();
	}
	public boolean validateAddtocart()   {
		Helper.fluentWait(driver, addToCartMessage, 20);
		return addToCartMessage.isDisplayed();
	}
	public OrderPage clickOnCheckOut() throws Exception {
		//proceedTocheckbtn.click();
		Helper.fluentWait(driver, proceedTocheckbtn, 20);
		Helper.JSClick(driver, proceedTocheckbtn);
		return new OrderPage(driver);
	}
}
