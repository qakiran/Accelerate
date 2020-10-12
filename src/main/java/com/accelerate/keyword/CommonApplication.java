package com.accelerate.keyword;
//test 


import org.testng.Assert;

import com.accelerate.pages.CommonApplicationPage;
import com.fiserv.keyword.Keywords;
import com.fiserv.framework.constants.KeywordConstants;

public class CommonApplication extends CommonApplicationPage {

	@Keywords(description = "Click New Consumer", category = "CreateApp", author = "ATeam")
	public void clickNewConsumer() {
		selectApplication();
		clickNewConsumerBttn();
	}

	@Keywords(description = "Quick Search", category = "SearchApp", author = "ATeam")
	public void searchApp() {
		selectApplication();
		String actAppId;
		actAppId= quickSearch(KeywordConstants.getKeyWordData().get("Appid"));
		Assert.assertEquals(actAppId, KeywordConstants.getKeyWordData().get("Appid"));
		
	
	}

	@Keywords(description = "Logout of Application", category = "Logout", author = "ATeam")
	public void getLogout() {
		clickLogout();
		element.window().closeWindow();

	}

	
}

