package com.fiserv.api.implementation;

/**
 * @author Piyuskumar.Rupareliya
 * @purpose to validate status line
 */

import org.apache.log4j.Logger;
import com.fiserv.framework.api.interfaces.IStatusLine;
import com.fiserv.api.utils.Comparison;

public class StatusLine implements IStatusLine{

	private String statusLineMsg = "";
	private static StatusLine instance = null;
	private static Logger logger = Logger.getLogger(StatusLine.class);
	private Comparison compare = Comparison.getInstance();

	protected StatusLine() {
		// Set access modifier protected for default constructor to achieve
		// Singleton Pattern
	}

	/**
	 * This function checks for currents class instance and returns one if
	 * present. If not instance available creates new instance and returns that.
	 * 
	 * @author Piyushkumar.Rupareliya
	 * @return Instance of the StatusLine
	 */
	public static StatusLine getInstance() {
		if (null == instance) {
			instance = new StatusLine();
		}
		return instance;
	}

	/**
	 * This function is setter method for response Status line
	 * 
	 * @author Piyushkumar.Rupareliya
	 * @param statusLine
	 *            Status line as String
	 */
	public void setStatusLine(String statusLine) {
		this.statusLineMsg = statusLine;
		logger.debug("Response status line set : " + statusLine);
	}

	/**
	 * This function is getter method for response Status line
	 * 
	 * @author Piyushkumar.Rupareliya
	 * @return Status line as String
	 */
	public String getStatusLine() {
		return statusLineMsg;
	}

	/**
	 * This function validates Response status line equal to expected value
	 * 
	 * @author Piyushkumar.Rupareliya
	 * @param expectedStatusLine
	 *            Expected Response status line as Object Type
	 * @param compareType
	 *            Pass true if you want to perform Equals To comparison, Else
	 *            pass false to perform Not Equals to Comparison
	 */
	public void isEqualTo(boolean compareType, Object expectedStatusLine) {
		logger.info("Validating response status line - Equals to");
		compare.isEqualsTo(compareType, expectedStatusLine, (Object) getStatusLine());
	}

	/**
	 * This function validates Response status line contains expected value
	 * 
	 * @author Piyushkumar.Rupareliya
	 * @param expectedStatusLine
	 *            Expected Response status line as String
	 */
	public void contains(String expectedStatusLine) {
		logger.info("Validating response status line - Contains");
		compare.contains(expectedStatusLine.trim(), getStatusLine().trim());
	}

}
