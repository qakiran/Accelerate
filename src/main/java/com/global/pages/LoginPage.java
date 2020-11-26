package com.global.pages;

import org.openqa.selenium.By;

import com.global.BaseElementPage;

public class LoginPage extends BaseElementPage {

	private static LoginPage instance = null;

	protected LoginPage() {
	}

	private By userName = By.name("email");
	private By password = By.name("password");
	private By loginSubmit = By.xpath(".//fieldset/button");

	public static LoginPage getInstance() {
		if (null == instance) {
			instance = new LoginPage();
		}
		return instance;
	}

	public void enterUserName(String username) {
		element.sync().waitForSpinner(30);
		element.sync().pause(15);
		element.sendKeys(userName, username, "Enter GlobalBank username :" + username);
	}

	public void enterPassword(String userpassword) {
		element.sendKeys(password, userpassword, "Enter GlobalBank user pasword :" + userpassword);
	}

	public void submit() {
		element.click(loginSubmit, "Click on Submit");
	}

}
