package com.fiserv.accessibility.selenium;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import com.aventstack.extentreports.Status;
import com.fiserv.accessibility.framework.AccessibilityLibrary;
import com.fiserv.framework.Report;

public class Elements {

	private static Logger logger = Logger.getLogger(Elements.class);
	private static Elements instance = null;
	protected Report report = Report.getInstance();
	protected FindElement find = FindElement.getInstance();
	protected AccessibilityLibrary accLib = AccessibilityLibrary.getInstance();

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
	 * @author Shivang.Ahuja
	 */
	public void sendKeys(By elementLocator, String value, String description) {
		clear(elementLocator);
		find.findElementWithAccessibility(elementLocator).sendKeys(value);
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
	 * @author Shivang.Ahuja
	 */
	public void click(By elementLocator, String description) {
		find.findElementWithAccessibility(elementLocator).click();
		report.log(description, "", Status.PASS);
	}

	/**
	 * Used to Clear the element, here we are not doing accessibility test since
	 * clear function called in other functions
	 * 
	 * @param elementLocator
	 *            This is the element locator
	 * @author Shivang.Ahuja
	 */
	public void clear(By elementLocator) {
		find.driver.findElement(elementLocator).clear();
	}

	/**
	 * Used to get the visible innerText of this element, including
	 * sub-elements, without any leading or trailing whitespace.
	 * 
	 * @param elementLocator
	 *            This is the element locator
	 * @return StringValue The innerText of this element as string value
	 * @author Shivang.Ahuja
	 */
	public String getText(By elementLocator) {
		logger.debug("Elemnt locator get text ..." + find.driver.findElement(elementLocator).getText());
		return find.findElementWithAccessibility(elementLocator).getText();
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
	 * @author Shivang.Ahuja
	 */
	public String getAttribute(By elementLocator, String attribute) {
		logger.debug("Elemnt locator get text ..." + find.driver.findElement(elementLocator).getAttribute(attribute));
		return find.findElementWithAccessibility(elementLocator).getAttribute(attribute);
	}

	/**
	 * Used to check if the element is currently enabled or not
	 * 
	 * @param elementLocator
	 *            This is the element locator
	 * @return BooleanValue True if the element is enabled, false otherwise
	 * @author Vimal.Tyagi
	 */
	public boolean isEnabled(By elementLocator) {
		return find.findElementWithAccessibility(elementLocator).isEnabled();

	}

	/**
	 * Used to check if the element is currently displayed or not
	 * 
	 * @param elementLocator
	 *            This is the element locator
	 * @return BooleanValue True if the element is displayed, false otherwise
	 * @author Vimal.Tyagi
	 */
	public boolean isDisplayed(By elementLocator) {
		return find.findElementWithAccessibility(elementLocator).isDisplayed();
	}

	/**
	 * Used to check if the element is currently selected or not
	 * 
	 * @param elementLocator
	 *            This is the element locator
	 * @return BooleanValue True if the element is currently selected or
	 *         checked, false otherwise
	 * @author Vimal.Tyagi
	 */
	public boolean isSelected(By elementLocator) {
		return find.findElementWithAccessibility(elementLocator).isSelected();
	}

	/**
	 * Get URL in to Browser
	 * 
	 * @param URL
	 *            of application
	 * @author Vimal.Tyagi
	 */
	public void getURL(String url) {
		find.driver.get(url);
		accLib.pageLevelAccessibilityTest();
	}
}
