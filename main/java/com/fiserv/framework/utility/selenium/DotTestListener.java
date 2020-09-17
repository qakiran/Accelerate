package com.fiserv.framework.utility.selenium;

import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.Status;
import com.fiserv.framework.Initialize;
import com.fiserv.framework.Report;
import com.fiserv.framework.constants.FrameworkConstants;
import com.fiserv.framework.utility.report.ExtentReportConstant;

/**
 * 
 * @author Dhiraj.Bendale
 *
 */

public class DotTestListener implements ITestListener {

	Initialize init = Initialize.getInstance();
	private static Logger logger = Logger.getLogger(DotTestListener.class);
	private Report report = Report.getInstance();
	private ExtentReportConstant reportConstant = ExtentReportConstant.getInstance();
	String description = "";

	public void onTestFailure(ITestResult arg0) {
		logger.error(arg0.getThrowable().getMessage());
		if (arg0.getThrowable().getMessage() != "null") {
			report.log(arg0.getThrowable().getMessage(), "", Status.FAIL);
		} else {
			report.log("Test case is Fail", "", Status.FAIL);
		}
	}

	public void onTestSkipped(ITestResult arg0) {
		report.log("Test case is skipped.", "", Status.SKIP);

	}

	public void onTestStart(ITestResult arg0) {
		if (FrameworkConstants.isHtmlReport()) {
			getTestDescrption(arg0);
			reportConstant.setTestCase(description);
			reportConstant.getTestCase().assignCategory(getGroupName(arg0));
		}
		logger.info("Test case start execution " + description);
		logger.info("Test Case Category is " + getGroupName(arg0));
	}

	public void onTestSuccess(ITestResult arg0) {
		report.log("Test case is Pass.", "", Status.PASS);

	}

	private String[] getGroupName(ITestResult arg0) {
		try {
			return arg0.getMethod().getGroups();
		} catch (Exception e) {
			return new String[] { "Un-Categories" };
		}

	}

	private String getTestDescrption(ITestResult arg0) {

		try {
			description = arg0.getMethod().getDescription().trim();
			logger.info(arg0.getMethod().getDescription() + " test case started.");
		} catch (Exception e) {
			logger.warn(arg0.getMethod().getDescription() + " test case started.");
			description = "Description not present. MethodName" + arg0.getName();
		}
		return description;
	}

	@Override
	public void onStart(ITestContext context) {
		// Auto-generated method stub

	}

	@Override
	public void onFinish(ITestContext context) {
		// Auto-generated method stub

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// Auto-generated method stub

	}

}
