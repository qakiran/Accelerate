/**
 * 
 */
package com.fiserv.selenium;

import java.util.List;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import com.aventstack.extentreports.Status;
import com.fiserv.driverfactory.DriverFactory;
import com.fiserv.framework.Report;
import com.fiserv.framework.interfaces.IDropdown;
import com.fiserv.framework.utility.selenium.Locator;

/**
 * @author Dhiraj.Bendale
 *
 */
public class Dropdown implements IDropdown {

	protected WebDriver driver = DriverFactory.getInstance().getDriver();
	protected Synchronization sync = Synchronization.getInstance();
	protected Locator locator = Locator.getInstance();
	private static Logger logger = Logger.getLogger(Dropdown.class);
	private Report report = Report.getInstance();
	private ElementsList browserElementsList = ElementsList.getInstance();
	private static Dropdown instance = null;

	protected Dropdown() {
		// Auto-generated constructor stub
	}

	/**
	 * It returns the instance of the BrowserDropdown class
	 * 
	 * @return instance
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
	 */
	public List<String> getAllOptions() {
		sync.waitForElement(locator.getLocator());
		Select options = new Select(driver.findElement(locator.getLocator()));
		List<WebElement> optionsList = options.getOptions();
		List<String> listOfOptions = browserElementsList.convertWebElementToString(optionsList);
		logger.debug("Dropdown locator found.." + locator.getLocator());
		return listOfOptions;
	}

	/**
	 * It is used to select a option in the drop down that displays the text
	 * matching the parameter
	 * 
	 * @param value
	 *            This is the exact displayed text of a particular option
	 */
	public void selectByVisibleText(String value) {
		sync.waitForElement(locator.getLocator());
		Select options = new Select(driver.findElement(locator.getLocator()));
		options.selectByVisibleText(value);
		logger.debug("Element locator found" + locator.getLocator());
		report.log("Selected value By VisibleText", value, Status.PASS);
	}

	/**
	 * It is used to select a option in the drop down at the given index
	 * 
	 * @param index
	 *            This is the index of the option to be selected
	 */
	public void selectByIndex(int index) {
		sync.waitForElement(locator.getLocator());
		Select options = new Select(driver.findElement(locator.getLocator()));
		options.selectByIndex(index);
		logger.debug("Element locator found." + locator.getLocator());
		report.log("Selected value By Index", "Thursday", Status.PASS);
	}

	/**
	 * It is used to select a option in the drop down whose "value" attribute
	 * matches the specified parameter
	 * 
	 * @param value
	 *            This is the value of the "value" attribute
	 */
	public void selectByValue(String value) {
		sync.waitForElement(locator.getLocator());
		Select options = new Select(driver.findElement(locator.getLocator()));
		options.selectByValue(value);
		logger.debug("Element locator found...." + locator.getLocator());
		report.log("Selected value By value attribute", value, Status.PASS);

	}

	/**
	 * It is used to return the option selected in the dropdown
	 */
	public String getFirstSelectedOption() {
		sync.waitForElement(locator.getLocator());
		Select options = new Select(driver.findElement(locator.getLocator()));
		String firstvalue = options.getFirstSelectedOption().getText();
		report.log("Value Selected is:", firstvalue, Status.PASS);
		return firstvalue;

	}

	/**
	 * It selects the option from the list, if the two string matches
	 * irrespective of case of the string then the element will be clicked.
	 * 
	 * @param list
	 *            used to get the list of the webElements
	 * @param value
	 *            used to match the content with the listed element
	 * 
	 */

	public void selectOption(List<WebElement> list, String value) {
		logger.info("Selecting option from list.");
		for (WebElement element : list) {
			if (element.getText().equalsIgnoreCase(value)) {
				element.click();
				report.log("Method Pass - Option selected from list", "", Status.PASS);
				break;
			}
		}
	}

}
