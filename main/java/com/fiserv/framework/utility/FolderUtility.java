/**
 * 
 */
package com.fiserv.framework.utility;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;

/**
 * @author Dhiraj.Bendale
 *
 */
public class FolderUtility {

	private static Logger logger = Logger.getLogger(FolderUtility.class);

	/**
	 * Function:Create New folder and delete folder if exist .
	 * 
	 * @author dhiraj.bendale
	 * @param folderName
	 * @return true or false
	 */
	public boolean checkAndCreateFolder(String folderName) {
		File folder = new File(folderName);
		logger.debug("Creating new folder " + folderName);
		try {
			if (!folder.exists()) {
				if (folder.mkdir()) {
					logger.debug("Directory is created!");
					return true;
				} else {
					logger.error("Problem while creating folder.." + folderName);
					return false;
				}
			} else {
				logger.debug("Deleting directory.!");
				FileUtils.deleteDirectory(folder);
				if (folder.mkdir()) {
					logger.debug("Directory is created!");
					return true;
				} else {
					logger.error("Problem while creating folder. " + folderName);
					return false;
				}
			}
		} catch (Exception e) {
			logger.error("Exception..!", e);
			logger.error("Problem while creating folder." + folderName);
			return false;
		}
	}

	/**
	 * Function:Create New folder with directory structure .
	 * 
	 * @author dhiraj.bendale
	 * @param folderName
	 * @return true or false
	 */
	public boolean createFolderStructure(String folderPath) {

		File directory = new File(folderPath);

		logger.debug("Creating new folder " + folderPath);
		try {
			if (!directory.exists()) {
				if (directory.mkdirs()) {
					logger.debug("Directory structure is created!");
					return true;
				} else {
					logger.error("Problem while creating directory structure" + folderPath);
					return false;
				}
			} else {
				logger.debug("Deleting directory.!");
				directory.deleteOnExit();
				return true;
			}
		} catch (Exception e) {
			logger.error("Exception..!", e);
			logger.error("Problem while creating folder" + folderPath);
			return false;
		}
	}

}
