/**
 * 
 */
package com.fiserv.selenium;

import static java.time.Duration.ofMillis;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import com.aventstack.extentreports.Status;
import com.fiserv.driverfactory.DriverFactory;
import com.fiserv.framework.Report;
import com.fiserv.framework.interfaces.ITouchAction;
import com.fiserv.framework.utility.selenium.Locator;

import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;

/**
 * @author Mohammad.Nazim
 *
 */
public class TouchActions implements ITouchAction {

	protected WebDriver driver = DriverFactory.getInstance().getDriver();
	private static Logger logger = Logger.getLogger(Dropdown.class);
	private Report report = Report.getInstance();
	private static TouchActions instance = null;
	protected Locator locator = Locator.getInstance();
	String direction = "direction";
	String mobileSwipe = "mobile: swipe";
	String mobileScroll = "mobile: scroll";
	String elementTxt = "element";

	protected TouchActions() {
		// Auto-generated constructor stub
	}

	/**
	 * It returns the instance of the BrowserDropdown class
	 * 
	 * @return instance
	 */
	public static TouchActions getInstance() {
		if (null == instance) {
			instance = new TouchActions();
		}
		return instance;
	}

	/**
	 * It is used to swipe left without element on mobile screen matches the
	 * specified parameter
	 * 
	 * @param numOfSwipe
	 * 
	 */
	public void swipeLeft(int numOfSwipe) {
		for (int num = 0; num < numOfSwipe; num++) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			Map<String, String> scrollObject = new HashMap<>();
			scrollObject.put(direction, "left");
			js.executeScript(mobileSwipe, scrollObject);
			logger.debug("Swipe left");
			report.log("Swipe left successfully", "", Status.PASS);
		}

	}

	/**
	 * It is used to swipe left with element on mobile screen matches the
	 * specified parameter
	 * 
	 * @param locatorElement,
	 *            numOfSwipe
	 * 
	 */
	public void swipeLeft(By locatorElement, int numOfSwipe) {
		WebElement element = (WebElement) locatorElement;
		for (int num = 0; num < numOfSwipe; num++) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			Map<String, String> scrollObject = new HashMap<>();
			scrollObject.put(direction, "left");
			scrollObject.put(elementTxt, ((RemoteWebElement) element).getId());
			js.executeScript(mobileSwipe, scrollObject);
			logger.debug("Swipe left");
			report.log("Swipe left successfully", "", Status.PASS);
		}

	}

	/**
	 * It is used to swipe right without element on mobile screen matches the
	 * specified parameter
	 * 
	 * @param numOfSwipe
	 * 
	 */
	public void swipeRight(int numOfSwipe) {
		for (int num = 0; num < numOfSwipe; num++) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			Map<String, String> scrollObject = new HashMap<>();
			scrollObject.put(direction, "right");
			js.executeScript(mobileSwipe, scrollObject);
			logger.debug("Swipe right");
			report.log("Swipe right successfully", "", Status.PASS);
		}

	}

	/**
	 * It is used to swipe right with element on mobile screen matches the
	 * specified parameter
	 * 
	 * @param locatorElement,
	 *            numOfSwipe
	 * 
	 */
	public void swipeRight(By locatorElement, int numOfSwipe) {
		WebElement element = (WebElement) locatorElement;
		for (int num = 0; num < numOfSwipe; num++) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			Map<String, String> scrollObject = new HashMap<>();
			scrollObject.put(direction, "right");
			scrollObject.put(elementTxt, ((RemoteWebElement) element).getId());
			js.executeScript(mobileSwipe, scrollObject);
			logger.debug("Swipe right");
			report.log("Swipe right successfully", "", Status.PASS);
		}

	}

	/**
	 * It is used to scroll up without element on mobile screen matches the
	 * specified parameter
	 * 
	 * @param numOfScroll
	 * 
	 */
	public void scrollUp(int numOfScroll) {
		for (int num = 0; num < numOfScroll; num++) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			Map<String, String> scrollObject = new HashMap<>();
			scrollObject.put(direction, "up");
			js.executeScript(mobileScroll, scrollObject);
			logger.debug("Scroll up");
			report.log("Scroll up successfully", "", Status.PASS);
		}

	}

	/**
	 * It is used to scroll down without element on mobile screen matches the
	 * specified parameter
	 * 
	 * @param numOfScroll
	 * 
	 */
	public void scrollDown(int numOfScroll) {
		for (int num = 0; num < numOfScroll; num++) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			Map<String, String> scrollObject = new HashMap<>();
			scrollObject.put(direction, "down");
			js.executeScript(mobileScroll, scrollObject);
			logger.debug("Scroll down");
			report.log("Scroll down successfully ", "", Status.PASS);
		}

	}

	/**
	 * It is used to scroll down with element on mobile screen matches the
	 * specified parameter
	 * 
	 * @param locatorElement,
	 *            numOfScroll
	 * 
	 */
	public void scrollDown(By locatorElement, int numOfScroll) {
		WebElement element = (WebElement) locatorElement;
		for (int num = 0; num < numOfScroll; num++) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			Map<String, String> scrollObject = new HashMap<>();
			scrollObject.put(direction, "down");
			scrollObject.put(elementTxt, ((RemoteWebElement) element).getId());
			js.executeScript(mobileScroll, scrollObject);
			logger.debug("Scroll down");
			report.log("Scroll down successfully.", "", Status.PASS);
		}
	}

	/**
	 * It is used to scroll up with element on mobile screen matches the
	 * specified parameter
	 * 
	 * @param locatorElement,
	 *            numOfScroll
	 * 
	 */
	public void scrollUp(By locatorElement, int numOfScroll) {
		WebElement element = (WebElement) locatorElement;
		for (int num = 0; num < numOfScroll; num++) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			Map<String, String> scrollObject = new HashMap<>();
			scrollObject.put(direction, "up");
			scrollObject.put(elementTxt, ((RemoteWebElement) element).getId());
			js.executeScript(mobileScroll, scrollObject);
			logger.debug("Scroll up");
			report.log("Scroll up successfully", "", Status.PASS);
		}

	}

	public boolean scrollTo(int scrollViewIndex, String listElementClass, String textOnListElement) {
		// Auto-generated method stub
		return false;
	}

	public boolean scrollTo(String uiSelectorQuery) {
		// Auto-generated method stub
		return false;
	}

	public void dragFromTo(Integer xStart, Integer yStart, Integer xEnd, Integer yEnd) {
		// Auto-generated method stub

	}

	/**
	 * It is used to scroll down on the basis of coordinates matches the
	 * specified parameter
	 * 
	 * @param xStart,yStart,
	 *            xEnd & yEnd
	 * 
	 */
	public void scrollFromTo(Integer xStart, Integer yStart, Integer xEnd, Integer yEnd) {
		new TouchAction((PerformsTouchActions) driver).press(xStart, yStart).waitAction(ofMillis(445))
				.moveTo(xEnd, yEnd).release().perform();
		logger.debug("Scroll down on the basis of coordinate");
		report.log("Scroll down successfully..", "", Status.PASS);
	}

}
