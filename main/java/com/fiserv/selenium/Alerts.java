/**
 * 
 */
package com.fiserv.selenium;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.fiserv.driverfactory.DriverFactory;
import com.fiserv.framework.constants.SetUpConstants;
import com.fiserv.framework.interfaces.IAlert;

/**
 * @author Dhiraj.Bendale
 *
 */
public class Alerts implements IAlert {

	private static Alerts instance = null;
	private static Logger logger = Logger.getLogger(Alerts.class);
	protected WebDriver driver = DriverFactory.getInstance().getDriver();
	
	private Alert simpleAlert;

	protected Alerts() {
		// Auto-generated constructor stub
	}

	/**
	 * It returns the instance of the BrowserAlert class
	 * 
	 * @return instance
	 */
	public static Alerts getInstance() {
		if (null == instance) {
			instance = new Alerts();
		}
		return instance;
	}

	/**
	 * Waits until the alert is present in given time
	 * 
	 * @return boolean Returns true/false as per the availability of the alert
	 */
	public boolean alertIsPresent() {
		logger.debug("Looking for element locator ");
		return alertIsPresentinTime(SetUpConstants.getDefaultTimeOut());
	}

	public boolean alertIsPresentinTime(int time) {
		 WebDriverWait wait = new WebDriverWait(driver, SetUpConstants.getDefaultTimeOut());
		logger.debug("Looking for element locator ");
		wait = new WebDriverWait(driver, time);
		try {
			wait.until(ExpectedConditions.alertIsPresent());
			logger.debug("Alert is found...");
			return true;
		} catch (Exception e) {
			logger.error("Alert not found...");
			return false;
		}
	}

	/**
	 * Used to dismiss the alert
	 * 
	 */
	public void close() {
		switchToAlert();
		simpleAlert.dismiss();
	}

	/**
	 * Used to accept the alert
	 */
	public void accept() {
		switchToAlert();
		simpleAlert.accept();

	}

	/**
	 * Used to switch to the alert pop up
	 */
	public void switchToAlert() {
		if (alertIsPresent()) {
			simpleAlert = driver.switchTo().alert();
		} else {
			Assert.fail("Alert is not found");
		}

	}

}
