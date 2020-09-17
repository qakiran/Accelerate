package com.fiserv.driverfactory;

import org.openqa.selenium.WebDriver;
import com.fiserv.driverfactory.desktop.DesktopFactory;
import com.fiserv.driverfactory.mobile.MobileFactory;
import com.fiserv.framework.Initialize;
import com.fiserv.framework.constants.FrameworkConstants;

public class DriverFactory {

	private static DriverFactory instance = null;
	private WebDriver driver;
	private DesktopFactory desktop = new DesktopFactory();
	private MobileFactory mobile = new MobileFactory();

	protected DriverFactory() {
		Initialize.getInstance();
	}

	/**
	 * It returns the instance of the DriverFactory class
	 * 
	 * @return instance
	 */
	public static DriverFactory getInstance() {
		if (null == instance) {
			instance = new DriverFactory();
		}
		return instance;
	}

	/**
	 * Returns driver object on the basis of configuration
	 * 
	 * @author dhiraj.bendale
	 * @return
	 */
	public WebDriver getDriver() {
		switch (FrameworkConstants.getExecutionOn().toUpperCase()) {
		case "DESKTOP":
			driver = desktop.getDesktopInstance();
			break;
		case "MOBILE":
			driver = mobile.getMobileInstance();
			break;
		default:

			break;
		}
		return driver;
	}
}
