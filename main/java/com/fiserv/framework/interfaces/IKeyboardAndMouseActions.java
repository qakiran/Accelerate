package com.fiserv.framework.interfaces;

import org.openqa.selenium.WebElement;

public interface IKeyboardAndMouseActions {
	void moveTo();

	void dragAndDrop(WebElement from, WebElement to);

	public void keyStroke(String keyName);
}
