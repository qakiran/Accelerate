package com.fiserv.elements;

import org.openqa.selenium.By;

import com.fiserv.accessibility.selenium.Dropdown;
import com.fiserv.accessibility.selenium.Elements;
import com.fiserv.accessibility.selenium.Table;
import com.fiserv.framework.interfaces.IDropdown;
import com.fiserv.framework.interfaces.IKeyboardAndMouseActions;
import com.fiserv.framework.interfaces.ITable;
import com.fiserv.selenium.KeyboardAndMouseActions;

public abstract class AbstractAccessibilityElements extends AbstractElements {
	protected Elements element = Elements.getInstance();

	@Override
	public IDropdown dropDown(By elementLocator) {
		locator.setLocator(elementLocator);
		return Dropdown.getInstance();
	}

	@Override
	public ITable table(By elementLocator) {
		return Table.getInstance();
	}

	@Override
	public IKeyboardAndMouseActions mouseActions(By elementLocator) {
		locator.setLocator(elementLocator);
		return KeyboardAndMouseActions.getInstance();
	}

	@Override
	public void getURL(String url) {
		element.getURL(url);
	}

	@Override
	public void sendKeys(By elementLocator, String value, String description) {
		element.sendKeys(elementLocator, value, description);
	}

	@Override
	public void click(By elementLocator, String description) {
		element.click(elementLocator, description);
	}

	@Override
	public void clear(By elementLocator) {
		element.clear(elementLocator);
	}

	@Override
	public String getText(By elementLocator) {
		return element.getText(elementLocator);
	}

	@Override
	public String getAttribute(By elementLocator, String attribute) {
		return element.getAttribute(elementLocator, attribute);
	}

	@Override
	public boolean isEnabled(By elementLocator) {
		return element.isEnabled(elementLocator);
	}

	@Override
	public boolean isDisplayed(By elementLocator) {
		return element.isDisplayed(elementLocator);
	}

	@Override
	public boolean isSelected(By elementLocator) {
		return element.isSelected(elementLocator);
	}

}
