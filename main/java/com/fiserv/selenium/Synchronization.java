/**
 * 
 */
package com.fiserv.selenium;

import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.fiserv.driverfactory.DriverFactory;
import com.fiserv.framework.constants.SetUpConstants;
import com.fiserv.framework.interfaces.ISynchronization;

/**
 * @author Dhiraj.Bendale
 *
 */
public class Synchronization implements ISynchronization {

	protected WebDriver driver = DriverFactory.getInstance().getDriver();
	private static Logger logger = Logger.getLogger(Synchronization.class);
	private WebDriverWait wait = new WebDriverWait(driver, SetUpConstants.getDefaultTimeOut());

	private static Synchronization instance = null;

	protected Synchronization() {
		// Auto-generated constructor stub
	}

	/**
	 * It returns the instance of the BrowserSynchronization class
	 * 
	 * @return instance This is the instance of BrowserSynchronization
	 */
	public static Synchronization getInstance() {
		if (null == instance) {
			instance = new Synchronization();
		}
		return instance;
	}

	/**
	 * Wait for a particular element of the webpage by element locator
	 * 
	 * @param elementLocator
	 *            This is the element locator
	 */
	public void waitForElement(By elementLocator) {
		waitForElementinTime(elementLocator, SetUpConstants.getDefaultTimeOut());

	}

	/**
	 * Wait for a particular element of the webpage for given time and for given
	 * element location
	 * 
	 * @param elementLocator
	 *            This is the element locator
	 * @param time
	 *            This is wait time
	 */
	public void waitForElementinTime(By elementLocator, int time) {
		logger.debug("Looking for element locator " + elementLocator + " for time..." + time);
		wait = new WebDriverWait(driver, time);
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
			logger.debug("Elemnt locator found..." + elementLocator);
		} catch (Exception e) {
			logger.error("Element locator id not found..." + elementLocator);
			Assert.fail("Element locator id not found...");
		}
	}

	/**
	 * Wait for a particular element of the webpage to be clickable by using
	 * element locator
	 * 
	 * @param elementLocator
	 *            This is the element locator
	 */
	public void elementToBeClickable(By elementLocator) {
		isElementClickableinTime(elementLocator, SetUpConstants.getDefaultTimeOut());
	}

	/**
	 * Wait for a particular element of the webpage to be clickable in given
	 * time by using element locator
	 * 
	 * @param elementLocator
	 *            This is the element locator
	 * @param time
	 *            This is the wait time
	 */
	public void isElementClickableinTime(By elementLocator, int time) {
		wait = new WebDriverWait(driver, time);
		logger.debug("Looking for element locator to clickable " + elementLocator + " for time..." + time);
		try {
			wait.until(ExpectedConditions.elementToBeClickable(elementLocator));
			logger.debug("Elemnt locator found..." + elementLocator);
		} catch (Exception e) {
			logger.error("Element locator not clickable..." + elementLocator);
			Assert.fail("Element locator not clickable...");
		}

	}

	/**
	 * Wait for a particular element of the webpage to be invisible for click by
	 * using element locator
	 * 
	 * @param elementLocator
	 *            This is the element locator
	 */
	public void waitForInvisibility(By elementLocator) {
		logger.debug("Looking for element locator for Invisibility" + elementLocator + " in default time..."
				+ SetUpConstants.getDefaultTimeOut());
		waitForInvisibilityinTime(elementLocator, SetUpConstants.getDefaultTimeOut());
	}

	/**
	 * Wait for a particular element of the webpage to be invisible for click in
	 * given time by using element locator
	 * 
	 * @param elementLocator
	 *            This is the element locator
	 * @param time
	 *            This is the wait time.
	 */
	public void waitForInvisibilityinTime(By elementLocator, int time) {
		wait = new WebDriverWait(driver, time);
		try {
			logger.debug("Looking for element locator for Invisibility" + elementLocator + " for time..." + time);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(elementLocator));
			logger.debug("Elemnt locator found..." + elementLocator);
		} catch (Exception e) {
			logger.error("Element locator not invisible..." + elementLocator);
			Assert.fail("Element locator not invisible...");
		}

	}

	/**
	 * Wait for a particular element of the webpage to be visible after regular
	 * intervals until its visible
	 * 
	 * @param elementLocator
	 *            This is the element locator
	 */
	public void fluentWaitForElement(By elementLocator) {
		fluentWaitinTimeForElement(elementLocator, SetUpConstants.getDefaultTimeOut());

	}

	/**
	 * Wait for a particular element of the webpage to be visible after regular
	 * intervals until its visible or given time over
	 * 
	 * @param elementLocator
	 *            This is the element locator
	 * @param time
	 *            This is wait time
	 */
	public void fluentWaitinTimeForElement(final By elementLocator, int time) {
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
		wait.pollingEvery(time, TimeUnit.SECONDS);
		wait.withTimeout(SetUpConstants.getDefaultTimeOut(), TimeUnit.SECONDS);
		wait.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.presenceOfElementLocated(elementLocator));
	}

	/**
	 * Wait for a particular time after or before any operation is performed
	 * 
	 * @param sleep
	 *            Time to wait
	 */
	public void pause(int sleep) {
		try {
			TimeUnit.SECONDS.sleep(sleep);
		} catch (InterruptedException e) {
			logger.error("Exception.. " + e.getMessage());
		}
	}

	/**
	 * Wait for a particular time for the angular application to be completely
	 * processed
	 * 
	 * @param waitTime
	 *            Time to wait
	 */
	public void waitForSpinner(int waitTime) {
		WebDriverWait wait = new WebDriverWait(driver, waitTime, 100);
		wait.until(angularHasFinishedProcessing());

	}

	private static ExpectedCondition<Boolean> angularHasFinishedProcessing() {
		return new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return Boolean.valueOf(((JavascriptExecutor) driver).executeScript(
						"return (window.angular !== undefined) && (angular.element(document).injector() !== undefined) && (angular.element(document).injector().get('$http').pendingRequests.length === 0)")
						.toString());
			}
		};
	}
}
