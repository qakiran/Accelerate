/**
 * 
 */
package com.fiserv.selenium;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.Status;
import com.fiserv.driverfactory.DriverFactory;
import com.fiserv.framework.Report;

import com.fiserv.framework.interfaces.IJavascriptExecute;

/**
 * @author Dhiraj.Bendale
 *
 */
public class JavascriptExecute implements IJavascriptExecute {

	private static JavascriptExecute instance = null;
	protected WebDriver driver = DriverFactory.getInstance().getDriver();
	private static Logger logger = Logger.getLogger(JavascriptExecute.class);
	protected Elements browserElement = new Elements();
	private JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
	private Report report = Report.getInstance();

	protected JavascriptExecute() {
		// Auto-generated constructor stub
	}

	/**
	 * It returns the instance of the BrowserJavascriptExecute class
	 * 
	 * @return instance
	 */
	public static JavascriptExecute getInstance() {
		if (null == instance) {
			instance = new JavascriptExecute();
		}
		return instance;
	}

	/**
	 * Used to click an element by javascript executor
	 * 
	 * @param elementLocator
	 *            This is the element locator
	 */
	public void click(By elementLocator) {
		try {
			if (browserElement.isEnabled(elementLocator) && browserElement.isDisplayed(elementLocator)) {
				jsExecutor.executeScript("arguments[0].click();", driver.findElement(elementLocator));
				report.log("Method Pass - Element clicked ", "", Status.PASS);
			} else {
				report.log("Method Fail - Element  Not clicked ", "", Status.FAIL);
			}
		} catch (Exception e) {
			logger.info(e.getMessage());
		}

	}

	/**
	 * Used to scroll down a page using javascript executor
	 * 
	 * @param scrollFrom
	 *            Starting point
	 * @param scrollTo
	 *            Ending Point
	 */
	public void scrollDownTo(int scrollFrom, int scrollTo) {
		jsExecutor.executeScript("scroll(" + Integer.toString(scrollFrom) + "," + Integer.toString(scrollFrom) + ")");
		report.log("Method Pass - Scrolled from " + scrollFrom + "- " + scrollTo, " ", Status.PASS);
	}

	/**
	 * Used to scroll down to bottom of the webpage using javascript executor
	 */
	public void scrollToBottom() {
		jsExecutor.executeScript(
				"window.scrollTo(0,Math.max(document.documentElement.scrollHeight,document.body.scrollHeight,document.body.clientHeight));");
		report.log("Method Pass - Scrolled to bottom of the page ", " ", Status.PASS);
	}

	/**
	 * Used to scroll to element location using javascript executor
	 * 
	 * @param elementLocator
	 *            This is the element locator
	 */
	public void scrollToElement(By elementLocator) {
		if (browserElement.isEnabled(elementLocator) && browserElement.isDisplayed(elementLocator)) {
			jsExecutor.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(elementLocator));
			report.log("Method Pass - Scrolled by Element- " + elementLocator, " ", Status.PASS);
		} else {
			report.log("Method Fail - Not Scrolled to Element ", "", Status.FAIL);
		}
	}

	/**
	 * Used to scroll to element location using javascript executor and click it
	 * 
	 * @param elementLocator
	 *            This is the element locator
	 */
	public void scrollToElementClick(By elementLocator) {
		scrollToElement(elementLocator);
		click(elementLocator);
		report.log("Method Pass - Scrolled by Element and click- " + elementLocator, " ", Status.PASS);
	}

	/**
	 * Used to highlight element location using javascript executor
	 * 
	 * @param element
	 *            The element under test
	 */
	public void highligthElement(WebElement element) {
		logger.info("Highlighting element " + element);
		jsExecutor.executeScript("arguments[0].style.border='3px solid red'", element);
		report.log("Method Pass - Highlight the Element- " + element, " ", Status.PASS);
	}

	/**
	 * Used to un-highlight element location using javascript executor
	 * 
	 * @param element
	 *            The element under test
	 */
	public void unHighligthElement(WebElement element) {
		logger.info("Highlighting element " + element);
		jsExecutor.executeScript("arguments[0].style.border='0px'", element);
		report.log("Method Pass - sUnHighlight the Element- " + element, " ", Status.PASS);
	}

	/**
	 * Used to set value into the element
	 * 
	 * @param inputField
	 *            - This is the element locator
	 * @param Value
	 *            - The value to be set
	 */
	public void sendKeysJS(By inputField, String value) {
		logger.info("Message to enter " + value);
		if (browserElement.isEnabled(inputField) && browserElement.isDisplayed(inputField)) {
			jsExecutor.executeScript("arguments[0].value='" + value + "';", driver.findElement(inputField));
			report.log("Method Pass - Text entered - " + value, " ", Status.PASS);
		} else {
			report.log("Method Fail - Text not entred as Element not found- " + inputField, " ", Status.FAIL);
		}
	}

	/**
	 * Gives the tile of the current page
	 */
	public void getTitleJS() {

		String titleName = jsExecutor.executeScript("return document.title;").toString();

		report.log("Method Pass - Title of the page: " + titleName, " ", Status.PASS);
	}

	/**
	 * Refresh page using javaScript executor
	 */
	public void refreshPage() {
		jsExecutor.executeScript("location.reload()");
		report.log("Method Pass - PAGE Refreshed ", " ", Status.PASS);
	}

}
