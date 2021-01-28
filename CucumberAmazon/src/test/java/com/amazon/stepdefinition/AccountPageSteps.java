package com.amazon.stepdefinition;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.amazon.pages.AccountsPage;
import com.amazon.pages.LoginPage;
import com.qtp.webdriver.WebConnector;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;

public class AccountPageSteps {
	
	private LoginPage loginPage=new LoginPage(WebConnector.getDriver());
	private AccountsPage accountPage;
	
	@Given("User is logged into Application")
	public void user_is_logged_into_application(DataTable dataTable) {
	    List<Map<String,String>> credentialList = dataTable.asMaps();
	    String username = credentialList.get(0).get("username");
	    String password = credentialList.get(0).get("password");
	    WebConnector.getDriver().get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
	    accountPage=loginPage.doLogin(username,password);
	}

	@Given("User is on Account Page")
	public void user_is_on_account_page() {
	 String title = accountPage.getaccountPage();
	}

	@Then("user gets the accounts section")
	public void user_gets_the_accounts_section(DataTable dataTable) {
		List<String> expectedAccount=dataTable.asList();
		System.out.println(expectedAccount);
	    List<String> actualAccount =accountPage.getSectionsList();
	    System.out.println(actualAccount);
	    Assert.assertTrue(expectedAccount.containsAll(actualAccount));
	}

	@Then("account section count should be {int}")
	public void account_section_count_should_be(Integer int1) {
	    Assert.assertTrue(accountPage.getAccountcheckSections()==int1);
	}


}
