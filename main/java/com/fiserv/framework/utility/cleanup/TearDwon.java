/**
 * 
 */
package com.fiserv.framework.utility.cleanup;

import org.openqa.selenium.WebDriver;

import com.fiserv.driverfactory.DriverFactory;
import com.fiserv.framework.utility.report.ExtentManager;

/**
 * @author Dhiraj.Bendale
 *
 */
public class TearDwon {
	private static ExtentManager extentManager = ExtentManager.getInstance();
	protected WebDriver driver = DriverFactory.getInstance().getDriver();

	public void tearDown() {
		extentManager.endReport();
		driver.quit();
	}
}
