/**
 * 
 */
package com.fiserv.framework.interfaces;

import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.Status;

/**
 * @author Dhiraj.Bendale
 *
 */
public interface IReport {
	
	void log(String message, String value, WebElement element, Status status);

	void log(String message, String value, Status status);
}
