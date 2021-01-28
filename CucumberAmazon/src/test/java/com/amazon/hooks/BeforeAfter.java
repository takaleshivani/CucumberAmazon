package com.amazon.hooks;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.amazon.base.BaseClass;
import com.amazon.util.DataUtil;

import com.qtp.webdriver.WebConnector;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class BeforeAfter {
	public WebConnector conn;
	public WebDriver driver;
	public DataUtil dataUtil;
	public Properties prop;
	
	@Before(order=0)
	public void getProperty() throws IOException
	{
		dataUtil=new DataUtil();
		prop=dataUtil.init();
	}
	
	@Before
	public void launchBrowser()
	{	
		conn=new WebConnector();
		driver=conn.openBrowser("edge");
	}
	
	@After(order=0)
	public void quit()
	{
		driver.quit();
	}
	
	@After(order=1)
	public void tearDown(Scenario sc)
	{
		if(sc.isFailed())
		{
			String scfileName=sc.getName().replaceAll(" ", "_");
			byte [] scpath=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			sc.attach(scpath, "image/png", scfileName);
		}
			
	}
	
}
