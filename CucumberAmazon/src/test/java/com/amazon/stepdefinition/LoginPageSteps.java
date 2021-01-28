package com.amazon.stepdefinition;

import org.junit.Assert;

import com.amazon.pages.LoginPage;
import com.qtp.webdriver.WebConnector;


import io.cucumber.java.en.*;

public class LoginPageSteps {
	private LoginPage loginPage=new LoginPage(WebConnector.getDriver());
	String title;
	@Given("^user opens browser$")
	public void user_opens_browser() {
	   
	}

	@Given("^User enters URl$")
	public void user_enters_URl() {
	    
	}

	@Given("^User is on login page$")
	public void user_is_on_login_page() {
	    WebConnector.getDriver().get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
	}

	@When("^user gets the title of page$")
	public void user_gets_the_title_of_page() {
	 title= WebConnector.getDriver().getTitle();
	}

	@Then("^page title should be (.*)$")
	public void page_title_should_be(String expectedTitle) {
		Assert.assertTrue(title.equalsIgnoreCase(expectedTitle));
	}

	@When("^user enters username \"([^\"]*)\"$")
	public void user_enters_username(String string) {
		loginPage.enterUsername(string);
	}


	@And("^user enters on Password \"([^\"]*)\"$")
	public void user_enters_on_Password(String string) {
		System.out.println(string);
	    loginPage.enterPassword(string);
	}

	@When("^user clicks on (.*) button$")
	public void clickButton(String button) {
	   loginPage.clickSubmit(button);
	}

}
