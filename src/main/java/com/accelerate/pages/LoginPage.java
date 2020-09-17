package com.accelerate.pages;

import org.openqa.selenium.By;

import com.accelerate.BaseElementPage;
import com.accelerate.BrowserElement;
import com.aventstack.extentreports.Status;
import com.fiserv.framework.Report;
import com.fiserv.framework.interfaces.ISynchronization;

public class LoginPage extends BaseElementPage {

	// BrowserElement newfunc = new BrowserElement();

	public void login(String username, String password) {
	}

	private By userName = By.name("txtUserName");
	private By password = By.id("txtPassword");
	private By loginSubmit = By.xpath("//button[@type='submit']");

	public void enterUserName(String username) {
		// try {
		// element.sync().waitForSpinner(30);
		element.sync().waitForElement(userName);
		// Thread.sleep(5000);
		System.out.println("username entered");
		element.sendKeys(userName, username, "Enter accelerate username :" + username);
		// } catch (InterruptedException e) {
		// TODO Auto-generated catch block

		// e.printStackTrace();
		// }

	}

	public void enterPassword(String userpassword) {
		element.sendKeys(password, userpassword, "Enter accelerate user pasword :" + userpassword);
	}

	public void submit() {
		element.click(loginSubmit, "Click on Submit");
		//element.sync().waitForSpinner(25);
		// try {
		// element.sync().waitForElementinTime(loginSubmit, 30);
		/*
		 * } catch (InterruptedException e) { //TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 */

	}

}
