package com.global.pages;

import org.openqa.selenium.By;

import com.global.BaseElementPage;

public class NewCustomerPage extends BaseElementPage {

	private String textFields = "//label[text()='%s']/parent::*//input";
	private By nonFin = By.xpath("//li/a[contains(.,'Non')]");
	private By newCustomer = By.xpath("//li/a[contains(.,'New Customer')]");
	private By SubmitButton = By.id(".//div[2]/button[1]");
	private By addCustomer = By.xpath("//*[@id='page-wrapper']//button[.='Add']");
	private static NewCustomerPage instance = null;

	public static NewCustomerPage getInstance() {
		if (null == instance) {
			instance = new NewCustomerPage();
		}
		return instance;
	}

	public void enterField(String field, String value) {
		element.sendKeys(By.xpath(String.format(textFields, field)), value, "Enter " + field + " :- " + value);

	}

	public void addCustomer() {
		element.click(addCustomer, "Add New customer");
	}

	public void newCustomerLink() {
		element.click(nonFin, "Click on Non Financial Transaction");
		element.click(newCustomer, "Click on New Customer");
	}

	/**
	 * click on Submit button
	 * 
	 * @param Submit
	 */
	public void SubmitButtonClick(String Submit) {
		element.click(SubmitButton, " customer added ");
	}

}
