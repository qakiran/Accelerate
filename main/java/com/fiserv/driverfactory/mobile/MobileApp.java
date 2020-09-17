package com.fiserv.driverfactory.mobile;

import java.awt.PageAttributes.OrientationRequestedType;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.fiserv.driverfactory.AbstractApp;
import com.fiserv.driverfactory.desktop.AbstractRemoteSetup;
import com.fiserv.framework.constants.FrameworkConstants;
import com.fiserv.framework.constants.SetUpConstants;

import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

/**
 * @author Mohammad.Nazim
 */
public class MobileApp implements AbstractApp {

	private WebDriver driver;
	private static MobileApp instance = null;
	private DesiredCapabilities capabilities = new DesiredCapabilities();
	private AbstractRemoteSetup remote = new AbstractRemoteSetup();
	private static Logger logger = Logger.getLogger(MobileBrowser.class);
	private static final String PHONE_NAME = "DEVICE_NAME";

	protected MobileApp() {
		getPluginConnection();
	}

	/**
	 * It returns the instance of the MobileApp class
	 * 
	 * @author Mohammad.Nazim
	 * @return instance
	 */
	public static synchronized MobileApp getInstance() {
		if (null == instance) {
			instance = new MobileApp();
		}
		return instance;
	}

	/**
	 * It returns the desired capabilities for android and iOS
	 * 
	 * @author Mohammad.Nazim
	 * @return capabilities
	 */
	@Override
	public DesiredCapabilities setAppDesiredCapabilities() {
		final String PLATFORM_TYPE = "PLATFORM_TYPE";
		if (FrameworkConstants.getMobileConfig().get("TARGET_MODE").equalsIgnoreCase("LOCAL")) {
			if (FrameworkConstants.getMobileConfig().get(PLATFORM_TYPE).equalsIgnoreCase("Android")) {
				capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,
						FrameworkConstants.getMobileConfig().get(PLATFORM_TYPE));
				capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,
						FrameworkConstants.getMobileConfig().get(PHONE_NAME));
				capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,
						FrameworkConstants.getMobileConfig().get("APP_PACKAGE"));
				capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,
						FrameworkConstants.getMobileConfig().get("APP_ACTIVITY"));
			} else {
				capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,
						FrameworkConstants.getMobileConfig().get(PLATFORM_TYPE));
				capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,
						FrameworkConstants.getMobileConfig().get(PHONE_NAME));
				capabilities.setCapability(MobileCapabilityType.ORIENTATION, OrientationRequestedType.PORTRAIT);
				capabilities.setCapability(IOSMobileCapabilityType.BUNDLE_ID,
						FrameworkConstants.getMobileConfig().get("BUNDLE_ID"));
			}
		} else if (FrameworkConstants.getMobileConfig().get("TARGET_MODE").equalsIgnoreCase("GRID")) {
			if (FrameworkConstants.getMobileConfig().get("PLATFORM_OS").equalsIgnoreCase("Android")) {
				String queryForCloud = "@os='" + FrameworkConstants.getMobileConfig().get(PLATFORM_TYPE)
						+ "' and @name='" + FrameworkConstants.getMobileConfig().get(PHONE_NAME) + "'";
				capabilities.setCapability("deviceQuery", queryForCloud);
				capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,
						FrameworkConstants.getMobileConfig().get("APP_PACKAGE"));
				capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,
						FrameworkConstants.getMobileConfig().get("APP_ACTIVITY"));

			} else if (FrameworkConstants.getMobileConfig().get("PLATFORM_OS").equalsIgnoreCase("ios")) {

				String queryForCloud = "@os='ios' and @category='PHONE' and @name='"
						+ FrameworkConstants.getMobileConfig().get(PHONE_NAME) + "'";
				capabilities.setCapability("deviceQuery", queryForCloud);
				capabilities.setCapability(MobileCapabilityType.ORIENTATION, OrientationRequestedType.PORTRAIT);
				capabilities.setCapability(IOSMobileCapabilityType.BUNDLE_ID,
						FrameworkConstants.getMobileConfig().get("BUNDLE_ID"));
				capabilities.setCapability("unicodeKeyboard", true);
				capabilities.setCapability("resetKeyboard", true);
			} else {
				logger.info("Check config values.");
			}
		}
		logger.info(FrameworkConstants.getMobileConfig().get(PLATFORM_TYPE) + " app capabilities are set");
		return capabilities;
	}

	/**
	 * It set the properties for mobile
	 * 
	 * @author Mohammad.Nazim
	 * @return capabilities
	 */
	@Override
	public WebDriver setAppProperties() {
		logger.info("DEVICE NAME : " + FrameworkConstants.getMobileConfig().get(PHONE_NAME));
		logger.info("EXECUTION MODE : " + FrameworkConstants.getMobileConfig().get("EXECUTION_MODE"));
		logger.info("DEFAULT TIMEOUT : " + SetUpConstants.getDefaultTimeOut());
		logger.info("PAGELOAD TIMEOUT : " + SetUpConstants.getPageLoadTimeOut());
		logger.info("SCREEN SHOT : " + SetUpConstants.isScreenshot());
		logger.info("HTML REPORT : " + SetUpConstants.isHtmlReport());
		driver.manage().timeouts().implicitlyWait(SetUpConstants.getDefaultTimeOut(), TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(SetUpConstants.getPageLoadTimeOut(), TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(SetUpConstants.getPageLoadTimeOut(), TimeUnit.SECONDS);
		return driver;
	}

	@Override
	public WebDriver getPluginConnection() {
		setAppDesiredCapabilities();
		driver = remote.getRemotePlugin(capabilities);
		return driver;
	}

	/**
	 * It returns the instance of the WebDriver
	 * 
	 * @return driver This is the instance of WebDriver
	 */
	public WebDriver getDriver() {
		return driver;
	}
}
