package com.fiserv.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.fiserv.driverfactory.DriverFactory;
import com.fiserv.framework.Initialize;
import com.fiserv.framework.interfaces.IAlert;
import com.fiserv.framework.interfaces.IDropdown;
import com.fiserv.framework.interfaces.IElement;
import com.fiserv.framework.interfaces.IElementList;
import com.fiserv.framework.interfaces.IFrame;
import com.fiserv.framework.interfaces.IJavascriptExecute;
import com.fiserv.framework.interfaces.IKeyboardAndMouseActions;
import com.fiserv.framework.interfaces.ISynchronization;
import com.fiserv.framework.interfaces.ITable;
import com.fiserv.framework.interfaces.ITouchAction;
import com.fiserv.framework.interfaces.IWindows;
import com.fiserv.framework.utility.report.ExtentManager;
import com.fiserv.framework.utility.selenium.Locator;
import com.fiserv.selenium.Alerts;
import com.fiserv.selenium.Dropdown;
import com.fiserv.selenium.Elements;
import com.fiserv.selenium.ElementsList;
import com.fiserv.selenium.Frames;
import com.fiserv.selenium.JavascriptExecute;
import com.fiserv.selenium.KeyboardAndMouseActions;
import com.fiserv.selenium.Synchronization;
import com.fiserv.selenium.Table;
import com.fiserv.selenium.TouchActions;
import com.fiserv.selenium.Windows;

public abstract class AbstractElements implements IElement {
	Initialize init = Initialize.getInstance();
	protected WebDriver driver = DriverFactory.getInstance().getDriver();
	protected Elements elements = Elements.getInstance();
	protected Locator locator = Locator.getInstance();
	protected Synchronization browserSync = Synchronization.getInstance();
	protected ExtentManager extentManager = ExtentManager.getInstance();

	public IDropdown dropDown(By elementLocator) {
		locator.setLocator(elementLocator);
		return Dropdown.getInstance();
	}

	public IAlert alert() {
		return Alerts.getInstance();
	}

	public IJavascriptExecute jsExecute() {
		return JavascriptExecute.getInstance();
	}

	public ISynchronization sync() {
		return Synchronization.getInstance();
	}

	public IFrame frame() {
		return Frames.getInstance();
	}

	public IWindows window() {
		return Windows.getInstance();
	}

	public ITable table(By elementLocator) {
		locator.setLocator(elementLocator);
		return Table.getInstance();
	}

	public IKeyboardAndMouseActions mouseActions(By elementLocator) {
		locator.setLocator(elementLocator);
		return KeyboardAndMouseActions.getInstance();
	}

	public ITouchAction touchActions() {
		return TouchActions.getInstance();
	}

	public IElementList getListOfElement() {
		return ElementsList.getInstance();
	}

	public void getURL(String url) {
		elements.getURL(url);
	}

	public void sendKeys(By elementLocator, String value, String description) {
		elements.sendKeys(elementLocator, value, description);
	}

	public void click(By elementLocator, String description) {
		elements.click(elementLocator, description);
	}

	public void clear(By elementLocator) {
		elements.clear(elementLocator);
	}

	public String getText(By elementLocator) {
		return elements.getText(elementLocator);
	}

	public String getAttribute(By elementLocator, String attribute) {
		return elements.getAttribute(elementLocator, attribute);
	}

	public boolean isEnabled(By elementLocator) {
		return elements.isEnabled(elementLocator);
	}

	public boolean isDisplayed(By elementLocator) {
		return elements.isDisplayed(elementLocator);
	}

	public boolean isSelected(By elementLocator) {
		return elements.isSelected(elementLocator);
	}

}
