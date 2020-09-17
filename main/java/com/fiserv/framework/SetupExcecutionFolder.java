package com.fiserv.framework;

import java.io.File;

import com.fiserv.accessibility.framework.ExcelUtility;
import com.fiserv.framework.constants.FrameworkConstants;
import com.fiserv.framework.constants.ReportConstants;
import com.fiserv.framework.utility.DateTime;
import com.fiserv.framework.utility.files.PropertiesFiles;

public class SetupExcecutionFolder {

	private PropertiesFiles prop = new PropertiesFiles();
	private String folderPath = "";
	private ExecutionParameters executionParam = new ExecutionParameters();
	private ExcelUtility excelUtility = new ExcelUtility();
	private static final String EXECUTION = "Execution";
	private static final String DATE_FORMAT = "ddMMyyyyhhmmss";

	public void folderStructure() {
		FrameworkConstants
				.setApiConfig(prop.readProperties(FrameworkConstants.getGlobalConfig().get("API.PROPERTIES")));
		killBrowserProcesses();
		if (FrameworkConstants.getGlobalConfig().get("KEYWORD_EXECUTION").equalsIgnoreCase("YES"))
			FrameworkConstants.setKeywordConfig(
					prop.readProperties(FrameworkConstants.getGlobalConfig().get("KEYWORDS.PROPERTIES")));
		FrameworkConstants
				.setReportConfig(prop.readProperties(FrameworkConstants.getGlobalConfig().get("REPORT.PROPERTIES")));
		if (FrameworkConstants.getExecutionOn().equalsIgnoreCase("desktop")) {
			desktopResultFolder();
		} else if (FrameworkConstants.getExecutionOn().equalsIgnoreCase("api")) {
			apiResultFolder();
		} else {
			mobileResultFolder();
		}
		File directory = new File(ReportConstants.getOutputFolder());
		directory.mkdirs();
		if (FrameworkConstants.getExecutionOn().equalsIgnoreCase("desktop")
				|| FrameworkConstants.getExecutionOn().equalsIgnoreCase("mobile")) {
			executionParam.setupReportConfigParameter();
			screenShotFolder();
			violationFolder();
		}
	}

	// need check report on then create
	private void screenShotFolder() {
		ReportConstants.setScreenshotLocation(
				ReportConstants.getOutputFolder() + File.separator + "screenShots" + File.separator);
		File directory = new File(ReportConstants.getScreenshotLocation());
		directory.mkdirs();
	}

	/**
	 * Creating violation folder to store accessibility text report
	 * 
	 * @author Vimal.Tyagi
	 * @return
	 */
	private void violationFolder() {
		if (FrameworkConstants.isAccessibilityTest()) {
			FrameworkConstants.setAccessConfig(
					prop.readProperties(FrameworkConstants.getGlobalConfig().get("ACCESSIBILITY.PROPERTIES")));
			ReportConstants.setViolationsLocation(
					ReportConstants.getOutputFolder() + File.separator + "violations" + File.separator);
			File directory = new File(ReportConstants.getViolationsLocation());
			directory.mkdirs();
			excelUtility.createWorkBook();
		}
	}

	private void desktopResultFolder() {
		FrameworkConstants
				.setDesktopConfig(prop.readProperties(FrameworkConstants.getGlobalConfig().get("DESKTOP.PROPERTIES")));
		folderPath = EXECUTION + File.separator + "Build_Desktop_BROWSER_" + DateTime.getCurrentTime(DATE_FORMAT) + "_"
				+ FrameworkConstants.getDesktopConfig().get("BROWSER").toUpperCase() + File.separator;
		getOutPutFolder(folderPath);
		executionParam.setupDesktopConfigParameter();
	}

	private void mobileResultFolder() {
		FrameworkConstants
				.setMobileConfig(prop.readProperties(FrameworkConstants.getGlobalConfig().get("MOBILE.PROPERTIES")));
		if (FrameworkConstants.getTarget().equalsIgnoreCase("browser")) {
			folderPath = EXECUTION + File.separator + "Build_Mobile_BROWSER_" + DateTime.getCurrentTime(DATE_FORMAT)
					+ "_" + FrameworkConstants.getMobileConfig().get("PLATFORM_OS").toUpperCase() + "_"
					+ FrameworkConstants.getMobileConfig().get("BROWSER").toUpperCase() + File.separator;
		} else {
			folderPath = EXECUTION + File.separator + "Build_Mobile_NATIVEAPP_" + DateTime.getCurrentTime(DATE_FORMAT)
					+ "_" + FrameworkConstants.getMobileConfig().get("PLATFORM_OS").toUpperCase() + File.separator;
		}
		getOutPutFolder(folderPath);
		executionParam.setupMobileConfigParameter();

	}

	private void apiResultFolder() {
		folderPath = EXECUTION + File.separator + "Build_API_" + DateTime.getCurrentTime(DATE_FORMAT) + File.separator;
		getOutPutFolder(folderPath);

	}

	private void getOutPutFolder(String folderPath) {
		if (FrameworkConstants.getReportConfig().get("OUTPUT_FOLDER").equalsIgnoreCase("projectPath")) {
			ReportConstants.setOutputFolder(System.getProperty("user.dir") + File.separator);
		} else {
			ReportConstants.setOutputFolder(
					FrameworkConstants.getReportConfig().get("OUTPUT_FOLDER") + File.separator + folderPath);
		}
	}

	/***
	 * Kill all the existing processes of browser and winium drivers
	 * 
	 * @author shivang.ahuja
	 */
	private void killBrowserProcesses() {
		ProcessBuilder processBuilder;
		try {
			processBuilder = new ProcessBuilder(
					System.getProperty("user.dir") + "/src/test/resources/lib/browserProcessKill.bat");
			processBuilder.start();
		} catch (Exception e) {
			e.getStackTrace();
		}
	}
}
