package com.fiserv.framework.utility.report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

/**
 * 
 * @author dhiraj.bendale
 *
 */
public class ExtentReportConstant {

	private ExtentTest parentTestNode;
	private ExtentReports extent;
	private static ExtentReportConstant instance = null;
	private ExtentTest testCase;
	private ExtentTest childNode;

	protected ExtentReportConstant() {

	}

	public static ExtentReportConstant getInstance() {
		if (null == instance) {
			instance = new ExtentReportConstant();
		}
		return instance;
	}

	public void setExtent(ExtentReports extent) {
		this.extent = extent;
	}

	public ExtentReports getExtent() {
		return extent;
	}

	public ExtentTest getTestCase() {
		return testCase;
	}

	public void setTestCase(String testName) {
		this.testCase = extent.createTest(testName);
	}

	public ExtentTest getParentTestNode() {
		return parentTestNode;
	}

	public void setParentTestNode(String parentNode) {
		this.parentTestNode = testCase.createNode(parentNode);

	}

	public ExtentTest getChildNode() {
		return childNode;
	}

	public void setChildNode(String childNode) {
		this.childNode = parentTestNode.createNode(childNode);
	}

}
