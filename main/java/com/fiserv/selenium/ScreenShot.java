package com.fiserv.selenium;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.concurrent.TimeUnit;
import javax.imageio.ImageIO;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.fiserv.framework.constants.FrameworkConstants;
import com.fiserv.framework.constants.ReportConstants;
import com.fiserv.framework.utility.DateTime;

/**
 * 
 * @author Dhiraj.Bendale
 *
 */
public class ScreenShot {
	private static Logger logger = Logger.getLogger(ScreenShot.class);

	/**
	 * Capture the screenshot and store it in the specified location
	 * 
	 * @param driver
	 *            This is the WebDriver instance
	 * @return fileName.png The filename with .png extension where screenshot is
	 *         captured
	 */

	public String takeSnapShot(WebDriver driver) {
		String screenShotPath = "";
		String fileName = DateTime.getCurrentTime("ddMMyyyyhhmmss");
		try {
			if (FrameworkConstants.getExecutionOn().equalsIgnoreCase("desktop"))
				driver.manage().window().maximize();
			TimeUnit.SECONDS.sleep(1);
			screenShotPath = ReportConstants.getScreenshotLocation() + File.separator + fileName + ".png";
			File pngFile = new File(screenShotPath);
			File screenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			logger.info("Screenshot save at location: " + screenShotPath);
			FileUtils.copyFile(screenShot, pngFile);
		} catch (Exception e) {
			logger.error("Exception.. " + e.getMessage());
		}
		return fileName + ".png";
	}

	/**
	 * Capture WebElement the screenshot and store it in the specified location
	 * Calculate the width and height of the drop down element Create Rectangle
	 * of same width as of drop down Web Element
	 * 
	 * @param driver
	 *            This is the WebDriver instance
	 * @param element
	 * 
	 * @return fileName.png The filename with .png extension where screenshot is
	 *         captured
	 * @author Vimal.Tyagi
	 */
	public String takeSnapShot(WebDriver driver, WebElement element) {
		String fileName = DateTime.getCurrentTime("ddMMyyyyhhmmss");
		File screenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		Point p = element.getLocation();
		int width = element.getSize().getWidth();
		int height = element.getSize().getHeight();

		Rectangle rect = new Rectangle(width, height);
		BufferedImage img = null;
		try {
			img = ImageIO.read(screenShot);
			BufferedImage dest = img.getSubimage(p.getX(), p.getY(), rect.width, rect.height);
			ImageIO.write(dest, "png", screenShot);
			FileUtils.copyFile(screenShot, new File(ReportConstants.getScreenshotLocation() + File.separator
					+ "ElementScreenShot" + File.separator + fileName + ".png"));
		} catch (Exception e) {
			logger.error("Exception.. " + e.getMessage());
		}

		return fileName + ".png";
	}
}
