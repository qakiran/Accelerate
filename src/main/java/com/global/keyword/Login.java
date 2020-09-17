package com.global.keyword;

import com.fiserv.framework.constants.KeywordConstants;
import com.fiserv.keyword.Keywords;
import com.global.BaseElementPage;
import com.global.pages.Pages;

public class Login extends BaseElementPage implements Pages {

	@Keywords(description = "Login to Global Bank", category = "Login", author = "Vimal Tyagi")
	public void getLogin() {
		element.getURL("http://p2pcsgh815qjqd.fiserv.co.in:8080/JstromWebApp");
		loginPage.enterUserName(KeywordConstants.getKeyWordData().get("loginID"));
		loginPage.enterPassword(KeywordConstants.getKeyWordData().get("password"));
		loginPage.submit();
	}
}
