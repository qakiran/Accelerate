package com.fiserv.driverfactory;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import com.fiserv.framework.constants.FrameworkConstants;
import com.fiserv.framework.constants.SetUpConstants;

/**
 * Abstract browser which extends by browser
 * 
 * @author dhiraj.bendale
 *
 */
public abstract class AbstractBrowser {
	protected WebDriver driver;
	private static Logger logger = Logger.getLogger(AbstractBrowser.class);

	public abstract DesiredCapabilities setBrowserCapabilities();

	public WebDriver setBrowserProperties() {
		driver.manage().timeouts().implicitlyWait(SetUpConstants.getDefaultTimeOut(), TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(SetUpConstants.getPageLoadTimeOut(), TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(SetUpConstants.getPageLoadTimeOut(), TimeUnit.SECONDS);
		if (FrameworkConstants.getGlobalConfig().get("EXECUTION_ON").equalsIgnoreCase("mobile")) {
			logger.info("DEVICE NAME : " + FrameworkConstants.getMobileConfig().get("DEVICE_NAME"));
			logger.info("EXECUTION MODE : " + FrameworkConstants.getMobileConfig().get("TARGET_MODE"));
			logger.info("DEFAULT TIMEOUT : " + SetUpConstants.getDefaultTimeOut());
			logger.info("PAGELOAD TIMEOUT : " + SetUpConstants.getPageLoadTimeOut());
			logger.info("SCREEN SHOT : " + SetUpConstants.isScreenshot());
			logger.info("HTML REPORT : " + SetUpConstants.isHtmlReport());
		} else {
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
		}
		return driver;

	}

	public abstract WebDriver getPluginConnection();
}