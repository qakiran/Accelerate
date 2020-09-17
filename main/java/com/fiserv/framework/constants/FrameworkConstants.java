package com.fiserv.framework.constants;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author dhiraj.bendale
 *
 */
public class FrameworkConstants {

	private FrameworkConstants() {

	}

	public static final String CONFIGFILE = "configuration" + File.separator + "configuration.properties";
	private static Map<String, String> globalConfigMap = new HashMap<>();
	private static Map<String, String> desktopConfigMap = new HashMap<>();
	private static Map<String, String> mobileConfigMap = new HashMap<>();
	private static Map<String, String> apiConfigMap = new HashMap<>();
	private static Map<String, String> reportConfigMap = new HashMap<>();
	private static Map<String, String> keywordConfigMap = new HashMap<>();
	private static Map<String, String> remoteConfigMap = new HashMap<>();
	private static Map<String, String> accessConfigMap = new HashMap<>();
	public static final String EXECUTOR_NAME = System.getProperty("user.name");
	private static String targets = "";
	private static Integer stepsCounter = 0;
	private static String executionsOn = "";
	private static boolean htmlReports = false;
	private static boolean accessTest = false;

	public static Map<String, String> getGlobalConfig() {
		return globalConfigMap;
	}

	public static void setglobalConfig(Map<String, String> globalConfig) {
		globalConfigMap = globalConfig;
	}

	public static boolean isHtmlReport() {
		return htmlReports;
	}

	public static void sethtmlReport(boolean htmlReport) {
		htmlReports = htmlReport;
	}

	public static Integer getStepCounter() {
		return stepsCounter;
	}

	public static void setStepCounter(Integer stepCounter) {
		stepsCounter = stepCounter;
	}

	public static String getExecutionOn() {
		return executionsOn;
	}

	public static void setExecutionOn(String executionOn) {
		executionsOn = executionOn;
	}

	public static String getTarget() {
		return targets;
	}

	public static void setTARGET(String target) {
		targets = target;
	}

	public static Map<String, String> getDesktopConfig() {
		return desktopConfigMap;
	}

	public static void setDesktopConfig(Map<String, String> desktopConfig) {
		desktopConfigMap = desktopConfig;
	}

	public static boolean isAccessibilityTest() {
		return accessTest;
	}

	public static void setAccessibilityTest(boolean accessibilityTest) {
		accessTest = accessibilityTest;
	}

	public static Map<String, String> getMobileConfig() {
		return mobileConfigMap;
	}

	public static void setMobileConfig(Map<String, String> mobileConfig) {
		mobileConfigMap = mobileConfig;
	}

	public static Map<String, String> getReportConfig() {
		return reportConfigMap;
	}

	public static void setReportConfig(Map<String, String> reportConfig) {
		reportConfigMap = reportConfig;
	}

	public static Map<String, String> getKeywordConfig() {
		return keywordConfigMap;
	}

	public static void setKeywordConfig(Map<String, String> keywordConfig) {
		keywordConfigMap = keywordConfig;
	}

	public static Map<String, String> getAccessConfig() {
		return accessConfigMap;
	}

	public static void setAccessConfig(Map<String, String> accessConfig) {
		accessConfigMap = accessConfig;
	}

	public static Map<String, String> getApiConfig() {
		return apiConfigMap;
	}

	public static void setApiConfig(Map<String, String> apiConfig) {
		apiConfigMap = apiConfig;
	}

	public static Map<String, String> getRemoteConfig() {
		return remoteConfigMap;
	}

	public static void setRemoteConfig(Map<String, String> remoteConfig) {
		remoteConfigMap = remoteConfig;
	}

}