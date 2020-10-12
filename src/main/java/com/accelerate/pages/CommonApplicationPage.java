package com.accelerate.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.fiserv.framework.interfaces.ISynchronization;
import com.sun.org.apache.xpath.internal.operations.Bool;
import com.fiserv.framework.interfaces.IKeyboardAndMouseActions;

import com.accelerate.BaseElementPage;

public class CommonApplicationPage extends BaseElementPage {

	public void searchApp(String SearchApp) {
	}

	public By clickLogout = By.xpath("//a[@title='logout']");
	public By selectApplication = By.xpath("//span[text()='Application']");
	
	public By clickNewApplication = By.xpath("//a[@title='New Application']");
	
	public By clickNewConsumerApplication = By.xpath("//a[contains(text(),'New Consumer')]");

	// Quick Search
	public By quickSearch = By.xpath("//*[@id=\"search\"]");
	public By quickSearchicon = By.xpath(
			"//*[@class='input-group-btn smart-search-icon']/button[@type='button']/span[@class='k-i-search k-icon font-size-16 color-blue']");
	public By appNumber = By.xpath("//app-action-bar/ul/li[3]/a");

	public By appmenu = By.xpath("//a[@title='Application Menu']/i[text()='menu']");
	public By loanDetails = By.xpath("//a[text()='Loan Details']");
	

	

	
	
	public void clickLogout() {
		
		element.sync().pause(5);
		element.window().closeWindow();

	}

	public void selectApplication() {
		
		element.sync().pause(25);
		element.click(selectApplication, "Click Application ");
		element.sync().pause(5);

	}

	public void clickNewConsumerBttn() {
		
		System.out.println("loading page completed");
			element.sync().pause(20);
        
		element.click(clickNewApplication, "Click on New Application button");
		System.out.println("New Application button found");
		element.sync().pause(5);
		
		element.click(clickNewConsumerApplication, "Click on New Consumer Option");
		System.out.println("clicked on Create New Consumer");
		element.sync().pause(5);
		
	}
	

	public String quickSearch(String searchApp) {
	        element.sync().pause(10);
			System.out.println("inside the method quicksearch");
			element.sendKeys(quickSearch, String.valueOf(searchApp), "Enter Appid :" + searchApp);
			element.mouseActions(quickSearch).keyStroke("Enter");
			System.out.println("clicked enter key");
			element.sync().pause(10);
			element.sync().waitForElement(appNumber);
			String appid = element.getText(appNumber);
			System.out.println(appid);
			String app =appid.split(":")[1];
			return app;

	}

}




