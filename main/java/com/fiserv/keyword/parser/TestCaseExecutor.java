package com.fiserv.keyword.parser;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.log4j.Logger;
import com.fiserv.framework.constants.FrameworkConstants;
import com.fiserv.framework.constants.KeywordConstants;
import com.fiserv.framework.utility.excel.ReadExcel;
import com.fiserv.framework.utility.report.ExtentReportConstant;
import com.fiserv.keyword.Keywords;

/**
 * 
 * @author dhiraj.bendale
 *
 */
public class TestCaseExecutor {

	private static Logger logger = Logger.getLogger(TestCaseExecutor.class);
	private KeywordConstants keyConst = new KeywordConstants();
	private ExtentReportConstant reportConstant = ExtentReportConstant.getInstance();
	String filePath = null;
	private ReadExcel rdExcel = new ReadExcel();

	/**
	 * @author dhiraj.bendale
	 * @param testCase
	 * @return
	 */

	public void executeTestCase(String sheetName) {
		filePath = sheetName;
		for (Integer testCaseKey : keyConst.getTestCases().keySet()) {
			String tcId = keyConst.getTestCases().get(testCaseKey);
			executeTestDataset(tcId);

		}
	}

	private void executeTestDataset(String tcId) {
		Map<Integer, String> keyWords = keyConst.getTestCaseKeyword().get(tcId);
		testCaseDataSet(tcId);
		Set<String> dataSet = KeywordConstants.getTestDataSet().keySet();
		for (String dataSetCnt : dataSet) {
			KeywordConstants.setKeyWordData(KeywordConstants.getTestDataSet().get(dataSetCnt));
			String scnearioName = KeywordConstants.getTestDataSet().get(dataSetCnt).get("scenario");
			if (FrameworkConstants.isHtmlReport()) {
				String tcDescription = getTCDescription(tcId);
				reportConstant.setTestCase(tcDescription + " - " + scnearioName);
			}
			for (Integer keyword : keyWords.keySet()) {
				String testKeyWord = keyWords.get(keyword);
				executeTestCase(testKeyWord, tcId);
			}
		}

	}

	private String getTCDescription(String tcId) {
		Set<String> keys = KeywordConstants.getTestSet().keySet();
		String testDescription = "";
		for (String key : keys) {
			if (KeywordConstants.getTestSet().get(key).get("TestCase Id").equalsIgnoreCase(tcId)) {
				testDescription = KeywordConstants.getTestSet().get(key).get("TestCase Description");
				break;
			}
		}

		return testDescription;
	}

	private void testCaseDataSet(String tcID) {
		Map<String, Map<String, String>> testSet = rdExcel.getDataMap(filePath, "Data-" + tcID);
		Set<String> rows = testSet.keySet();
		KeywordConstants.initSetTestDataSet();
		int cnt = 1;
		for (String rowNo : rows) {
			if (testSet.get(rowNo).get("Execute").equalsIgnoreCase("yes")) {
				KeywordConstants.setTestDataSet(Integer.toString(cnt), testSet.get(rowNo));
				cnt++;
			}
		}
	}

	/**
	 * @author dhiraj.bendale
	 * @param keyWord
	 * @param testCase
	 * @param keyWordCnt
	 * @throws Exception
	 */
	public void executeTestCase(String keyWord, String testCase) {
		List<String> keywordInfo = keyConst.getTestCaseParseData().get(keyWord);
		String className = keywordInfo.get(0);
		String methodName = keywordInfo.get(1);
		String category = keywordInfo.get(3);
		invokeMethod(className, methodName, keyWord, category);

	}

	/**
	 * @author dhiraj.bendale
	 * @param className
	 * @param methodName
	 * @param keyWord
	 * @param testData
	 * @param category
	 * @throws Exception
	 */
	private void invokeMethod(String className, String methodName, String keyWord, String category) {
		logger.info("Test case start execution " + keyWord);
		logger.info("Test Case Category is " + getGroupName(category));
		reportConstant.getTestCase().assignCategory(category);
		reportConstant.setParentTestNode(keyWord);
		reportConstant.getParentTestNode();
		try {
			Class<?> myclass = Class.forName(className);
			Method[] methods = myclass.getMethods();
			Object obj = myclass.newInstance();

			outerloop: for (Method method : methods) {
				Keywords anno = method.getAnnotation(Keywords.class);
				if (anno != null && anno.description().equalsIgnoreCase(keyWord)
						&& method.getName().equalsIgnoreCase(methodName)) {
					method.invoke(obj);
					break outerloop;
				}
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}

	private String getGroupName(String arg0) {
		if (arg0.isEmpty()) {
			return "Un-Categories";
		} else {
			return arg0;
		}
	}
}
