package com.fiserv.remotetools;

import java.net.URL;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import com.fiserv.framework.constants.FrameworkConstants;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

public class SeeTest {

	private WebDriver driver;
	private static Logger logger = Logger.getLogger(SeeTest.class);
	private static final String PLATFORM_OS = "PLATFORM_OS";

	/**
	 * This will return getSeetest Driver
	 * 
	 * @param driver,driver
	 * @author swapnil.mane
	 */
	public WebDriver getSeetestDriver(DesiredCapabilities capabilities) {
		if (FrameworkConstants.getMobileConfig().get("EXECUTION_MODE").equalsIgnoreCase("local")) {
			getSeetestLocalDriver(capabilities);
		} else if (FrameworkConstants.getMobileConfig().get("EXECUTION_MODE").equalsIgnoreCase("grid")) {
			getSeetestGridDriver(capabilities);
		} else
			logger.info("Check mobile config TARGET_MODE value");
		return driver;
	}

	/**
	 * This will give seetest Local Driver
	 * 
	 * @param capability
	 * @author swapnil.mane
	 */
	private WebDriver getSeetestLocalDriver(DesiredCapabilities capability) {
		try {
			if (FrameworkConstants.getMobileConfig().get(PLATFORM_OS).equalsIgnoreCase("android")) {
				driver = new AndroidDriver<AndroidElement>(
						new URL(FrameworkConstants.getMobileConfig().get("REMOTE_URL")), capability);
			} else if (FrameworkConstants.getMobileConfig().get(PLATFORM_OS).equalsIgnoreCase("ios")) {
				driver = new IOSDriver<IOSElement>(new URL(FrameworkConstants.getMobileConfig().get("REMOTE_URL")),
						capability);
			} else
				logger.info("Check mobile config PLATFORM_OS value");

		} catch (Exception e) {
			logger.error("Error in Seetest Local driver is initialization" + e.getMessage());

		}
		return driver;
	}

	/**
	 * This will return seetest Grid Driver
	 * 
	 * @param capability
	 * @author swapnil.mane
	 */

	private WebDriver getSeetestGridDriver(DesiredCapabilities capability) {
		String testName = FrameworkConstants.getMobileConfig().get("PLATFORM_TYPE") + " execution";
		capability.setCapability("testName", testName);
		capability.setCapability("accessKey", FrameworkConstants.getMobileConfig().get("ACCESS_KEY"));
		capability.setCapability("nativeWebScreenshot", true);
		try {
			if (FrameworkConstants.getMobileConfig().get(PLATFORM_OS).equalsIgnoreCase("android")) {
				driver = new AndroidDriver<AndroidElement>(
						new URL(FrameworkConstants.getMobileConfig().get("CLOUD_URL")), capability);
			} else if (FrameworkConstants.getMobileConfig().get(PLATFORM_OS).equalsIgnoreCase("ios")) {
				driver = new IOSDriver<IOSElement>(new URL(FrameworkConstants.getMobileConfig().get("CLOUD_URL")),
						capability);
			}

		} catch (Exception e) {
			logger.error("Error in Seetest grid driver is initialization" + e.getMessage());

		}
		return driver;
	}

}
