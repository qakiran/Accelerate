package com.fiserv.framework.utility.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.Assert;

public class ReadExcel {

	private static Sheet workSheet = null;
	private String[][] data;
	private Sheet sheet;
	private static Logger logger = Logger.getLogger(ReadExcel.class);

	/**
	 * Get sheet name of excel.
	 * 
	 * @param filePath
	 * @param sheetName
	 * @return
	 */
	public  Sheet getSheet(String filePath, String sheetName) {
		File file = new File(filePath);
		FileInputStream fileInputStream = null;
		try {
			fileInputStream = new FileInputStream(file);
		} catch (FileNotFoundException e1) {
			logger.error("Not able retrive file.");
		}
		try (Workbook workBook = WorkbookFactory.create(fileInputStream);) {
			workSheet = workBook.getSheet(sheetName);
		} catch (Exception e) {
			logger.error("Not able retrive sheetname..");
			Assert.fail("Not able retrive sheetName." + e.getMessage());
		}
		return workSheet;
	}

	/**
	 * Return excel data for sheet.
	 * 
	 * @param filePath
	 * @param sheetName
	 * @return
	 */
	public String[][] getExcelData(String filePath, String sheetName) {

		try {
			sheet = getSheet(filePath, sheetName);
			int totalRows = sheet.getLastRowNum();
			int totalColumns = sheet.getRow(0).getLastCellNum();
			data = new String[totalRows + 1][totalColumns];

			for (int rowCount = 0; rowCount <= totalRows; rowCount++) {
				for (int columnCount = 0; columnCount < totalColumns; columnCount++) {
					data[rowCount][columnCount] = getCellValue(sheet.getRow(rowCount).getCell(columnCount));
				}
			}
			return data;
		} catch (Exception e) {
			logger.error("Unable retrive sheetname.");
			Assert.fail("Not able retrive sheetname " + e.getMessage());
			return data;
		}
	}

	/**
	 * Return Cell value
	 * 
	 * @param cell
	 * @return
	 */
	public String getCellValue(Cell cell) {
		String strCellValue = "";
		try {
			if (cell == null) {
				strCellValue = "";
			} else {
				switch (cell.getCellTypeEnum()) {
				case BOOLEAN:
					strCellValue = Boolean.toString(cell.getBooleanCellValue());
					break;
				case STRING:
					strCellValue = cell.getRichStringCellValue().getString();
					break;
				case NUMERIC:
					if (DateUtil.isCellDateFormatted(cell)) {
						SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
						strCellValue = dateFormat.format(cell.getDateCellValue());
					} else {
						Double value = cell.getNumericCellValue();
						Long longValue = value.longValue();
						strCellValue = longValue.toString();
					}
					break;
				case BLANK:
					strCellValue = "";
					break;
				default:
					strCellValue = "";
				}
			}
			return strCellValue.trim();
		} catch (Exception e) {
			logger.error("Error while parcing cell value");
			return "";
		}
	}

	/**
	 * Convert excel sheet data into hashmap.
	 * 
	 * @param filePath
	 * @param sheetName
	 * @return
	 */
	public Object[][] getDatawithMap(String filePath, String sheetName) {
		sheet = getSheet(filePath, sheetName);
		int totalRows = sheet.getLastRowNum();
		int totalColumns = sheet.getRow(0).getLastCellNum();
		Object[][] dataObj = new Object[totalRows][2];
		String[] headerNames;
		headerNames = getColumnHeaders(filePath, sheetName);
		for (int rowCount = 1; rowCount <= totalRows; rowCount++) {
			Map<String, String> map = new HashMap<>();
			for (int columnCount = 1; columnCount < totalColumns; columnCount++) {
				map.put(headerNames[columnCount], getCellValue(sheet.getRow(rowCount).getCell(columnCount)));
				if (columnCount == totalColumns - 1) {
					dataObj[rowCount - 1][0] = getCellValue(sheet.getRow(rowCount).getCell(0));
					dataObj[rowCount - 1][1] = map;
				}
			}
		}
		return dataObj;
	}

	/**
	 * Convert excel sheet data into hashmap.
	 * 
	 * @param filePath
	 * @param sheetName
	 * @return
	 * @return
	 */
	public Map<String, Map<String, String>> getDataMap(String filePath, String sheetName) {
		sheet = getSheet(filePath, sheetName);
		int totalColumns = sheet.getRow(0).getLastCellNum();
		int totalRows = sheet.getLastRowNum();
		Map<String, Map<String, String>> mapData = new HashMap<>();
		Map<String, String> map;
		String[] headerName = getColumnHeaders(filePath, sheetName);
		for (int rowCount = 1; rowCount <= totalRows; rowCount++) {
			map = new HashMap<>();
			for (int columnCount = 1; columnCount < totalColumns; columnCount++) {
				map.put(headerName[columnCount], getCellValue(sheet.getRow(rowCount).getCell(columnCount)));
				if (columnCount == totalColumns - 1) {
					mapData.put(getCellValue(sheet.getRow(rowCount).getCell(0)), map);
				}
			}
		}
		return mapData;
	}

	/**
	 * Return key data for particular key.
	 * 
	 * @param filePath
	 * @param sheetName
	 * @param key
	 * @return
	 */
	public Object[][] getDataProviderWithMapBasedOnKey(String filePath, String sheetName, String key) {
		sheet = getSheet(filePath, sheetName);
		int totalColumns = sheet.getRow(0).getLastCellNum();
		int totalRows = sheet.getLastRowNum();
		int flag = 0;
		int keyColumnIndex = 0;
		int rowIndex = 0;
		Object[][] dataOb = new Object[totalRows][2];
		HashMap<String, String> map = new HashMap<>();
		String[] nameHeader = getColumnHeaders(filePath, sheetName);

		for (int columnCount = 0; columnCount < totalColumns; columnCount++) {
			if (getCellValue(sheet.getRow(0).getCell(columnCount)).equalsIgnoreCase("Key")) {
				flag++;
				keyColumnIndex = columnCount;
				break;
			}
		}
		if (flag == 1) {
			for (int rowCount = 1; rowCount <= totalRows; rowCount++) {
				if (getCellValue(sheet.getRow(rowCount).getCell(keyColumnIndex)).equalsIgnoreCase(key)) {
					rowIndex = rowCount;
					for (int columnCount = 1; columnCount < totalColumns; columnCount++) {
						map.put(nameHeader[columnCount], getCellValue(sheet.getRow(rowIndex).getCell(columnCount)));
						if (columnCount == totalColumns - 1) {
							dataOb[0][0] = getCellValue(sheet.getRow(rowCount).getCell(0));
							dataOb[0][1] = map;
						}
					}
				}
			}
		}
		return dataOb;
	}

	/**
	 * Return header of excel sheet.
	 * 
	 * @param filePath
	 * @param sheetName
	 * @return
	 */
	public String[] getColumnHeaders(String filePath, String sheetName) {
		sheet = getSheet(filePath, sheetName);
		int totalColumns = sheet.getRow(0).getLastCellNum();
		String[] headersName = new String[totalColumns];
		for (int headerCount = 0; headerCount < totalColumns; headerCount++) {
			headersName[headerCount] = getCellValue(sheet.getRow(0).getCell(headerCount));
		}
		return headersName;
	}

	/**
	 * Get excel sheet data without headers .
	 * 
	 * @param filePath
	 * @param sheetName
	 * @return
	 */
	public String[][] getExcelDataWithoutHeaders(String filePath, String sheetName) {

		try {
			sheet = getSheet(filePath, sheetName);
			int totalRows = sheet.getLastRowNum();
			int totalColumns = sheet.getRow(0).getLastCellNum();
			data = new String[totalRows][totalColumns];

			for (int rowCount = 0; rowCount < totalRows; rowCount++) {
				for (int columnCount = 0; columnCount < totalColumns; columnCount++) {
					data[rowCount][columnCount] = getCellValue(sheet.getRow(rowCount + 1).getCell(columnCount));
				}
			}
			return data;
		} catch (Exception e) {
			logger.error("Not able retrive sheetname.");
			Assert.fail("Not able retrive sheetname." + e.getMessage());
			return data;
		}
	}

	/**
	 * Get excel data for key .
	 * 
	 * @param filePath
	 * @param sheetName
	 * @param key
	 * @return
	 */
	public Map<String, Map<String, String>> getDataWithMapBasedOnKey(String filePath, String sheetName, String key) {
		sheet = getSheet(filePath, sheetName);
		int totalColumns = sheet.getRow(0).getLastCellNum();
		int totalRows = sheet.getLastRowNum();
		int flag = 0;
		int keyColumnIndex = 0;
		int rowIndex = 0;
		Map<String, Map<String, String>> dataMap = new HashMap<>();
		Map<String, String> map = new HashMap<>();
		String[] headerName = getColumnHeaders(filePath, sheetName);

		for (int columnCount = 0; columnCount < totalColumns; columnCount++) {
			if (getCellValue(sheet.getRow(0).getCell(columnCount)).equalsIgnoreCase("Key")) {
				flag++;
				keyColumnIndex = columnCount;
				break;
			}
		}
		if (flag == 1) {
			for (int rowCount = 1; rowCount <= totalRows; rowCount++) {
				if (getCellValue(sheet.getRow(rowCount).getCell(keyColumnIndex)).equalsIgnoreCase(key)) {
					rowIndex = rowCount;
					for (int columnCount = 1; columnCount < totalColumns; columnCount++) {
						map.put(headerName[columnCount], getCellValue(sheet.getRow(rowIndex).getCell(columnCount)));
						if (columnCount == totalColumns - 1) {
							dataMap.put(getCellValue(sheet.getRow(rowCount).getCell(0)), map);
						}
					}
				}
			}
		}
		return dataMap;
	}

}
