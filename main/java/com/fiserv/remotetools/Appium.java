package com.fiserv.remotetools;

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.fiserv.framework.constants.FrameworkConstants;

public class Appium {

	private WebDriver driver;
	private static Logger logger = Logger.getLogger(Appium.class);

	/**
	 * This will return appium Driver
	 * 
	 * @param capabilities
	 * @author swapnil.mane
	 */
	public WebDriver getAppiumDriver(DesiredCapabilities capabilities) {
		if (FrameworkConstants.getMobileConfig().get("EXECUTION_MODE").equalsIgnoreCase("local")) {
			getAppiumLocalDriver(capabilities);
		} else
			getAppiumGridDriver(capabilities);
		return driver;
	}

	/**
	 * This will return appium local Driver
	 * 
	 * @param capabilities
	 * @author swapnil.mane
	 */
	private void getAppiumLocalDriver(DesiredCapabilities capabilities) {

		try {
			driver = new RemoteWebDriver(new URL(FrameworkConstants.getMobileConfig().get("REMOTE_URL")), capabilities);
			logger.info("Appium Local driver is initialized");
		} catch (MalformedURLException e) {
			logger.error("Error Appium Local driver is initialization" + e.getMessage());
		}

	}

	/**
	 * This will return appium grid Driver
	 * 
	 * @param capabilities
	 * @author swapnil.mane
	 */
	private void getAppiumGridDriver(DesiredCapabilities capabilities) {

		try {
			driver = new RemoteWebDriver(new URL(FrameworkConstants.getMobileConfig().get("REMOTE_URL")), capabilities);
			logger.info("Appium grid driver is initialized");
		} catch (MalformedURLException e) {
			logger.error("Error Appium Grid driver is initialization" + e.getMessage());
		}

	}

}
