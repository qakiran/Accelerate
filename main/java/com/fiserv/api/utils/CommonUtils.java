package com.fiserv.api.utils;

import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.fiserv.framework.utility.report.ExtentReportConstant;

public class CommonUtils  {

	private static CommonUtils instance = null;
	private ExtentReportConstant reportConstant = ExtentReportConstant.getInstance();
	protected CommonUtils() {

	}

	/**
	 * This function checks for currents class instance and returns one if present.
	 * If not instance available creates new instance and returns that.
	 * 
	 * @author manoj.perla
	 * @return Instance of the class
	 */
	public static CommonUtils getInstance() {
		if (null == instance) {
			instance = new CommonUtils();
		}
		return instance;
	}

	public void failTestcase(String exceptionMsg, String failMsgDetails) {
		if ((reportConstant.getParentTestNode() == null)) {
			reportConstant.setParentTestNode("Failure Details");
			reportConstant.getParentTestNode().log(Status.FAIL, failMsgDetails);
			Assert.fail(exceptionMsg);
		} else {
			reportConstant.getParentTestNode().log(Status.FAIL, failMsgDetails);
			Assert.fail(exceptionMsg);
		}
	}

}
