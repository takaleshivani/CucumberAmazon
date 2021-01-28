package com.amazon.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class AccountsPage {

	private WebDriver driver;
	
	@FindBys({
	@FindBy(css="div#center_column span")
	})
	List<WebElement> accountSections;
	
	AccountsPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public int getAccountcheckSections()
	{
		return accountSections.size()-1;
		 
	}
	
	public String getaccountPage()
	{
		return driver.getTitle();
	}
	
	public List<String> getSectionsList() {
		List<String> accounts=new ArrayList<String>();
		for(WebElement e:accountSections)
		{
			System.out.println(e.getText());
			accounts.add(e.getText());
		}
		return accounts;
	}
	
}
