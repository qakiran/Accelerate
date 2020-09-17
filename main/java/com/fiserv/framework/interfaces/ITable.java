/**
 * 
 */
package com.fiserv.framework.interfaces;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * @author Dhiraj.Bendale
 *
 */
public interface ITable {

	List<WebElement> getTable(By elementLocator);
}
