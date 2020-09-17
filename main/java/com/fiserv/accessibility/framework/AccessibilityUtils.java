package com.fiserv.accessibility.framework;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.fiserv.driverfactory.DriverFactory;
import com.fiserv.framework.constants.FrameworkConstants;
import com.fiserv.framework.constants.ReportConstants;
import com.fiserv.framework.utility.excel.UpdateExcel;

import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.*;

@SuppressWarnings("unchecked")
public class AccessibilityUtils {
	private static Logger logger = Logger.getLogger(AccessibilityUtils.class);
	private String lineSeparator = System.getProperty("line.separator");
	private UpdateExcel updateExcel = new UpdateExcel();
	protected WebDriver driver = DriverFactory.getInstance().getDriver();
	private GetHeadLessBrowser getWCAG = new GetHeadLessBrowser();
	private static String helpURLConst = "helpUrl";
	String jstromAppend = "<--JSTORM REPORT-->";

	/**
	 * @return Contents of the axe.js or axe.min.js script with a configured
	 *         reporter.
	 * @param javascript
	 *            URL
	 * 
	 * @author Vimal.Tyagi
	 * @throws IOException
	 */
	private String getContents(URL script) throws IOException {
		final StringBuilder sb = new StringBuilder();
		URLConnection connection = script.openConnection();
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
			String line;
			while ((line = reader.readLine()) != null) {
				sb.append(line);
				sb.append(lineSeparator);
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}

		return sb.toString();
	}

	/**
	 * Recursively injects a script to the top level document with the option to
	 * skip iframes.
	 * 
	 * @param driver
	 *            WebDriver instance to inject into
	 * @param scriptUrl
	 *            URL to the script to inject
	 * @param skipFrames
	 *            True if the script should not be injected into iframes
	 * 
	 * @author Shivang.Ahuja
	 * @throws IOException
	 */
	public void inject(WebDriver driver, URL scriptUrl, Boolean skipFrames) throws IOException {
		String script = getContents(scriptUrl);
		if (!skipFrames) {
			final ArrayList<WebElement> parents = new ArrayList<>();
			injectIntoFrames(driver, script, parents);
		}

		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.switchTo().defaultContent();
		js.executeScript(script);
	}

	/**
	 * Recursively injects a script into all iframes and the top level document.
	 * 
	 * @param driver
	 *            WebDriver instance to inject into
	 * @param scriptUrl
	 *            URL to the script to inject
	 * @author Vimal.Tyagi
	 * @throws IOException
	 */
	public void inject(WebDriver driver, URL scriptUrl) throws IOException {
		inject(driver, scriptUrl, false);
	}

	/**
	 * Recursively find frames and inject a script into them.
	 * 
	 * @param driver
	 *            An initialized WebDriver
	 * @param script
	 *            Script to inject
	 * @param parents
	 *            A list of all toplevel frames
	 * 
	 * @author Shivang.Ahuja
	 */
	private void injectIntoFrames(WebDriver driver, String script, final ArrayList<WebElement> parents) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		List<WebElement> frames = driver.findElements(By.tagName("iframe"));

		for (WebElement frame : frames) {
			driver.switchTo().defaultContent();

			if (parents != null) {
				for (WebElement parent : parents) {
					driver.switchTo().frame(parent);
				}
			}
			driver.switchTo().frame(frame);
			js.executeScript(script);
			if (parents != null) {
				ArrayList<WebElement> localParents = (ArrayList<WebElement>) parents.clone();
				localParents.add(frame);

				injectIntoFrames(driver, script, localParents);
			}
		}
	}

	/**
	 * Convert json report to string and return the violations report
	 * 
	 * @param violations
	 *            JSONArray of violations
	 * @return readable report of accessibility violations found
	 * 
	 * @author Vimal.Tyagi
	 */
	public String htmlReport(final JSONArray violations) {
		final StringBuilder sb = new StringBuilder();
		sb.append("Found ").append(violations.length()).append(" accessibility violations:");
		for (int violationsCount = 0; violationsCount < violations.length(); violationsCount++) {
			JSONObject violation = violations.getJSONObject(violationsCount);
			sb.append(lineSeparator).append(violationsCount + 1).append(") ").append(jstromAppend)
					.append(violation.getString("help"));
			if (violation.has(helpURLConst)) {
				String helpUrl = violation.getString(helpURLConst);
				sb.append(": ").append(helpUrl);
			}
			JSONArray nodes = violation.getJSONArray("nodes");
			for (int nodesCount = 0; nodesCount < nodes.length(); nodesCount++) {
				JSONObject node = nodes.getJSONObject(nodesCount);
				sb.append(lineSeparator).append("  ").append(getOrdinal(nodesCount + 1)).append(") ")
						.append(node.getJSONArray("target")).append(lineSeparator);
				JSONArray all = node.getJSONArray("all");
				JSONArray none = node.getJSONArray("none");

				for (int k = 0; k < none.length(); k++) {
					all.put(none.getJSONObject(k));
				}

				appendFixes(sb, all, "Fix all of the following:");
				appendFixes(sb, node.getJSONArray("any"), "Fix any of the following:");

			}
		}

		return sb.toString();
	}

	/**
	 * Convert json report to string and return the violations report in string
	 * format
	 * 
	 * @param violations
	 *            JSONArray of violations
	 * @return readable report of accessibility violations found
	 * 
	 * @author Shivang.Ahuja
	 */

	public String excelReport(final JSONArray violations) {
		final StringBuilder sb = new StringBuilder();
		sb.append("Found ").append(violations.length()).append(" accessibility violations:");
		for (int violationsCount = 0; violationsCount < violations.length(); violationsCount++) {
			JSONObject violation = violations.getJSONObject(violationsCount);
			sb.append(lineSeparator).append(violationsCount + 1).append(") ").append(jstromAppend).append(lineSeparator)
					.append("Issue Description: ").append(violation.getString("help")).append(lineSeparator);
			if (violation.has(helpURLConst)) {
				String helpUrl = violation.getString(helpURLConst);
				String impact = violation.getString("impact");
				sb.append("Learn more: ").append(helpUrl);
				sb.append(lineSeparator).append("Impact:  ").append(impact);
			}
			JSONArray nodes = violation.getJSONArray("nodes");
			for (int nodesCount = 0; nodesCount < nodes.length(); nodesCount++) {
				JSONObject node = nodes.getJSONObject(nodesCount);
				sb.append(lineSeparator).append("  ").append(getOrdinal(nodesCount + 1)).append(") Element affected: ")
						.append(node.getJSONArray("target")).append(lineSeparator);
				JSONArray all = node.getJSONArray("all");
				JSONArray none = node.getJSONArray("none");

				for (int k = 0; k < none.length(); k++) {
					all.put(none.getJSONObject(k));
				}

				appendFixes(sb, all, "Resolutions: ");
				appendFixes(sb, node.getJSONArray("any"), "Resolutions: ");

			}
		}
		insertDataToExcel(sb.toString());
		return sb.toString();
	}

	public void insertDataToExcel(String violations) {
		getWCAG.openHeadLessBrowser();
		ArrayList<String> guideLines = new ArrayList<>();
		String violation;
		String description;
		String link;
		String impact;
		String resolutions;
		String sheetName;
		String guideLine;
		String axeApi;
		String filePath = ReportConstants.getViolationsLocation() + "ViolationReport.xlsx";
		sheetName = driver.getTitle();
		if (sheetName.length() > 31)
			sheetName = StringUtils.left(sheetName, 30);
		updateExcel.addSheet(filePath, sheetName, FrameworkConstants.getAccessConfig().get("EXCEL_REPORT_COLUMNS"));
		List<String> violationList = new ArrayList<>(Arrays.asList(violations.trim().split(jstromAppend)));
		int rowCount = 1;
		for (int parentViolation = 1; parentViolation < violationList.size(); parentViolation++) {
			String srNo = String.valueOf(parentViolation);
			violation = violationList.get(parentViolation);
			description = violation.split("Learn more:")[0].split("Issue Description:")[1];
			link = violation.split("Impact:")[0].split("Learn more:")[1];
			axeApi = link;
			impact = violation.split("Element affected:")[0].split("Impact:")[1];
			impact = impact.substring(0, impact.length() - 3);
			String[] subIssue = violation.split("Element affected:");
			for (int childViolation = 1; childViolation < subIssue.length; childViolation++) {
				resolutions = subIssue[childViolation].split("Resolutions:")[1].trim();
				resolutions = resolutions.substring(0, resolutions.length() - 3);
				updateExcel.setCellData(filePath, sheetName, srNo + "." + childViolation, rowCount, 0);
				updateExcel.setCellData(filePath, sheetName, subIssue[childViolation].split("Resolutions:")[0].trim(),
						rowCount, 1);
				updateExcel.setCellData(filePath, sheetName, description, rowCount, 2);
				updateExcel.setCellData(filePath, sheetName, impact.trim(), rowCount, 3);
				updateExcel.setCellData(filePath, sheetName, resolutions, rowCount, 5);
				updateExcel.setCellData(filePath, sheetName, axeApi, rowCount, 7);
				guideLines.add(axeApi);
				rowCount++;
			}
		}
		rowCount = 1;
		for (int findRule = 0; findRule < guideLines.size(); findRule++) {
			guideLine = getWCAG.getWCAGGuideline(guideLines.get(findRule));
			link = FrameworkConstants.getAccessConfig().get("GUIDELINE_URL").replace("{rule}", guideLine);
			if (guideLine.equalsIgnoreCase("Best practice"))
				link = "";
			if (guideLine.contains(",")) {
				String links = "";
				String[] rules = guideLine.split(",");
				for (String rule : rules) {
					links = links + FrameworkConstants.getAccessConfig().get("GUIDELINE_URL").replace("{rule}", rule);
				}
				link = links;
			}
			updateExcel.setCellData(filePath, sheetName, guideLine, rowCount, 4);
			updateExcel.setCellData(filePath, sheetName, link, rowCount, 6);
			rowCount++;
		}
		getWCAG.closeHeadlessBrowser();
	}

	/**
	 * Fix all the string appends
	 * 
	 * @param violations
	 *            JSONArray of violations
	 * @return readable report of accessibility violations found
	 * 
	 * @author Vimal.Tyagi
	 */
	private void appendFixes(StringBuilder sb, JSONArray arr, String heading) {
		if (arr != null && arr.length() > 0) {
			sb.append("    ").append(heading).append(lineSeparator);

			for (int i = 0; i < arr.length(); i++) {
				JSONObject fix = arr.getJSONObject(i);

				sb.append("      ").append(fix.get("message")).append(lineSeparator);
			}

			sb.append(lineSeparator);
		}
	}

	private String getOrdinal(int number) {
		String ordinal = "";

		int mod;

		while (number > 0) {
			mod = (number - 1) % 26;
			ordinal = (char) (mod + 97) + ordinal;
			number = (number - mod) / 26;
		}
		return ordinal;
	}
}
