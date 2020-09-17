/**
 * 
 */
package com.fiserv.framework.interfaces;

import org.openqa.selenium.By;

/**
 * @author Dhiraj.Bendale
 *
 */
public interface IJavascriptExecute {
	void click(By elementLocator);

	void scrollDownTo(int scrollFrom, int scrollTo);

	void scrollToBottom();

	void scrollToElement(By elementLocator);

	void scrollToElementClick(By elementLocator);

	void sendKeysJS(By inputField,String value);
	
	void getTitleJS();
	
	void refreshPage();

	
}
