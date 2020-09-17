/**
 * 
 */
package com.fiserv.driverfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * AbstractApp which extends by mobile app
 * 
 * @author Mohammad.Nazim
 *
 */
public interface AbstractApp {

	public abstract DesiredCapabilities setAppDesiredCapabilities();

	public abstract WebDriver setAppProperties();

	public abstract WebDriver getPluginConnection();
}
