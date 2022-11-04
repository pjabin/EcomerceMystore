package com.mystore.utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserFactory {
public static WebDriver startApplication(WebDriver driver,String browserName, String appURL) {
		
		if(browserName.equals("chrome")){
			
			System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
			
			}
			else if(browserName.equals("Firefox"))
			{
			//System.setProperty(“webDriver.gecko.driver”,”Path of driver”);
			//driver = new FirefoxDriver();
			}
			else if(browserName.equals("IE"))
			{
			//System.setProperty(“webDriver.ie.driver”,”Path of driver”);
			//driver = new InternetExplorerDriver();
			}
			else
			{
			System.out.println("Does not support this browser");
			}
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
			driver.get(appURL);
			
			return driver;
	}
	
	public static void quitBrowser(WebDriver driver) {
		
		driver.quit();
	}
	
	
}
