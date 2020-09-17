/**
 * 
 */
package com.fiserv.selenium;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.fiserv.driverfactory.DriverFactory;
import com.fiserv.framework.interfaces.ITable;

/**
 * @author Dhiraj.Bendale
 *
 */
public class Table implements ITable {

	private static Table instance = null;
	private static Logger logger = Logger.getLogger(Table.class);
	protected Synchronization browserSync = Synchronization.getInstance();
	protected WebDriver driver = DriverFactory.getInstance().getDriver();

	protected Table() {
		//  Auto-generated constructor stub
	}

	/**
	   * It returns the instance of the BrowserTable class
	   * @return instance This is the instance of BrowserTable
	   */
	public static Table getInstance() {
		if (null == instance) {
			instance = new Table();
		}
		return instance;
	}

	/**
	   * It returns the list of WebElements found by the element locator
	   * @return tableData List of WebElements
	   */
	public List<WebElement> getTable(By elementLocator) {
		List<WebElement> tableData;
		logger.debug("Get table data of element locator " + elementLocator);
		browserSync.waitForElement(elementLocator);
		tableData = driver.findElements(elementLocator);
		return tableData;
	}

}
