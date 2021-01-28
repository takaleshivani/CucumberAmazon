package com.amazon.base;

import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass {
	
	public static WebDriver driver;
	
	public void display(Properties prop)
	{
		System.out.println("Setting Prop");
		System.out.println("Value of prop is "+prop);
	}
	
	public void getDriver()
	{
		driver = new FirefoxDriver();
	}
	
	public void getURL(String url)
	{
		driver.get(url);
	}
	
	public WebElement getObject(String locator)
	{
		WebElement element = null;
		if(locator.endsWith("_xpath"))
		{
			element=driver.findElement(By.xpath(locator));
		}
		else if(locator.endsWith("_name"))
		{
			element=driver.findElement(By.name(locator));
		}
		else if(locator.endsWith("_id"))
		{
			element=driver.findElement(By.id(locator));
		}
		else if(locator.endsWith("_css"))
		{
			element=driver.findElement(By.cssSelector(locator));
		}
		
		return element;
	}
	
	public void enterUsername(String locator, String keyValue)
	{
		getObject(locator).sendKeys(keyValue);
	}
	
	public void click(String locator) {
		// TODO Auto-generated method stub
		getObject(locator).click();
	}
	
}
