/**
 * 
 */
package com.fiserv.framework.interfaces;

import org.openqa.selenium.By;
import org.openqa.selenium.ScreenOrientation;

/**
 * @author Dhiraj.Bendale
 *
 */
public interface IMobileAction {
	
	void click(By element);

	void tap(By element);
	
	void tap(int x, int y);
	
	void type(By locator, String textToInput, String description);
	
	void typeByKeyCode(By locator,String textToInput, String description);
	
	void longPress(By element);
	
	void closeKeybord();
	
	void goBack();
	
	void openMenu();
	
	void clearText(By element);
	
	void rotateScreen(final ScreenOrientation orientation);
	
	ITouchAction gestures();
	
	String getCurrentContext();
	
	void switchContext();
}
