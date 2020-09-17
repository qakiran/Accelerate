package com.fiserv.accessibility.selenium;

import java.util.List;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.fiserv.framework.interfaces.ITable;
import com.fiserv.selenium.Synchronization;

public class Table implements ITable {

	private static Table instance = null;
	private static Logger logger = Logger.getLogger(Table.class);
	protected Synchronization sync = Synchronization.getInstance();
	protected FindElement find = FindElement.getInstance();


	/**
	 * It returns the instance of the BrowserTable class
	 * 
	 * @return instance This is the instance of BrowserTable
	 * @author Vimal.Tyagi
	 */
	public static Table getInstance() {
		if (null == instance) {
			instance = new Table();
		}
		return instance;
	}

	/**
	 * It returns the list of WebElements found by the element locator
	 * 
	 * @return tableData List of WebElements
	 * 
	 * @author Vimal.Tyagi
	 */
	public List<WebElement> getTable(By elementLocator) {
		 List<WebElement> tableData;
		logger.debug("Get table data of element locator " + elementLocator);
		sync.waitForElement(elementLocator);
		tableData = find.findElementsWithAccessibility(elementLocator);
		return tableData;
	}

}
