package com.global.keyword;

import com.fiserv.framework.constants.KeywordConstants;
import com.fiserv.keyword.Keywords;
import com.global.BaseElementPage;
import com.global.pages.Pages;

public class NewCustomer extends BaseElementPage implements Pages {

	@Keywords(description = "Navigate to new customer page", category = "New Customer", author = "Vimal Tyagi")
	public void openNewCustomerPage() {
		newCustomer.newCustomerLink();
	}

	@Keywords(description = "Create New Customer", category = "New Customer", author = "Vimal Tyagi")
	public void createNewCustomer() {
		newCustomer.enterField("Customer Number", KeywordConstants.getKeyWordData().get("Customer Number"));
		newCustomer.enterField("SSN", KeywordConstants.getKeyWordData().get("SSN"));
		newCustomer.enterField("First Name", KeywordConstants.getKeyWordData().get("First Name"));
		newCustomer.enterField("Last Name", KeywordConstants.getKeyWordData().get("Last Name"));
		newCustomer.enterField("Address Line 1", KeywordConstants.getKeyWordData().get("Address Line 1"));
		newCustomer.enterField("Address Line 2", KeywordConstants.getKeyWordData().get("Address Line 2"));
		newCustomer.enterField("Phone Number", KeywordConstants.getKeyWordData().get("Phone Number"));
		newCustomer.enterField("City", KeywordConstants.getKeyWordData().get("City"));
		newCustomer.enterField("Email Address", KeywordConstants.getKeyWordData().get("Email Address"));
		newCustomer.enterField("State", KeywordConstants.getKeyWordData().get("State"));
		newCustomer.enterField("Customer Credit Score ",
				KeywordConstants.getKeyWordData().get("Customer Credit Score"));
		newCustomer.enterField("Zip", KeywordConstants.getKeyWordData().get("Zip"));
		newCustomer.addCustomer();
	}
}
