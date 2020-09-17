
package com.fiserv.accessibility.selenium;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import com.aventstack.extentreports.Status;
import com.fiserv.framework.Report;
import com.fiserv.framework.interfaces.IKeyboardAndMouseActions;
import com.fiserv.framework.utility.selenium.Locator;

public class KeyboardAndMouseActions implements IKeyboardAndMouseActions {

	protected FindElement find = FindElement.getInstance();
	protected Locator locator = Locator.getInstance();
	private static Logger logger = Logger.getLogger(KeyboardAndMouseActions.class);
	private Actions builder = new Actions(find.driver);
	private static KeyboardAndMouseActions instance = null;
	private Report report = Report.getInstance();

	protected KeyboardAndMouseActions() {

	}

	/**
	 * It returns the instance of the BrowserMouseActions class
	 * 
	 * @return instance
	 * @author Vimal.Tyagi
	 */
	public static KeyboardAndMouseActions getInstance() {
		if (null == instance) {
			instance = new KeyboardAndMouseActions();
		}
		return instance;
	}

	/**
	 * It moves the mouse to the specified element.
	 * 
	 * @author Vimal.Tyagi
	 */
	public void moveTo() {
		builder.moveToElement(find.findElementWithAccessibility(locator.getLocator())).build().perform();
		logger.debug("Move to element using mouse actions..." + locator.getLocator());
		report.log("Method Pass - Moved to element ", "", Status.PASS);
	}

	/**
	 * It performs a right at the current mouse location.
	 * 
	 * @author Vimal.Tyagi
	 */
	public void rightClick() {
		builder.contextClick(find.findElementWithAccessibility(locator.getLocator())).build().perform();
		logger.debug("Righ Click on an element using mouse action..." + locator.getLocator());
		report.log("Method Pass - Right clicked on Element", "", Status.PASS);
	}

	/**
	 * It performs a double-click at the current mouse location.
	 * 
	 * @author Vimal.Tyagi
	 */
	public void doubleClick() {
		builder.doubleClick(find.findElementWithAccessibility(locator.getLocator())).build().perform();
		logger.debug("Double click on an element using mouse actions..." + locator.getLocator());
		report.log("Method Pass - Double clicked on element ", "", Status.PASS);
	}

	/**
	 * It performs click-and-hold at the location of the source element, moves
	 * to the location of the target element, then releases the mouse.
	 * 
	 * @author Vimal.Tyagi
	 */
	public void dragAndDrop(WebElement from, WebElement to) {
		builder.dragAndDrop(from, to).build().perform();
		report.log("Method Pass - Element Dragged and Dropped from" + from + " -> " + to, "", Status.PASS);
	}

	/**
	 * It allows the user to press the keys as needed from the keyboard except the Modifier keys e.g. : SHIFT, CONTROL and ALT
	 * 
	 * @param keyName
	 * @author Shivang.Ahuja 
	 */
	public void keyStroke(String keyName) {

		List<String> keyList = new ArrayList<>();

		Keys keys[] = Keys.values();
		for (Keys key : keys) {
			keyList.add(key.name());

		}

			if (keyList.contains(keyName.toUpperCase())) {
			Keys name = Keys.valueOf(keyName.toUpperCase());
			builder.sendKeys(name).build().perform();
			report.log("Keystroke completed:" + keyName,"", Status.PASS);
		}

	}

}
