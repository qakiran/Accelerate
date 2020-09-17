/**
 * 
 */
package com.fiserv.selenium;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.Status;
import com.fiserv.driverfactory.DriverFactory;
import com.fiserv.framework.Report;
import com.fiserv.framework.interfaces.IKeyboardAndMouseActions;
import com.fiserv.framework.utility.selenium.Locator;

/**
 * @author Dhiraj.Bendale
 *
 */
public class KeyboardAndMouseActions implements IKeyboardAndMouseActions {

	protected WebDriver driver = DriverFactory.getInstance().getDriver();
	protected Locator locator = Locator.getInstance();
	private static Logger logger = Logger.getLogger(KeyboardAndMouseActions.class);
	private Actions builder = new Actions(driver);
	private static KeyboardAndMouseActions instance = null;
	private Report report = Report.getInstance();

	public KeyboardAndMouseActions() {

	}

	/**
	 * It returns the instance of the BrowserMouseActions class
	 * 
	 * @return instance
	 */
	public static KeyboardAndMouseActions getInstance() {
		if (null == instance) {
			instance = new KeyboardAndMouseActions();
		}
		return instance;
	}

	/**
	 * It moves the mouse to the specified element.
	 */
	public void moveTo() {
		builder.moveToElement(driver.findElement(locator.getLocator())).build().perform();
		logger.debug("Move to element using mouse actions..." + locator.getLocator());
		report.log("Method Pass - Moved to element ", "", Status.PASS);
	}

	public void rightClick() {
		builder.contextClick(driver.findElement(locator.getLocator())).build().perform();
		logger.debug("Righ Click on an element using mouse action..." + locator.getLocator());
		report.log("Method Pass - Right clicked on Element", "", Status.PASS);
	}

	public void doubleClick() {
		builder.doubleClick(driver.findElement(locator.getLocator())).build().perform();
		logger.debug("Double click on an element using mouse actions..." + locator.getLocator());
		report.log("Method Pass - Double clicked on element ", "", Status.PASS);
	}

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
