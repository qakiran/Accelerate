package com.fiserv.framework.utility.selenium;

import org.openqa.selenium.By;

public class Locator {

	private By elementLocator;
	private static Locator instance = null;

	protected Locator() {

	}

	public static Locator getInstance() {
		if (null == instance) {
			instance = new Locator();
		}
		return instance;
	}

	/**
	 * @author dhiraj.bendale
	 */
	public void setLocator(By elementLocator) {
		this.elementLocator = elementLocator;
	}

	/**
	 * @author dhiraj.bendale
	 * @return
	 */
	public By getLocator() {
		return elementLocator;
	}

}
