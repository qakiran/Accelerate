package com.fiserv.framework.constants;

/**
 * 
 * @author dhiraj.bendale
 *
 */
public class SetUpConstants {

	private SetUpConstants() {

	}

	private static int defaultTimeOut = 0;
	private static int pageLoadTimeOut = 0;
	private static boolean screenShot = false;
	private static String browser = "";
	static boolean browserPid = false;
	private static boolean htmlReport = false;

	public static String getBrowser() {
		return browser;
	}

	public static void setBrowser(String browsers) {
		browser = browsers;
	}

	public static int getDefaultTimeOut() {
		return defaultTimeOut;
	}

	public static void setDefaultTimeOut(int defaultTimeout) {
		defaultTimeOut = defaultTimeout;
	}

	public static int getPageLoadTimeOut() {
		return pageLoadTimeOut;
	}

	public static void setPageLoadTimeOut(int pageLoadTimeout) {
		pageLoadTimeOut = pageLoadTimeout;
	}

	public static boolean isScreenshot() {
		return screenShot;
	}

	public static void setScreenshot(boolean screenshot) {
		screenShot = screenshot;
	}

	public static boolean isHtmlReport() {
		return htmlReport;
	}

	public static void setHtmlReport(boolean htmlReports) {
		htmlReport = htmlReports;
	}

}
