package com.fiserv.driverfactory.desktop;

import org.openqa.selenium.WebDriver;

import com.fiserv.framework.constants.FrameworkConstants;

/**
 * DesktopFactory responsible for setup driver instance according configuration
 * Such app/browser .
 * 
 * @author dhiraj.bendale
 *
 */
public class DesktopFactory {

	private WebDriver driver;

	private enum platform {
		APP, BROWSER
	}

	public WebDriver getDesktopInstance() {
		switch (platform.valueOf(FrameworkConstants.getTarget().toUpperCase())) {
		case BROWSER:
			driver = DesktopBrowser.getInstance().getDriver();
			break;
		case APP:
			break;
		default:
			// Add info with fail
			break;
		}
		return driver;
	}
}
