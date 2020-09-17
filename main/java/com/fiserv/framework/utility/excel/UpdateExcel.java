package com.fiserv.framework.utility.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.Assert;

public class UpdateExcel {
	private Workbook workBook = null;
	private Sheet workSheet = null;
	private Row row;
	private Cell cell;
	private static Logger logger = Logger.getLogger(UpdateExcel.class);

	/**
	 * This method is to write in the Excel cell, filePath, sheetName,
	 * Result,RowNum and ColNum are the parameters
	 * 
	 * @param filePath
	 * @param sheetName
	 * @param result
	 * @param rowNum
	 * @param colNum
	 */
	public void setCellData(String filePath, String sheetName, String result, int rowNum, int colNum) {
		workSheet = getSheet(filePath, sheetName);
		row = workSheet.getRow(rowNum);
		if (row == null) {
			row = workSheet.createRow(rowNum);
		}
		cell = row.getCell(colNum);
		if (cell == null) {
			cell = row.createCell(colNum);
			cell.setCellValue(result);
		} else {
			cell.setCellValue(result);
		}
		try (FileOutputStream fileOutputStream = new FileOutputStream(filePath)) {
			workBook.write(fileOutputStream);
			fileOutputStream.flush();
		} catch (Exception e) {
			logger.error("Not able set cell data sheet.");
			Assert.fail("Not able set cell data sheet" + e.getMessage());
		}
	}

	/**
	 * Get sheet name of excel.
	 * 
	 * @param filePath
	 * @param sheetName
	 * @return
	 */
	public Sheet getSheet(String filePath, String sheetName) {
		File file = new File(filePath);
		try {
			FileInputStream fileInputStream = new FileInputStream(file);
			workBook = WorkbookFactory.create(fileInputStream);
			workSheet = workBook.getSheet(sheetName);
		} catch (Exception e) {
			logger.error("Not able retrive sheet.");
			Assert.fail("Not able retrive sheetname." + e.getMessage());
		}
		return workSheet;
	}

	/**
	 * Add excel sheet with required columns in existing workbook.
	 * 
	 * @param fileName
	 *            - Workbook location
	 * @param sheetName
	 * @param columns
	 * @return
	 * 
	 * @author vimal.tyagi
	 */

	public void addSheet(String fileName, String sheetName, String columns) {
		try {
			workBook = WorkbookFactory.create(new FileInputStream(fileName));
			for (int sheetIndex = 0; sheetIndex < workBook.getNumberOfSheets(); sheetIndex++) {
				if (workBook.getSheetName(sheetIndex).equals(sheetName)) {
					workBook.close();
					logger.info(sheetName + " is already created in workBook.");
				}
			}
			workSheet = workBook.createSheet(sheetName);
			addReportHeader(columns);
			workBook.write(new FileOutputStream(fileName));
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}

	/**
	 * Add column names and format column header size and color
	 * 
	 * @param cellNames
	 * @return
	 * 
	 * @author vimal.tyagi
	 */

	@SuppressWarnings("deprecation")
	public void addReportHeader(String cellNames) {
		ArrayList<String> cells = new ArrayList<>(Arrays.asList(cellNames.trim().split(",")));
		CellStyle style = workBook.createCellStyle();
		style.setFillForegroundColor(IndexedColors.GREY_40_PERCENT.getIndex());
		style.setFillPattern(CellStyle.SOLID_FOREGROUND);
		Font font = workBook.createFont();
		font.setBold(true);
		font.setFontHeightInPoints((short) 14);
		font.setColor(IndexedColors.WHITE.getIndex());
		style.setFont(font);
		row = workSheet.createRow(0);
		workSheet.autoSizeColumn(1000000);
		for (int cellNo = 0; cellNo < cells.size(); cellNo++) {
			cell = row.createCell(cellNo);
			cell.setCellValue(cells.get(cellNo));
			cell.setCellStyle(style);
		}
	}
}
