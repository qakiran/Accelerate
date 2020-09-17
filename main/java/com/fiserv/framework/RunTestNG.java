package com.fiserv.framework;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.testng.ITestNGListener;
import org.testng.TestNG;
import com.fiserv.framework.utility.report.ExtentManager;
import com.fiserv.framework.utility.selenium.DotTestListener;

public class RunTestNG {
	Initialize init = Initialize.getInstance();

	public void executeTestNGXML(String xmlPath) {
		ExtentManager extentManager = ExtentManager.getInstance();
		TestNG testNG = new TestNG();
		File file = new File(xmlPath);
		String absolutePath = file.getAbsolutePath();
		List<String> suite = new ArrayList<>();
		DotTestListener testListener = new DotTestListener();
		testNG.addListener((ITestNGListener) testListener);
		suite.add(absolutePath);
		testNG.setTestSuites(suite);
		testNG.run();
		extentManager.endReport();
	}
}
