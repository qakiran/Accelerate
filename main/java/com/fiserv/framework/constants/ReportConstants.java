package com.fiserv.framework.constants;

public class ReportConstants {
	private static String screenShotLocation = "";
	private static String outputFolders = "";
	private static boolean screenshot = false;
	private static String extentReportTitle = "";
	private static String violationLocation = "";

	private ReportConstants() {

	}

	public static String getScreenshotLocation() {
		return screenShotLocation;
	}

	public static void setScreenshotLocation(String screenshotLocation) {
		screenShotLocation = screenshotLocation;
	}

	public static String getOutputFolder() {
		return outputFolders;
	}

	public static void setOutputFolder(String outputFolder) {
		outputFolders = outputFolder;
	}

	public static String getViolationsLocation() {
		return violationLocation;
	}

	public static void setViolationsLocation(String violationsLocation) {
		violationLocation = violationsLocation;
	}

	public static boolean isScreenShot() {
		return screenshot;
	}

	public static void setScreenshot(boolean screenShot) {
		screenshot = screenShot;
	}

	public static String getHtmlReportTitle() {
		return extentReportTitle;
	}

	public static void setHtmlReportTitle(String htmlReportTitle) {
		extentReportTitle = htmlReportTitle;
	}

}
