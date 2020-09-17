package com.fiserv.driverfactory.mobile;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import com.fiserv.driverfactory.AbstractBrowser;
import com.fiserv.driverfactory.desktop.AbstractRemoteSetup;
import com.fiserv.framework.constants.FrameworkConstants;
import com.fiserv.framework.constants.SetUpConstants;

import io.appium.java_client.remote.MobileBrowserType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.apache.log4j.Logger;

public class MobileBrowser extends AbstractBrowser {

	private static MobileBrowser instance = null;
	private DesiredCapabilities capabilities = new DesiredCapabilities();
	private AbstractRemoteSetup remote = new AbstractRemoteSetup();
	private static Logger logger = Logger.getLogger(MobileBrowser.class);

	protected MobileBrowser() {
		getPluginConnection();
	}

	/**
	 * It returns the instance of the BrowserDropdown class
	 * 
	 * @return instance
	 */
	public static synchronized MobileBrowser getInstance() {
		if (null == instance) {
			instance = new MobileBrowser();
		}
		return instance;
	}

	private enum modules {
		CHROME, SAFARI, OPERA
	}

	/**
	 * It returns the instance of the WebDriver
	 * 
	 * @return driver This is the instance of WebDriver
	 */
	public WebDriver getDriver() {
		return driver;
	}

	@Override
	public DesiredCapabilities setBrowserCapabilities() {
		switch (modules.valueOf(FrameworkConstants.getMobileConfig().get("BROWSER").toUpperCase())) {
		case CHROME:
			capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,
					FrameworkConstants.getMobileConfig().get("PLATFORM_TYPE"));
			capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,
					FrameworkConstants.getMobileConfig().get("DEVICE_NAME"));
			if (FrameworkConstants.getGlobalConfig().get("EXECUTION_MODE").equalsIgnoreCase("seetest"))
				capabilities.setBrowserName(MobileBrowserType.CHROMIUM);
			else {
				ChromeOptions options = new ChromeOptions();
				options.setExperimentalOption("androidPackage", "com.android.chrome");
				capabilities.setCapability(ChromeOptions.CAPABILITY, options);
			}
			break;
		case SAFARI:
			capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,
					FrameworkConstants.getMobileConfig().get("PLATFORM_TYPE").toUpperCase());
			capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,
					FrameworkConstants.getMobileConfig().get("DEVICE_NAME"));
			capabilities.setBrowserName(MobileBrowserType.SAFARI);
			break;
		case OPERA:
			break;
		}
		logger.info(SetUpConstants.getBrowser() + "browser capabilities are set");
		return capabilities;
	}

	@Override
	public WebDriver getPluginConnection() {
		setBrowserCapabilities();
		driver = remote.getRemotePlugin(capabilities);
		return driver;
	}

	

}
