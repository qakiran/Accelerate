package com.fiserv.accessibility.framework;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.fiserv.framework.constants.ReportConstants;

public class ExcelUtility {
	private static Logger logger = Logger.getLogger(ExcelUtility.class);

	/**
	 * Create workbook to capture the accessibility violation
	 * 
	 * @author vimal.tyagi
	 * 
	 */
	public void createWorkBook() {
		String fileLocation = ReportConstants.getViolationsLocation();
		Workbook workbook = new XSSFWorkbook();
		try (FileOutputStream fileOut = new FileOutputStream(fileLocation + "ViolationReport.xlsx")) {
			workbook.write(fileOut);
		} catch (Exception e) {
			logger.error("Exception ..!" + e);
		} finally {
			try {
				workbook.close();
			} catch (IOException e) {
				logger.error("Exception ..!" + e);
			}
		}
	}
}
