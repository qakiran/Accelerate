
package com.fiserv.accessibility.selenium;

import java.util.List;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import com.aventstack.extentreports.Status;
import com.fiserv.framework.Report;
import com.fiserv.framework.interfaces.IDropdown;
import com.fiserv.framework.utility.selenium.Locator;
import com.fiserv.selenium.Synchronization;
import com.fiserv.selenium.ElementsList;

public class Dropdown implements IDropdown {

	protected Synchronization sync = Synchronization.getInstance();
	protected Locator locator = Locator.getInstance();
	private static Logger logger = Logger.getLogger(Dropdown.class);
	private Report report = Report.getInstance();
	private ElementsList browserElementsList = ElementsList.getInstance();
	private static Dropdown instance = null;
	protected FindElement find = FindElement.getInstance();

	/**
	 * It returns the instance of the BrowserDropdown class
	 * 
	 * @return instance
	 * @author Shivang.Ahuja
	 */
	public static Dropdown getInstance() {
		if (null == instance) {
			instance = new Dropdown();
		}
		return instance;
	}

	/**
	 * It is used to get all the options of the drop down
	 * 
	 * @return All options belonging to particular tag
	 * 
	 * @author Shivang.Ahuja
	 */
	public List<String> getAllOptions() {
		List<WebElement> optionsList;
		sync.waitForElement(locator.getLocator());
		Select options = new Select(find.findElementWithAccessibility(locator.getLocator()));
		optionsList = options.getOptions();
		List<String> listOfOptions = browserElementsList.convertWebElementToString(optionsList);
		logger.debug("Dropdown locator found..." + locator.getLocator());
		return listOfOptions;
	}

	/**
	 * It is used to select a option in the drop down that displays the text
	 * matching the parameter
	 * 
	 * @param value
	 *            This is the exact displayed text of a particular option
	 * @author Shivang.Ahuja
	 */
	public void selectByVisibleText(String value) {
		sync.waitForElement(locator.getLocator());
		Select options = new Select(find.findElementWithAccessibility(locator.getLocator()));
		options.selectByVisibleText(value);
		logger.debug("Element locator found." + locator.getLocator());
		report.log("Selected value By VisibleText", value, Status.PASS);
	}

	/**
	 * It is used to select a option in the drop down at the given index
	 * 
	 * @param index
	 *            This is the index of the option to be selected
	 * @author Shivang.Ahuja
	 */
	public void selectByIndex(int index) {
		sync.waitForElement(locator.getLocator());
		Select options = new Select(find.findElementWithAccessibility(locator.getLocator()));
		options.selectByIndex(index);
		logger.debug("Element locator found.." + locator.getLocator());
		report.log("Selected value By Index", "Thursday", Status.PASS);
	}

	/**
	 * It is used to select a option in the drop down whose "value" attribute
	 * matches the specified parameter
	 * 
	 * @param value
	 *            This is the value of the "value" attribute
	 * @author Shivang.Ahuja
	 */
	public void selectByValue(String value) {
		sync.waitForElement(locator.getLocator());
		Select options = new Select(find.findElementWithAccessibility(locator.getLocator()));
		options.selectByValue(value);
		logger.debug("Element locator found..." + locator.getLocator());
		report.log("Selected value By value attribute", value, Status.PASS);

	}

	/**
	 * It is used to return the option selected in the dropdown
	 * 
	 * @author Shivang.Ahuja
	 */
	public String getFirstSelectedOption() {
		sync.waitForElement(locator.getLocator());
		Select options = new Select(find.findElementWithAccessibility(locator.getLocator()));
		String firstvalue = options.getFirstSelectedOption().getText();
		report.log("Value Selected is:", firstvalue, Status.PASS);
		return firstvalue;
	}
}
