package com.accelerate.keyword;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.testng.Assert;

import com.accelerate.pages.DataEntryPage;
import com.accelerate.pages.LoginPage;
import com.fiserv.framework.Report;
import com.fiserv.framework.constants.KeywordConstants;
import com.fiserv.keyword.Keywords;

public class login extends LoginPage {
	Logger log = Logger.getLogger(login.class.getName());
	// public CommonApplication cma = new CommonApplication();
	// public DataEntryPage dea = new DataEntryPage();

	@Keywords(description = "Login to Application", category = "Login", author = "ATeam")
	public void getLogin() {
		element.getURL("https://qauatmain175.prod1.lemansgroup.com/originateloans");

		// System.out.println("Test1");

		enterUserName(KeywordConstants.getKeyWordData().get("loginID"));
		enterPassword(KeywordConstants.getKeyWordData().get("password"));
		// Assert.assertTrue(false);
		submit();

	}

}

