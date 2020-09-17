package com.fiserv.keyword;

import java.io.File;

import org.apache.log4j.Logger;

import com.fiserv.framework.Initialize;
import com.fiserv.framework.constants.FrameworkConstants;
import com.fiserv.framework.utility.report.ExtentManager;
import com.fiserv.keyword.parser.TestCaseExecutor;
import com.fiserv.keyword.parser.TestParser;

public class ExecuteKeyword extends TestParser {
	private static Logger logger = Logger.getLogger(ExecuteKeyword.class);
	private KeywordData keyData = new KeywordData();
	private TestCaseExecutor testCaseExecutor = new TestCaseExecutor();
	ExtentManager extentManager;

	public void execute(String packageName, String sheetName) {
		try {
			extentManager = ExtentManager.getInstance();
			logger.debug("Parsing testcase from " + packageName + " package.");
			parseMethods(packageName);
			keyData.loadTestCaseData(sheetName);
			testCaseExecutor.executeTestCase(sheetName);
			extentManager.endReport();
		} catch (Exception e) {
			logger.info("Execution stopped due to " + e.getStackTrace());
		} finally {
			extentManager.endReport();
		}
	}

	public void startExecution() {
		Initialize.getInstance();
		String folderPath = System.getProperty("user.dir") + File.separator
				+ FrameworkConstants.getKeywordConfig().get("EXCEL_PATH");
		String sheets = FrameworkConstants.getKeywordConfig().get("SHEET_NAME");
		String[] executionSheets = sheets.split(",");
		for (int sheet = 0; sheet < executionSheets.length; sheet++) {
			execute(FrameworkConstants.getKeywordConfig().get("TestCases"),
					folderPath + File.separator + executionSheets[sheet]);
		}
	}
}
