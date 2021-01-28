package com.amazon.pages;

import org.apache.commons.math3.analysis.function.Constant;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.constants.Constants;

public class LoginPage {
 
	public WebDriver driver;
	
	@FindBy(css="input#email")
	WebElement username;
	
	@FindBy(css="input#passwd")
	WebElement password;
	
	@FindBy(css="button#SubmitLogin")
	WebElement login;
	
	@FindBy(xpath=Constants.forgotPWD)
	WebElement forgot;
	
	@FindBy(xpath=Constants.retrieve_PWD)
	WebElement retrieve;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void enterUsername(String emailId)
	{
		username.sendKeys(emailId);
	}
	
	public void enterPassword(String pwd)
	{
		password.sendKeys(pwd);
	}

	public void clickSubmit(String buttonName)
	{
		if(buttonName.equals("Login"))
		login.click();
		else if(buttonName.equalsIgnoreCase("Forgot"))
			forgot.click();
		else if(buttonName.equalsIgnoreCase("Retrieve"))
			retrieve.click();
	}


	public AccountsPage doLogin(String emailId,String pwd)
	{
		username.sendKeys(emailId);
		password.sendKeys(pwd);
		login.click();
		return new AccountsPage(driver);
	}
}
