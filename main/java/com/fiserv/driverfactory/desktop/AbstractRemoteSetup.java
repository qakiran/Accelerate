package com.fiserv.driverfactory.desktop;

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import com.fiserv.driverfactory.RemoteSetup;
import com.fiserv.framework.constants.FrameworkConstants;
import com.fiserv.remotetools.Appium;
import com.fiserv.remotetools.SeeTest;

public class AbstractRemoteSetup extends RemoteSetup {

	private static Logger logger = Logger.getLogger(AbstractRemoteSetup.class);
	private WebDriver driver;
	private Appium appium = new Appium();
	private SeeTest seetest = new SeeTest();

	private enum browsers {
		IE, CHROME, FIREFOX
	}

	/**
	 * Return Webdriver on basis on execution target e.g on local /selenium grid
	 * / appium
	 * 
	 * @author dhiraj.bendale
	 */
	@Override
	protected WebDriver setRemotePlugIn(DesiredCapabilities capabilities) {
		try {
			if (FrameworkConstants.getGlobalConfig().get("EXECUTION_ON").equalsIgnoreCase("Desktop")) {
				if (FrameworkConstants.getDesktopConfig().get("TARGET_MODE").toUpperCase().equals("LOCAL")) {
					driver = getLocalDriver(capabilities);
				} else if (FrameworkConstants.getDesktopConfig().get("TARGET_MODE").toUpperCase()
						.equals("SELENIUMGRID")) {
					driver = new RemoteWebDriver(new URL(FrameworkConstants.getRemoteConfig().get("REMOTE_URL")),
							capabilities);
				}
			} else if (FrameworkConstants.getGlobalConfig().get("EXECUTION_ON").equalsIgnoreCase("mobile")) {
				if (FrameworkConstants.getMobileConfig().get("TARGET_MODE").toUpperCase().equals("APPIUM")) {
					driver = appium.getAppiumDriver(capabilities);
				} else if (FrameworkConstants.getMobileConfig().get("TARGET_MODE").toUpperCase().equals("SEETEST")) {
					driver = seetest.getSeetestDriver(capabilities);
				}
			}
		} catch (MalformedURLException e) {
			logger.error("Exception.. " + e.getMessage());
		}
		return driver;

	}

	@Override
	public WebDriver getRemotePlugin(DesiredCapabilities capabilities) {
		driver = setRemotePlugIn(capabilities);
		return driver;

	}

	@SuppressWarnings("deprecation")
	private WebDriver getLocalDriver(DesiredCapabilities capabilities) {
		switch (browsers.valueOf(FrameworkConstants.getDesktopConfig().get("BROWSER").toUpperCase())) {
		case IE:
			driver = new InternetExplorerDriver(capabilities);
			break;
		case CHROME:
			driver = new ChromeDriver(capabilities);
			break;
		case FIREFOX:
			driver = new FirefoxDriver(capabilities);
			break;
		default:
			logger.info("Select appropriate browser to execute");
			break;
		}
		return driver;
	}

}
