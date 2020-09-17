package com.fiserv.accessibility.framework;

import java.io.File;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import com.fiserv.framework.constants.FrameworkConstants;

public class GetHeadLessBrowser {
	private ClassLoader classLoader = getClass().getClassLoader();

	WebDriver driver = null;
	private static Logger logger = Logger.getLogger(GetHeadLessBrowser.class);

	/**
	 * Open headless chrome browser
	 * 
	 * @author vimal.tyagi
	 */

	public void openHeadLessBrowser() {
		File file = null;
		file = new File(classLoader.getResource(FrameworkConstants.getDesktopConfig().get("CHROME_DRIVER")).getFile());
		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
		ChromeOptions options = new ChromeOptions();
		options.addArguments("headless");
		options.addArguments("window-size=1200x600");
		driver = new ChromeDriver(options);
		logger.info("HeadLess browser open to get WCAG guideline.");
	}

	/**
	 * Get the WCAG guideline from deque university api page and close the
	 * browser.
	 * 
	 * @param url
	 * @author vimal.tyagi
	 */
	public String getWCAGGuideline(String url) {
		String guideline = null;
		driver.get(url);
		guideline = driver.findElement(By.xpath("//div[@class='wcagSc']")).getText().split("WCAG:")[1].trim();
		logger.info("Found WCAG Guideline : " + guideline);
		return guideline;
	}

	/**
	 * closed the headless browser instance
	 * 
	 * @author vimal.tyagi
	 */
	public void closeHeadlessBrowser() {
		driver.quit();
		logger.info("HeadLess browser closed.");
	}
}