package com.fiserv.framework.constants;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KeywordConstants {

	private static Map<String, List<String>> testCaseParseData = new HashMap<>();
	private static Map<String, Map<Integer, List<String>>> keywordInput = new HashMap<>();
	private static Map<Integer, String> testCases = new HashMap<>();
	private static Map<String, Map<Integer, String>> testCaseKeyword = new HashMap<>();
	private static Map<String, Map<String, String>> testSet = new HashMap<>();
	private static Map<String, Map<String, String>> testDataSet = new HashMap<>();
	private static Map<String, String> keyWordData = new HashMap<>();

	public static Map<String, String> getKeyWordData() {
		return keyWordData;
	}

	public static void setKeyWordData(Map<String, String> keyWordData) {
		KeywordConstants.keyWordData = new HashMap<>();
		KeywordConstants.keyWordData = keyWordData;
	}

	public static Map<String, Map<String, String>> getTestDataSet() {
		return testDataSet;
	}

	public static void setTestDataSet(String row, Map<String, String> hashMap) {
		KeywordConstants.testDataSet.put(row, hashMap);
	}

	public static void initSetTestDataSet() {
		KeywordConstants.testDataSet = new HashMap<>();
	}

	public static Map<String, Map<String, String>> getTestSet() {
		return testSet;
	}

	public static void setTestSet(String row, Map<String, String> hashMap) {
		KeywordConstants.testSet.put(row, hashMap);
	}

	public Map<String, Map<Integer, List<String>>> getKeywordInput() {
		return keywordInput;
	}

	public static void setKeywordInput(Map<String, Map<Integer, List<String>>> keywordInput) {
		KeywordConstants.keywordInput = keywordInput;
	}

	public Map<Integer, String> getTestCases() {
		return testCases;
	}

	public static void setTestCases(Map<Integer, String> testCases) {
		KeywordConstants.testCases = testCases;
	}

	public Map<String, Map<Integer, String>> getTestCaseKeyword() {
		return testCaseKeyword;
	}

	public static void setTestCaseKeyword(Map<String, Map<Integer, String>> testCaseKeyword) {
		KeywordConstants.testCaseKeyword = testCaseKeyword;
	}

	public static void setTestCaseParseData(Map<String, List<String>> testCaseParseData) {
		KeywordConstants.testCaseParseData = testCaseParseData;
	}

	public Map<String, List<String>> getTestCaseParseData() {
		return testCaseParseData;
	}

	public void updateTestCaseParseData(String key, List<String> testCaseClaasParseData) {
		testCaseParseData.put(key, testCaseClaasParseData);
		setTestCaseParseData(testCaseParseData);
	}

	public static Map<String, String> getSenarioDataSet(String senario) {
		Map<String, String> senarioDataSet = new HashMap<>();
		for (Map<String, String> dataSet : getTestDataSet().values()) {
			if (dataSet.containsValue(senario)) {
				senarioDataSet = dataSet;
				break;
			}
		}
		return senarioDataSet;
	}
}
