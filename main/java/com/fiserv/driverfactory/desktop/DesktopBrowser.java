package com.fiserv.driverfactory.desktop;


import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.fiserv.driverfactory.AbstractBrowser;
import com.fiserv.framework.constants.FrameworkConstants;

public class DesktopBrowser extends AbstractBrowser {

	private DesiredCapabilities capabilities;
	private AbstractRemoteSetup remote = new AbstractRemoteSetup();
	private static DesktopBrowser instance = null;

	private enum browsers {
		CHROME, FIREFOX, IE
	}

	protected DesktopBrowser() {
		getPluginConnection();
	}

	/**
	 * It returns the instance of the DesktopBrowser class
	 * 
	 * @return instance
	 */
	public static synchronized DesktopBrowser getInstance() {
		if (null == instance) {
			instance = new DesktopBrowser();
		}
		return instance;
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

		switch (browsers.valueOf(FrameworkConstants.getDesktopConfig().get("BROWSER").toUpperCase())) {
		case IE:
			capabilities = getIECapabilities(DesiredCapabilities.internetExplorer());
			break;
		case CHROME:
			capabilities = getChromeCapabilities(DesiredCapabilities.chrome());
			break;
		case FIREFOX:
			capabilities = getFireFoxCapabilities(DesiredCapabilities.firefox());
			break;
		default:
			break;
		}

		return capabilities;
	}

	@Override
	public WebDriver getPluginConnection() {
		setBrowserCapabilities();
		driver = remote.getRemotePlugin(capabilities);
		return driver;
	}

	/**
	 * Set the System property for the IE driver instance
	 * 
	 * @param ieCapabilities
	 *            DesiredCapabilities instance
	 * @return ieCapabilities DesiredCapabilities instance set with the path for
	 *         the IE driver and other required capabilities
	 */
	private DesiredCapabilities getIECapabilities(DesiredCapabilities ieCapabilities) {
		System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+ FrameworkConstants.getDesktopConfig().get("IE_DRIVER"));
		ieCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		ieCapabilities.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
		ieCapabilities.setCapability("ignoreProtectedModeSettings", true);
		ieCapabilities.setCapability("requireWindowFocus", true);
		ieCapabilities.setBrowserName(DesiredCapabilities.internetExplorer().getBrowserName());

		ieCapabilities.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, false);

		ieCapabilities.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.DISMISS);
		// Accept unexpected alerts
		ieCapabilities.setCapability("requireWindowFocus", true);
		ieCapabilities.setCapability("enablePersistentHover", false);
		ieCapabilities.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
		ieCapabilities.setCapability(InternetExplorerDriver.NATIVE_EVENTS, false);
		ieCapabilities.setCapability(InternetExplorerDriver.IE_SWITCHES, "-private");
		ieCapabilities.setCapability("disable-popup-blocking", true);
		ieCapabilities.setJavascriptEnabled(true);

		return ieCapabilities;
	}

	/**
	 * Set the System property for the Chrome driver instance
	 * 
	 * @param chromeCapabilities
	 *            DesiredCapabilities instance
	 * @return chromeCapabilities DesiredCapabilities instance set with the path
	 *         for the Chrome driver and other required capabilities
	 */
	private DesiredCapabilities getChromeCapabilities(DesiredCapabilities chromeCapabilities) {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ FrameworkConstants.getDesktopConfig().get("CHROME_DRIVER"));
		chromeCapabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		chromeCapabilities.setCapability(CapabilityType.SUPPORTS_ALERTS, true);
		chromeCapabilities.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT);
		return chromeCapabilities;
	}

	/**
	 * Set the System property for the Firefox driver instance
	 * 
	 * @param fireFoxcapabilities
	 *            DesiredCapabilities instance
	 * @return fireFoxcapabilities DesiredCapabilities instance set with the
	 *         path for the Firefox driver and other required capabilities
	 */
	private DesiredCapabilities getFireFoxCapabilities(DesiredCapabilities fireFoxcapabilities) {
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+ FrameworkConstants.getDesktopConfig().get("FIREFOX_DRIVER"));
		return fireFoxcapabilities;

	}

}
