package com.fiserv.api.implementation;
/**
 * @author Piyuskumar.Rupareliya
 * @purpose to validate status code
 */

import org.apache.log4j.Logger;
import com.fiserv.framework.api.interfaces.IStatusCode;
import com.fiserv.api.utils.Comparison;

public class StatusCode implements IStatusCode{

	private int status;
	private static StatusCode instance = null;
	private static Logger logger = Logger.getLogger(StatusCode.class);
	private Comparison compare = Comparison.getInstance();

	protected StatusCode() {
		// Set access modifier protected for default constructor to achieve
		// Singleton Pattern
	}

	/**
	 * This function checks for currents class instance and returns one if
	 * present. If not instance available creates new instance and returns that.
	 * 
	 * @author Piyushkumar.Rupareliya
	 * @return Instance of the StatusCode
	 */
	public static StatusCode getInstance() {
		if (null == instance) {
			instance = new StatusCode();
		}
		return instance;
	}

	/**
	 * This function is setter method for response Status code
	 * 
	 * @author Piyushkumar.Rupareliya
	 * @param statusCode
	 *            Status Code as Integer
	 */
	public void setStatusCode(int statusCode) {
		this.status = statusCode;
		logger.debug("Response status code set : " + statusCode);
	}

	/**
	 * This function is getter method for response Status code
	 * 
	 * @author Piyushkumar.Rupareliya
	 * @return Status Code as Integer
	 */
	public int getStatusCode() {
		return status;
	}

	/**
	 * This function validates Response status code equal to expected value
	 * 
	 * @author Piyushkumar.Rupareliya
	 * @param expectedStatusCode
	 *            Expected Response status code as Object Type
	 * @param compareType
	 *            Pass true if you want to perform Equals To comparison, Else
	 *            pass false to perform Not Equals to Comparison
	 */
	public void isEqualTo(boolean compareType, Object expectedStatusCode) {
		logger.info("Validating response status code - Equal to");
		compare.isEqualsTo(compareType, expectedStatusCode, (Object) getStatusCode());
	}

}
