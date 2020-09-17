/**
 * 
 */
package com.fiserv.selenium;

import java.util.Set;
import org.apache.log4j.Logger;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import com.fiserv.driverfactory.DriverFactory;

import org.openqa.selenium.Cookie;

public class SelenuimUtility {

	private static SelenuimUtility instance = null;
	private static Logger logger = Logger.getLogger(SelenuimUtility.class);
	private WebDriver driver = DriverFactory.getInstance().getDriver();

	protected SelenuimUtility() {
		// Auto-generated constructor stub
	}

	/**
	 * It returns the instance of the BrowserUtility class
	 * 
	 * @return instance
	 */

	public static SelenuimUtility getInstance() {
		if (null == instance) {
			instance = new SelenuimUtility();
		}

		return instance;
	}

	/**
	 * Get title of the current page
	 * 
	 * @return pageTitle
	 * @author Vimal.Tyagi
	 */
	public String getTitle() {
		String pageTitle = driver.getTitle();
		logger.info("Page title is: " + pageTitle);
		return pageTitle;
	}

	/**
	 * Get the source of the last loaded page
	 * 
	 * @return pageSource
	 * @author Vimal.Tyagi
	 */
	public String getPageSource() {
		String pageSource = driver.getPageSource();
		logger.info("Page source is :" + pageSource);
		return pageSource;
	}

	/**
	 * Refresh/ Reload a web page
	 * 
	 * @author Vimal.Tyagi
	 */
	public void pageRefresh() {
		driver.navigate().refresh();
		logger.info("Current page refreshed.");
	}

	/**
	 * Navigating forward in browser history
	 * 
	 * @author Vimal.Tyagi
	 */
	public void forward() {
		driver.navigate().forward();
		logger.info("Naviagted forward in browser.");
	}

	/**
	 * Navigating backward in browser history
	 * 
	 * @author Vimal.Tyagi
	 */
	public void backward() {
		driver.navigate().back();
		logger.info("Naviagted back in browser.");
	}

	/**
	 * Get Current URL
	 * 
	 * @return url
	 * @author Vimal.Tyagi
	 */
	public String getCurrentURL() {
		String url = driver.getCurrentUrl();
		logger.info("Current url is : " + url);
		return url;
	}

	/**
	 * Set the window width and height
	 * 
	 * @param width
	 * @param height
	 * @author Vimal.Tyagi
	 */
	public void minimizeWindow(int width, int height) {
		logger.info("Setting the current window size.");
		Dimension dimension = new Dimension(width, height);
		driver.manage().window().setSize(dimension);
	}

	/**
	 * Maximizes the current window if it is not already maximized
	 * 
	 * @author Vimal.Tyagi
	 */
	public void maximize() {
		driver.manage().window().maximize();
		logger.info("Maximized the current window.");
	}

	/**
	 * Add a specific cookie
	 * 
	 * @param cookies
	 * @author Vimal.Tyagi
	 */
	public void addCookies(Cookie cookies) {
		logger.info("Adding the cookies.");
		driver.manage().addCookie(cookies);

	}

	/**
	 * Get all the cookies for the current domain.
	 * 
	 * @return cookies
	 * @author Vimal.Tyagi
	 */
	public Set<Cookie> getCookies() {
		logger.info("Getting the cookies.");
		return driver.manage().getCookies();
	}

	/**
	 * Delete all the cookies for the current domain.
	 * 
	 * @author Vimal.Tyagi
	 */
	public void deleteAllCookies() {
		logger.info("Deleting the cookies.");
		driver.manage().deleteAllCookies();
	}

	/**
	 * Delete a cookie from the browser's "cookie jar". The domain of the cookie
	 * will be ignored.
	 * 
	 * @param cookie
	 * @author Vimal.Tyagi
	 */
	public void deleteCookie(Cookie cookie) {
		logger.info("Deleting the cookie:  " + cookie);
		driver.manage().deleteCookie(cookie);
	}

	/**
	 * Delete the named cookie from the current domain.
	 * 
	 * @param cookie
	 * @author Vimal.Tyagi
	 */
	public void deleteCookie(String cookie) {
		logger.info("Deleting the cookie:  " + cookie);
		driver.manage().deleteCookieNamed(cookie);
	}
}
