package com.fiserv.framework.utility.files;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;

/**
 * 
 * @author Dhiraj.Bendale
 *
 */
public class CSVFiles {

	private static Logger logger = Logger.getLogger(CSVFiles.class);

	/**
	 * @author dhiraj.bendale
	 * @param filePath
	 * @param header
	 * @return
	 */
	public void createCSVFile(String filePath, String header) {
		logger.info("Creating new CSV file " + filePath);
		File file = null;
		try {
			file = new File(filePath);
			if (file.getAbsoluteFile().exists()) {
				FileUtils.forceDelete(file);
				new File(filePath);
			}
			updateCSVFile(filePath, header);
			logger.info("CSV file created successfully. " + filePath);
		} catch (IOException e) {
			logger.error("Exception..!", e);
		}
	}

	/**
	 * @author dhiraj.bendale
	 * @param fileName
	 * @param line
	 */
	public void updateCSVFile(String fileName, String line) {
		logger.info("Creating new CSV file " + fileName);
		try (FileWriter fileWriter = new FileWriter(fileName, true)) {
			fileWriter.append(line);
			fileWriter.append("\n");
		} catch (IOException e) {
			logger.error("Exception..!", e);
		}
		logger.info("CSV file created successfully. " + fileName);
	}
}