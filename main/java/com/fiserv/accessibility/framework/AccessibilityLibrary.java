package com.fiserv.accessibility.framework;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.aventstack.extentreports.Status;
import com.fiserv.driverfactory.DriverFactory;
import com.fiserv.framework.Report;
import com.fiserv.framework.constants.FrameworkConstants;
import com.fiserv.framework.utility.excel.UpdateExcel;
import com.fiserv.framework.utility.report.ExtentReportConstant;

public class AccessibilityLibrary {
	protected WebDriver driver = DriverFactory.getInstance().getDriver();
	URL urla = null;
	private static Logger logger = Logger.getLogger(AccessibilityLibrary.class);
	private static AccessibilityLibrary instance = null;
	private ExtentReportConstant reportConstant = ExtentReportConstant.getInstance();
	private Report report = Report.getInstance();
	private AccessibilityUtils accessibilityUtils = new AccessibilityUtils();
	UpdateExcel updateExcel = new UpdateExcel();
	String violations;

	/**
	 * This method returns the instance of AccessibilityLibrary
	 * 
	 * @return instance
	 * @author Vimal.Tyagi
	 */
	public static AccessibilityLibrary getInstance() {
		if (null == instance) {
			instance = new AccessibilityLibrary();
		}
		return instance;
	}

	/**
	 * This method invokes the the accessibility test to the Page level and
	 * gives violations if any
	 * 
	 * @author vimal.tyagi
	 */
	public void pageLevelAccessibilityTest() {
		if (FrameworkConstants.isAccessibilityTest()
				? FrameworkConstants.getAccessConfig().get("ACCESSIBILITY_PAGE_TEST").equalsIgnoreCase("yes")
				: false) {
			getWCAGVersion();
			logger.debug("The accessbility test is enabled.");
			JSONObject obj = new Builder(driver, urla).analyze();
			JSONArray violationsArr = obj.getJSONArray("violations");
			reportConstant.setParentTestNode("Page level Accessibility test logs for : " + driver.getTitle());
			if (violationsArr.length() == 0) {
				logger.info("The Accessibility violations were not found on the page.");
				reportConstant.getParentTestNode().createNode("No accessibility violation found.").log(Status.PASS,
						driver.getTitle() + " doesnt have accessibilitypage violations.");
			} else {
				logger.info("The page level accessibility violations have been found and captured in the report.");
				accessibilityUtils.excelReport(violationsArr);
				violations = accessibilityUtils.htmlReport(violationsArr);
				List<String> violationList = new ArrayList<>(
						Arrays.asList(violations.trim().split("<--JSTORM REPORT-->")));
				for (int count = 1; count < violationList.size(); count++) {
					reportConstant.getParentTestNode();
					reportConstant.setChildNode("Violation " + count);
					reportConstant.getChildNode().log(Status.FAIL, count + ") "
							+ violationList.get(count).substring(0, violationList.get(count).length() - 2));
				}
			}
		}
	}

	/**
	 * This method invokes the the accessibility test to the element level and
	 * gives violations, if any
	 * 
	 * @param webelement
	 * @author shivang.ahuja
	 */
	public void elementLevelAccessibilityTest(WebElement element) {
		if (FrameworkConstants.isAccessibilityTest()
				? FrameworkConstants.getAccessConfig().get("ACCESSIBILITY_ELEMENT_TEST").equalsIgnoreCase("yes")
				: false) {
			getWCAGVersion();
			logger.debug("The accessbility test is enabled.");
			JSONObject obj = new Builder(driver, urla).analyze(element);
			JSONArray arr = obj.getJSONArray("violations");
			reportConstant.setParentTestNode("Element level accessibility test " + element);
			if (arr.length() == 0) {
				logger.info("The Accessibility violations were not found for passsed webElement.");
				reportConstant.getParentTestNode().createNode("element level violations").log(Status.PASS,
						"No accessibility violation found for element.");
			} else {
				logger.info("The Accessibility violations have been found and captured in report for webelement.");
				violations = accessibilityUtils.htmlReport(arr);
				List<String> violationList = new ArrayList<>(
						Arrays.asList(violations.trim().split(accessibilityUtils.jstromAppend)));
				for (int count = 1; count < violationList.size(); count++) {
					reportConstant.getParentTestNode();
					reportConstant.setChildNode("Element violations: " + count);
					reportConstant.getChildNode().log(Status.FAIL, count + ") "
							+ violationList.get(count).substring(0, violationList.get(count).length() - 2));
				}
				report.log("Accessibility violations have been found", "", element, Status.FAIL);
			}
		}
	}

	/**
	 * Return the wcag version
	 * 
	 * @author Vimal.Tyagi
	 */
	public void getWCAGVersion() {
		String version = FrameworkConstants.getAccessConfig().get("ACCESSIBILITY_VERSION");
		switch (version) {
		case "2.0":
			urla = AccessibilityLibrary.class.getResource("/wcagrules/WCAG2.0.js");
			break;
		case "2.1":
			urla = AccessibilityLibrary.class.getResource("/wcagrules/WCAG2.1.js");
			break;
		default:
			urla = AccessibilityLibrary.class.getResource("/wcagrules/WCAG2.0.js");
		}
		logger.info("Accessibility test will run on WGAC" + version);
	}
}
