/**
 * 
 */
package com.fiserv.framework.interfaces;

import org.openqa.selenium.By;

/**
 * @author Dhiraj.Bendale
 *
 */
public interface ISynchronization {
	void pause(int sleep);

	void waitForSpinner(int waitTime);

	void waitForElement(By elementLocator);

	void waitForElementinTime(By elementLocator, int time);

	void elementToBeClickable(By elementLocator);

	void isElementClickableinTime(By elementLocator, int time);

	void waitForInvisibility(By elementLocator);

	void waitForInvisibilityinTime(By elementLocator, int time);

	void fluentWaitForElement(By elementLocator);

	void fluentWaitinTimeForElement(By elementLocator, int time);

}
