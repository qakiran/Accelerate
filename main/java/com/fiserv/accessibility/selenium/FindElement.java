package com.fiserv.accessibility.selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.fiserv.accessibility.framework.AccessibilityLibrary;
import com.fiserv.driverfactory.DriverFactory;
import com.fiserv.selenium.Synchronization;

public class FindElement {
	protected WebDriver driver = DriverFactory.getInstance().getDriver();
	private Synchronization sync = Synchronization.getInstance();
	private static FindElement instance = null;
	protected AccessibilityLibrary accLib = AccessibilityLibrary.getInstance();

	protected FindElement() {

	}

	/**
	 * It returns the instance of the FindElement class
	 * 
	 * @author shivang.ahuja
	 * @return instance This is the instance of FindElement
	 */
	public static FindElement getInstance() {
		if (null == instance) {
			instance = new FindElement();
		}
		return instance;
	}

	/**
	 * This method will return a WebElement after testing its accessibility. If
	 * the accessibility is not enabled, this method will return the element
	 * normally without testing it for accessibility.
	 * 
	 * @author vimal.tyagi
	 * @param elementLocator
	 * @return WebElement
	 */
	public WebElement findElementWithAccessibility(By elementLocator) {
		sync.waitForElement(elementLocator);
		accLib.elementLevelAccessibilityTest(driver.findElement(elementLocator));
		return driver.findElement(elementLocator);
	}

	/**
	 * This method will return a list of WebElements after testing its
	 * accessibility. If the accessibility is not enabled, this method will
	 * return the element normally without testing it for accessibility.
	 * 
	 * @author shivang.ahuja
	 * @param elementLocator
	 * @return List of elements
	 */
	public List<WebElement> findElementsWithAccessibility(By elementLocator) {
		List<WebElement> elements = driver.findElements(elementLocator);
		for (int element = 0; element < elements.size(); element++) {
			sync.waitForElement(elementLocator);
			accLib.elementLevelAccessibilityTest(elements.get(element));
		}
		return elements;
	}
}
