package com.fiserv.framework;

import com.fiserv.framework.constants.FrameworkConstants;
import com.fiserv.framework.constants.ReportConstants;
import com.fiserv.framework.constants.SetUpConstants;

public class ExecutionParameters {

	/**
	 * Setup constants parameter from Global config properties
	 * 
	 * @author dhiraj.bendale
	 * 
	 */
	public void setupGlobalConfigParamter() {
		FrameworkConstants.setExecutionOn(FrameworkConstants.getGlobalConfig().get("EXECUTION_ON"));
		FrameworkConstants.setTARGET(FrameworkConstants.getGlobalConfig().get("TARGET"));
		FrameworkConstants
				.sethtmlReport(getBooleanStatus(FrameworkConstants.getGlobalConfig().get("EXECUTION_REPORT")));
	}

	/**
//	 * Setup constants parameter from Desktop config properties
	 * 
	 * @author dhiraj.bendale
	 * 
	 */
	public void setupDesktopConfigParameter() {
		SetUpConstants.setBrowser(FrameworkConstants.getDesktopConfig().get("BROWSER"));
		SetUpConstants
				.setDefaultTimeOut(Integer.parseInt(FrameworkConstants.getDesktopConfig().get("DEFAULT_TIMEOUT")));
		SetUpConstants
				.setPageLoadTimeOut(Integer.parseInt(FrameworkConstants.getDesktopConfig().get("PAGELOAD_TIMEOUT")));
		FrameworkConstants.setAccessibilityTest(
				getBooleanStatus(FrameworkConstants.getDesktopConfig().get("ACCESSIBILITY_TEST")));
	}

	/**
	 * Setup constants parameter from Desktop config properties
	 * 
	 * @author dhiraj.bendale
	 * 
	 */
	public void setupMobileConfigParameter() {
		SetUpConstants.setBrowser(FrameworkConstants.getMobileConfig().get("BROWSER"));
		SetUpConstants.setDefaultTimeOut(Integer.parseInt(FrameworkConstants.getMobileConfig().get("DEFAULT_TIMEOUT")));
		SetUpConstants
				.setPageLoadTimeOut(Integer.parseInt(FrameworkConstants.getMobileConfig().get("PAGELOAD_TIMEOUT")));
	}

	/**
	 * Setup constants parameter from Report config properties
	 * ReportConstants.OUTPUT_FOLDER has assign value getOutPutFolder in
	 * SetupExcecutionOn class
	 * 
	 * @author dhiraj.bendale
	 * 
	 */
	public void setupReportConfigParameter() {
		ReportConstants.setHtmlReportTitle(FrameworkConstants.getReportConfig().get("HTML_REPORT_TILE"));
		ReportConstants.setScreenshot(getBooleanStatus(FrameworkConstants.getReportConfig().get("SCREEN_SHOT")));
	}

	/**
	 * convert string yes/no into boolean true/false
	 * 
	 * @param status
	 * @return
	 */

	private boolean getBooleanStatus(String status) {
		return status.equalsIgnoreCase("yes");
	}

}
