/**
 * 
 */
package com.fiserv.framework.interfaces;

import org.openqa.selenium.By;

/**
 * @author Dhiraj.Bendale
 *
 */
public interface IWindows {

	void switchToWindow(By elementLocator, int timeOut);

	void closeAllOpenWindow(String titleMainWindow);

	String getCurrentWindowID();

	void switchToChildWindow(String pageTitle);

	void switchToParentWindow();

	void closeWindow();

}
