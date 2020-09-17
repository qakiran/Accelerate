package com.fiserv.driverfactory.mobile;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import com.fiserv.framework.constants.FrameworkConstants;

public class MobileFactory {

	private WebDriver driver;
	private static Logger logger = Logger.getLogger(MobileFactory.class);

	private enum platform {
		APP, BROWSER
	}

	/**
	 * MobileFactory responsible for setup mobile driver instance according
	 * configuration Such app/browser .
	 * 
	 * @author swapnil.mane
	 */
	public WebDriver getMobileInstance() {
		switch (platform.valueOf(FrameworkConstants.getTarget().toUpperCase())) {
		case APP:
			driver = MobileApp.getInstance().getDriver();
			break;

		case BROWSER:
			driver = MobileBrowser.getInstance().getDriver();
			break;

		default:
			logger.info("Select appropriate platform");
			break;
		}
		return driver;
	}
}
