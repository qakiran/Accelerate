package com.fiserv.selenium;

import java.util.Iterator;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import com.fiserv.driverfactory.DriverFactory;
import com.fiserv.framework.interfaces.IWindows;

public class Windows implements IWindows {

	private static Windows instance = null;
	protected WebDriver driver = DriverFactory.getInstance().getDriver();
	protected Elements browserElements = Elements.getInstance();
	private static Logger logger = Logger.getLogger(Windows.class);
	protected Synchronization browserSync = Synchronization.getInstance();
	static String parentWindow;

	protected Windows() {
		// Auto-generated constructor stub
	}

	/**
	 * It returns the instance of the BrowserWindows class
	 * 
	 * @return instance
	 */
	public static Windows getInstance() {
		if (null == instance) {
			instance = new Windows();
		}
		return instance;
	}

	/**
	 * It takes the size of open windows ,iterates over the set of the windows
	 * which later switch to the desired window
	 * 
	 * @param elementLocator
	 *            The element locator
	 * @param timeOut
	 *            the number of windows to be opened
	 */

	public void switchToWindow(By elementLocator, int timeOut) {
		String currentHandle = "";
		String newWindowHandle = "";
		currentHandle = driver.getWindowHandle();
		browserElements.click(elementLocator, "");
		for (int windowsCnt = 0; windowsCnt < timeOut; windowsCnt++) {
			Set<String> allWindowHandles = driver.getWindowHandles();
			if (allWindowHandles.size() > 1) {
				for (String allHandlers : allWindowHandles) {
					if (!allHandlers.equals(currentHandle))
						newWindowHandle = allHandlers;
				}
				driver.switchTo().window(newWindowHandle);
				break;
			} else {
				browserSync.pause(1);
			}
		}
		if (currentHandle == newWindowHandle) {
			throw new NoSuchWindowException("Time out - No window found");
		}
	}

	/**
	 * It closes all the respective open windows and switch to the main window
	 * 
	 * @param titleMainWindow
	 *            used to get the main window title
	 */

	public void closeAllOpenWindow(String titleMainWindow) {
		String mainWindowHandle = "";
		logger.info("Closing all open windows.");
		Set<String> allWindowHandles = driver.getWindowHandles();
		for (String currentWindowHandle : allWindowHandles) {
			String windowTitle = driver.switchTo().window(currentWindowHandle).getTitle();
			if (windowTitle.equals(titleMainWindow)) {
				mainWindowHandle = currentWindowHandle;
			} else {
				driver.close();
			}
		}
		driver.switchTo().window(mainWindowHandle);
	}

	/**
	 * it returns the current window id
	 * 
	 * @return windowID
	 * 
	 * @author Vimal.Tyagi
	 */
	public String getCurrentWindowID() {
		logger.info("Getting the current window id.");
		parentWindow = driver.getWindowHandle();
		return parentWindow;
	}

	/**
	 * It takes the size of open windows ,iterates over the set of the windows
	 * and switch to them to validate desired window using page title.
	 * 
	 * @param pageTitle
	 * 
	 * @author Vimal.Tyagi
	 */
	public void switchToChildWindow(String pageTitle) {
		Set<String> allWindow = driver.getWindowHandles();
		Iterator<String> windows = allWindow.iterator();
		if (allWindow.size() > 1) {
			while (windows.hasNext()) {
				driver.switchTo().window(windows.next());
				logger.info("Switched to window :" + windows.next());
				browserSync.pause(2);
				if (driver.getTitle().equals(pageTitle))
					break;
			}
			logger.info("Switched to passed window, page title: " + pageTitle);
		}
	}

	/**
	 * Close the current window
	 * 
	 * @author Vimal.Tyagi
	 */

	public void closeWindow() {
		logger.info("Closing the current window.");
		driver.close();
	}

	/**
	 * it switch to the parent window
	 * 
	 * @author Vimal.Tyagi
	 */
	public void switchToParentWindow() {
		logger.info("Switching to parent window.");
		driver.switchTo().window(parentWindow);
		logger.info("you are on parent window.");

	}
}
