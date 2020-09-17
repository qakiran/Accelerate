package com.fiserv.framework.utility.report;

import java.net.InetAddress;
import org.apache.log4j.Logger;
import com.aventstack.extentreports.AnalysisStrategy;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.fiserv.framework.constants.FrameworkConstants;
import com.fiserv.framework.constants.ReportConstants;

/**
 * 
 * @author dhiraj.bendale
 *
 */
public class ExtentManager {

	private ExtentReports extent;
	private ExtentHtmlReporter htmlReporter;
	private static ExtentManager instance = null;

	private static Logger logger = Logger.getLogger(ExtentManager.class);

	protected ExtentManager() {

	}

	/**
	 * 
	 * @author Dhiraj.Bendale
	 *
	 */
	public static ExtentManager getInstance() {

		if (null == instance) {
			instance = new ExtentManager();
		}
		return instance;
	}

	public ExtentReports getExtent() {
		if (FrameworkConstants.isHtmlReport()) {
			if (extent != null)
				return extent; // avoid creating new instance of html file
			extent = new ExtentReports();
			extent.attachReporter(getHtmlReporter());
			ExtentReportConstant.getInstance().setExtent(extent);
		}
		return extent;
	}

	/**
	 * @author dhiraj.bendale
	 * @return
	 */
	private ExtentHtmlReporter getHtmlReporter() {
		String filePath = ReportConstants.getOutputFolder() + "/extentreport.html";
		InetAddress ip;
		try {
			ip = InetAddress.getLocalHost();

			htmlReporter = new ExtentHtmlReporter(filePath);

			htmlReporter.config().setDocumentTitle(FrameworkConstants.getReportConfig().get("HTML_REPORT_TILE"));
			htmlReporter.config().setReportName(ReportConstants.getHtmlReportTitle());
			htmlReporter.config().setTheme(Theme.STANDARD);
			extent.setAnalysisStrategy(AnalysisStrategy.TEST);
			htmlReporter.config().setTimeStampFormat("MM/dd/yyyy hh:mm:ss a");
			htmlReporter.config().setChartVisibilityOnOpen(true);

			extent.setSystemInfo("OS", System.getProperty("os.name").toUpperCase());
			extent.setSystemInfo("Host Name", ip.getHostName());
			extent.setSystemInfo("IP ", ip.toString());
			extent.setSystemInfo("User Name", System.getProperty("user.name"));
			return htmlReporter;
		} catch (Exception e) {
			logger.error("Extent report file is not created successfully. " + e.getMessage());
		}
		return htmlReporter;
	}

	/**
	 * @author dhiraj.bendale
	 * 
	 */

	public void endReport() {
		if (FrameworkConstants.isHtmlReport()) {
			extent.flush();
		}
	}
}
