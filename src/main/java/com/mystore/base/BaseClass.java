package com.mystore.base;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.mystore.utility.BrowserFactory;
import com.mystore.utility.ConfigDataProvider;
import com.mystore.utility.ExtentManager;


public class BaseClass {
	
	public static WebDriver driver;
	public ConfigDataProvider con;

	@BeforeSuite(groups={"Smoke","Sanity","Regression"})
	public void setupSuite() throws IOException {
		ExtentManager.setExtent();
	}
	@BeforeMethod(groups={"Smoke","Sanity","Regression"})
	public void setUp()
	{
		con=new ConfigDataProvider();
	driver=BrowserFactory.startApplication(driver, con.getBrowser(),con.getUrl());
	
	}
	
	@AfterMethod(groups={"Smoke","Sanity","Regression"})
	public void tearDown(){
		BrowserFactory.quitBrowser(driver);
	}
	@AfterSuite
	public void afterSuite() {
		ExtentManager.endReport();
		
	}
}
