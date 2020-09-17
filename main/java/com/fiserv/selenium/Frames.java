/**
 * 
 */
package com.fiserv.selenium;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.fiserv.driverfactory.DriverFactory;
import com.fiserv.framework.constants.SetUpConstants;
import com.fiserv.framework.interfaces.IFrame;

/**
 * @author Dhiraj.Bendale
 *
 */
public class Frames implements IFrame {

	private static Frames instance = null;
	protected WebDriver driver = DriverFactory.getInstance().getDriver();
	private static Logger logger = Logger.getLogger(Frames.class);
	private WebDriverWait wait = new WebDriverWait(driver, SetUpConstants.getDefaultTimeOut());

	protected Frames() {
		//  Auto-generated constructor stub
	}

	/**
	   * It returns the instance of the BrowserFrames class
	   * @return instance 
	   */
	public static Frames getInstance() {
		if (null == instance) {
			instance = new Frames();
		}
		return instance;
	}

	/**
	 * Selects either the first frame on the page, or the main document when a page contains
     * iframes
	 * @author Dhiraj.Bendale
	 * 
	 */
	public void setDefaultFrame() {
		driver.switchTo().defaultContent();
	}

	/**
	   * Switch to the desired frame by passing the element locator	 
	   * @author dhiraj.bendale
	   * @param elementLocator used to find the frame
	   * 
	   */
	public void switchToFrame(By elementLocator) {
		logger.debug("Looking for element locator...." + elementLocator);
		try {
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(elementLocator));
			logger.debug("Elemnt locator found..." + elementLocator);
		} catch (Exception e) {
			logger.error("Element locator id found...." + elementLocator);
			Assert.fail("Frame locator " + elementLocator + "not found.");
		}
	}

	/**
	 * Switch to the desired frame by passing the index of the frame
	 * @param frameIndex used to find the index number
	 * @author Dhiraj.Bendale
	 *
	 */
	public void switchToFrame(int frameIndex) {
		logger.debug("Looking for element locator....." + frameIndex);
		try {
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameIndex));
			logger.debug("Elemnt locator found..." + frameIndex);
		} catch (Exception e) {
			logger.error("Element locator id found.." + frameIndex);
			Assert.fail("Frame index " + frameIndex + " not found. ");
		}

	}

	/**
	 * Switch to the desired frame by passing the name of the frame
	 * @param frameName used to find the frame name
	 * @author Dhiraj.Bendale
	 *
	 */
	public void switchToFrame(String frameName) {
		logger.debug("Looking for element locator." + frameName);
		try {
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameName));
			logger.debug("Elemnt locator found" + frameName);
		} catch (Exception e) {
			logger.error("Element locator id found-" + frameName);
			Assert.fail("Frame name " + frameName + "not found");
		}
	}
}