package com.fiserv.selenium;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.Status;
import com.fiserv.driverfactory.DriverFactory;
import com.fiserv.framework.Report;

/**
 * 
 * @author Dhiraj.Bendale
 *
 */

public class Elements {
	protected WebDriver driver = DriverFactory.getInstance().getDriver();
	private static Logger logger = Logger.getLogger(Elements.class);
	private Synchronization sync = Synchronization.getInstance();
	private static Elements instance = null;
	protected static Report report = Report.getInstance();

	protected Elements() {

	}

	/**
	 * It returns the instance of the BrowserElements class
	 * 
	 * @return instance This is the instance of BrowserElements
	 */
	public static Elements getInstance() {
		if (null == instance) {
			instance = new Elements();
		}
		return instance;
	}

	/**
	 * Used to set value into the element
	 * 
	 * @param elementLocator
	 *            This is the element locator
	 * @param value
	 *            The value to be set
	 * @param description
	 *            Message describing the value to be set in the element
	 */
	public void sendKeys(By elementLocator, String value, String description) {
		clear(elementLocator);
		driver.findElement(elementLocator).sendKeys(value);
		logger.debug("Enter value " + value + " of " + elementLocator);
		report.log(description, value, Status.PASS);
	}

	/**
	 * Used to Click the element
	 * 
	 * @param elementLocator
	 *            This is the element locator
	 * @param description
	 *            Message describing the click event
	 */
	public void click(By elementLocator, String description) {
		sync.waitForElement(elementLocator);
		driver.findElement(elementLocator).click();
		report.log(description, "", Status.PASS);
	}

	/**
	 * Used to Clear the element
	 * 
	 * @param elementLocator
	 *            This is the element locator
	 */
	public void clear(By elementLocator) {
		sync.waitForElement(elementLocator);
		driver.findElement(elementLocator).clear();
	}

	/**
	 * Used to get the visible innerText of this element, including
	 * sub-elements, without any leading or trailing whitespace.
	 * 
	 * @param elementLocator
	 *            This is the element locator
	 * @return StringValue The innerText of this element as string value
	 */
	public String getText(By elementLocator) {
		sync.waitForElement(elementLocator);
		logger.debug("Elemnt locator get text ..." + driver.findElement(elementLocator).getText());
		return driver.findElement(elementLocator).getText();
	}

	/**
	 * Used to get the value of the given attribute of the element
	 * 
	 * @param elementLocator
	 *            This is the element locator
	 * @param attribute
	 *            Attribute whose value is to be fetched
	 * @return AttributeValue The current value, even if this has been modified
	 *         after the page has been loaded.
	 */
	public String getAttribute(By elementLocator, String attribute) {
		sync.waitForElement(elementLocator);
		logger.debug("Elemnt locator get text ..." + driver.findElement(elementLocator).getAttribute(attribute));
		return driver.findElement(elementLocator).getAttribute(attribute);
	}

	/**
	 * Used to check if the element is currently enabled or not
	 * 
	 * @param elementLocator
	 *            This is the element locator
	 * @return BooleanValue True if the element is enabled, false otherwise
	 */
	public boolean isEnabled(By elementLocator) {
		sync.waitForElement(elementLocator);
		return driver.findElement(elementLocator).isEnabled();

	}

	/**
	 * Used to check if the element is currently displayed or not
	 * 
	 * @param elementLocator
	 *            This is the element locator
	 * @return BooleanValue True if the element is displayed, false otherwise
	 */
	public boolean isDisplayed(By elementLocator) {
		sync.waitForElement(elementLocator);
		return driver.findElement(elementLocator).isDisplayed();
	}

	/**
	 * Used to check if the element is currently selected or not
	 * 
	 * @param elementLocator
	 *            This is the element locator
	 * @return BooleanValue True if the element is currently selected or
	 *         checked, false otherwise
	 */
	public boolean isSelected(By elementLocator) {
		sync.waitForElement(elementLocator);
		return driver.findElement(elementLocator).isSelected();
	}

	/**
	 * Get URL in to Browser
	 * 
	 * @param URL
	 *            of application
	 */
	public void getURL(String url) {
		driver.get(url);
	}
}
