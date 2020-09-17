package com.fiserv.keyword;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Sheet;
import org.testng.Assert;
import com.fiserv.framework.constants.KeywordConstants;
import com.fiserv.framework.utility.excel.ReadExcel;

public class KeywordData {
	private ReadExcel rdExcel = new ReadExcel();
	String filePath = null;
	private Sheet sheet;
	private static Logger logger = Logger.getLogger(KeywordData.class);
	private static Map<String, Map<Integer, List<String>>> keywordInput = new HashMap<>();
	private static Map<Integer, String> testCases = new HashMap<>();
	private static Map<String, Map<Integer, String>> testCaseKeyword = new HashMap<>();

	public void loadTestCaseData(String sheetName) {
		filePath = sheetName;
		getTestSet();
		getTestCaseData();
	}

	private void getTestSet() {
		Map<String, Map<String, String>> testSet = rdExcel.getDataMap(filePath, "TestSet");
		Set<String> rows = testSet.keySet();
		int cnt = 1;
		for (String rowNo : rows) {
			if (testSet.get(rowNo).get("Execute").equalsIgnoreCase("yes")) {
				KeywordConstants.setTestSet(Integer.toString(cnt), testSet.get(rowNo));
				cnt++;
			}
		}
	}

	private void getTestCaseData() {
		getExcelData(filePath, "TestCases");
	}

	/**
	 * Return excel data for sheet.
	 * 
	 * @param filePath
	 * @param sheetName
	 * @return
	 */
	public void getExcelData(String filePath, String sheetName) {
		int tcCount = 1;
		int keyCount = 1;
		String testCaseID = "";
		try {
			sheet = rdExcel.getSheet(filePath, sheetName);
			int totalRows = sheet.getLastRowNum();
			Map<Integer, String> keyword = new HashMap<>();
			Map<Integer, List<String>> inputKeyword = new HashMap<>();
			for (int rowCount = 1; rowCount <= totalRows; rowCount++) {
				if (!rdExcel.getCellValue(sheet.getRow(rowCount).getCell(0)).isEmpty()) {
					testCaseID = rdExcel.getCellValue(sheet.getRow(rowCount).getCell(0));
					testCases.put(tcCount, testCaseID);
					tcCount++;
					keyCount = 1;
					keyword = new HashMap<>();
					inputKeyword = new HashMap<>();
					testCaseKeyword.put(testCaseID, keyword);
					keywordInput.put(testCaseID, inputKeyword);
				}
				keyword.put(keyCount, rdExcel.getCellValue(sheet.getRow(rowCount).getCell(1)));

				List<String> inputValue = parseRow(rowCount);
				inputKeyword.put(keyCount, inputValue);
				keyCount++;
			}
		} catch (Exception e) {
			logger.error("Not able retrive sheetname.");
			Assert.fail("Not able retrive sheetname" + e.getMessage());
		}
		updateValidOption();
	}

	private void updateValidOption() {

		Set<String> testSetKeys = KeywordConstants.getTestSet().keySet();
		for (String testSets : testSetKeys) {
			String tcID = KeywordConstants.getTestSet().get(testSets).get("TestCase Id");
			removetestCases(tcID);
			removekeywordInput(tcID);
			removetestCaseKeyword(tcID);

		}
	}

	private void removetestCaseKeyword(String tcID) {
		Map<Integer, String> temp = new HashMap<>();
		int cnt = 1;
		Set<Integer> keys = testCases.keySet();
		for (Integer key : keys) {
			if (testCases.get(key).equalsIgnoreCase(tcID)) {
				temp.put(cnt, testCases.get(key));
			}
		}
		KeywordConstants.setTestCases(temp);
	}

	private void removekeywordInput(String tcID) {
		Map<String, Map<Integer, List<String>>> temp = new HashMap<>();
		Set<String> keys = keywordInput.keySet();
		for (String key : keys) {
			if (key.equalsIgnoreCase(tcID)) {
				temp.put(key, keywordInput.get(key));
			}
		}
		KeywordConstants.setKeywordInput(temp);
	}

	private void removetestCases(String tcID) {
		Map<String, Map<Integer, String>> temp = new HashMap<>();
		Set<String> keys = testCaseKeyword.keySet();
		for (String key : keys) {
			if (key.equalsIgnoreCase(tcID)) {
				temp.put(key, testCaseKeyword.get(key));
			}
		}
		KeywordConstants.setTestCaseKeyword(temp);

	}

	private List<String> parseRow(int rowCount) {
		int totalColumns = 0;
		List<String> inputs = new ArrayList<>();
		totalColumns = sheet.getRow(rowCount).getLastCellNum();
		for (int columnCount = 2; columnCount < totalColumns; columnCount++) {
			String value = rdExcel.getCellValue(sheet.getRow(rowCount).getCell(columnCount));
			inputs.add(value);
		}
		return inputs;
	}

}
