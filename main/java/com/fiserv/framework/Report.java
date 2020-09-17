/**
 * 
 */
package com.fiserv.framework;

import java.io.File;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.aventstack.extentreports.Status;
import com.fiserv.driverfactory.DriverFactory;
import com.fiserv.framework.constants.FrameworkConstants;
import com.fiserv.framework.constants.ReportConstants;
import com.fiserv.framework.interfaces.IReport;
import com.fiserv.framework.utility.report.ExtentReportConstant;
import com.fiserv.selenium.ScreenShot;

/**
 * @author Dhiraj.Bendale
 *
 */
public class Report implements IReport {

	private static Report instance = null;
	private ExtentReportConstant reportConstant = ExtentReportConstant.getInstance();
	private static Logger logger = Logger.getLogger(Report.class);
	private ScreenShot screenShot = new ScreenShot();
	private String appendScreenshot = "";
	private WebDriver driver = DriverFactory.getInstance().getDriver();
	private static String style = "<span style='font-weight:bold;'>";
	private static String span = "</span>";

	protected Report() {
		
	}

	public static Report getInstance() {
		if (null == instance) {
			instance = new Report();
		}
		return instance;
	}

	/**
	 * @author Vimal.Tyagi
	 * @param message
	 * @param value
	 */
	public void log(String message, String value, WebElement element, Status status) {
		String screenShotPath = "";
		FrameworkConstants.setStepCounter(FrameworkConstants.getStepCounter() + 1);
		logger.info("Step : " + FrameworkConstants.getStepCounter() + " : " + message + " Paramter : " + value);
		if (ReportConstants.isScreenShot()) {
			screenShotPath = screenShot.takeSnapShot(driver, element);
			appendScreenshot = "<td nowrap>" + "<a href=\"" + ReportConstants.getScreenshotLocation() + File.separator
					+ "ElementScreenShot" + File.separator + screenShotPath + "\"> ScreenShot</a></td>";
			if (FrameworkConstants.isHtmlReport()) {
				setNodeStatus(status, message, value);
			}
		} else {
			if (FrameworkConstants.isHtmlReport()) {
				setNodeStatus(status, message, value);
			}
		}
	}

	/**
	 * @author dhiraj.bendale
	 * @param message
	 * @param value
	 */
	public void log(String message, String value, Status status) {
		String screenShotPath = "";
		FrameworkConstants.setStepCounter(FrameworkConstants.getStepCounter() + 1);
		logger.info("Step : " + FrameworkConstants.getStepCounter() + " : " + message + " Paramter : " + value);
		if (ReportConstants.isScreenShot()) {
			screenShotPath = screenShot.takeSnapShot(driver);
			appendScreenshot = "<td nowrap>" + "<a href=\"" + ReportConstants.getScreenshotLocation() + File.separator
					+ screenShotPath + "\">   Screenshot</a></td>";
			if (FrameworkConstants.isHtmlReport()) {
				setStepStatus(status, message, value);
			}
		} else {
			if (FrameworkConstants.isHtmlReport()) {
				setStepStatus(status, message, value);
			}
		}

	}

	private void setStepStatus(Status status, String message, String value) {
		if (FrameworkConstants.getGlobalConfig().get("KEYWORD_EXECUTION").equalsIgnoreCase("yes")) {
			reportConstant.getParentTestNode().log(status, message + " " + style + value + appendScreenshot);
		} else {
			reportConstant.getTestCase().log(status, message + " " + style + value + span + appendScreenshot);
		}
	}

	/**
	 * Sets the status of the node with screenshot attached
	 * 
	 * @author Shivang.Ahuja
	 * @param status
	 * @param message
	 * @param value
	 */
	private void setNodeStatus(Status status, String message, String value) {
		reportConstant.getChildNode().log(status, message + " " + style + value + span + appendScreenshot);
	}
}
