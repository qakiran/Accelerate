package com.fiserv.selenium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.fiserv.driverfactory.DriverFactory;
import com.fiserv.framework.Report;
import com.fiserv.framework.interfaces.IElementList;

/**
 * 
 * @author Pooja.Pathak
 *
 */

public class ElementsList implements IElementList {
	protected WebDriver driver = DriverFactory.getInstance().getDriver();
	private static Logger logger = Logger.getLogger(ElementsList.class);
	protected Synchronization browserSync = Synchronization.getInstance();
	protected static Report report = Report.getInstance();
	private static ElementsList instance;

	protected ElementsList() {

	}

	public static ElementsList getInstance() {
		if (null == instance) {
			instance = new ElementsList();
		}
		return instance;
	}

	/**
	 * @return :It returns a List of WebElements as found with the given element
	 *         locator
	 * 
	 */

	public List<WebElement> getListOfElements(By elementLocator) {
		browserSync.waitForElement(elementLocator);
		List<WebElement> elementList = driver.findElements(elementLocator);
		logger.debug("Returning the list of elements. Size is  ..." + elementList.size());
		return elementList;
	}

	/**
	 * @return : It returns a List of text values from the list of WebElements
	 *         as found with the given element locator
	 */

	public List<String> getListOfElementByText(By elementLocator) {

		List<WebElement> listElements = driver.findElements(elementLocator);
		List<String> listValues = new ArrayList<>();
		for (int i = 0; i < listElements.size() - 1; i++) {
			listValues.add(listElements.get(i).getText());
		}

		return listValues;
	}

	/**
	 * @return : It returns a Boolean Value depending upon whether a given text
	 *         value is present in the list as found by the element locator
	 */

	public boolean isTextPresentInList(By elementLocator, String value) {
		List<String> listValues = getListOfElementByText(elementLocator);
		return listValues.contains(value);

	}

	/**
	 * @return : It returns a Sorted List Value of a list that is found by the
	 *         given element locator
	 */

	public List<String> sortElementsInList(By elementLocator, String sortby) {

		List<String> listValues = getListOfElementByText(elementLocator);

		if (sortby.equalsIgnoreCase("Ascending")) {

			Collections.sort(listValues);
			return listValues;
		}

		if (sortby.equalsIgnoreCase("Descending")) {
			Collections.sort(listValues);
			Collections.reverse(listValues);
		}
		return listValues;

	}

	/**
	 * @return : It returns a Boolean Value depending upon whether a given List
	 *         of text values are present in the list as found by the element
	 *         locator
	 */

	public String compareList(By elementLocator, List<String> list) {

		List<String> actuallist = getListOfElementByText(elementLocator);

		List<String> actualArraylist = new ArrayList<>();
		actualArraylist.addAll(actuallist);

		List<String> expectedList = new ArrayList<>();
		expectedList.addAll(list);

		if (actualArraylist.size() != expectedList.size()) {
			return "The Size of the expected and actual list are not same.";
		}

		else {
			for (int i = 0; i < actuallist.size(); i++) {

				if (expectedList.contains(actualArraylist.get(i))) {
					continue;

				} else {
					return "The value " + actualArraylist.get(i) + " is not present in the expected list.";
				}
			}
			return "Both the lists matched. ";
		}
	}

	/**
	 * @return : It returns the size of the List as is found by the given
	 *         element locator
	 */

	public int getElementListSize(By elementLocator) {

		return getListOfElements(elementLocator).size();
	}

	/**
	 * It converts each webElement from the list to a String using getText()
	 * method which returns a String value
	 * 
	 * @param list
	 *            used to get the list of the webElements
	 * @return lists used to return the dynamic array list of the elements of
	 *         String type
	 */
	public List<String> convertWebElementToString(List<WebElement> list) {
		List<String> lists = new ArrayList<>();
		for (WebElement element : list) {
			lists.add(element.getText().trim());
		}
		return lists;
	}

}
