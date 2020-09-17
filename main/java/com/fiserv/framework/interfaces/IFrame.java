/**
 * 
 */
package com.fiserv.framework.interfaces;

import org.openqa.selenium.By;

/**
 * @author Dhiraj.Bendale
 *
 */
public interface IFrame {
	
	void setDefaultFrame();

	void switchToFrame(By elementLocator);

	void switchToFrame(int frameIndex);

	void switchToFrame(String frameName);
}
